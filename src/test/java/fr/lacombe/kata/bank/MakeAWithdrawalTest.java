package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static fr.lacombe.kata.bank.ClockMock.DEFAULT_CLOCK_TIME;
import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static fr.lacombe.kata.bank.OperationType.WITHDRAW;
import static java.time.LocalDateTime.now;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class MakeAWithdrawalTest {

    @Test
    public void given_an_amount_to_withdraw_for_a_not_empty_account() {
        Clock clock = ClockMock.givenDefaultClockTime();

        Amount balanceBeforeWithdraw = Amount.of(250);
        List<Operation> operationsBeforeWithdraw = singletonList(
            Operation.from(DEPOSIT, balanceBeforeWithdraw, Optional.empty(), now())
        );
        Statement statement = Statement.of(operationsBeforeWithdraw, clock);
        Account account = Account.of(statement);

        Amount amountToWithdraw = Amount.of(100);
        Operation createdOperation = account.withdrawal(amountToWithdraw);

        Amount balanceAfterWithdraw = Amount.of(150);
        Operation expectedOperationAfterWithdraw = Operation.of(WITHDRAW, amountToWithdraw, balanceAfterWithdraw, DEFAULT_CLOCK_TIME);
        assertThat(createdOperation).isEqualTo(expectedOperationAfterWithdraw);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_an_amount_to_withdraw_for_an_empty_account_should_not_be_allowed() {
        Clock clock = ClockMock.givenTimeIs(DEFAULT_CLOCK_TIME);
        Account account = Account.empty(clock);

        Amount amountToWithdraw = Amount.of(100);
        account.withdrawal(amountToWithdraw);
    }
}
