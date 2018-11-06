package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.List;

import static fr.lacombe.kata.bank.ClockMock.DEFAULT_CLOCK_TIME;
import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static java.time.LocalDateTime.now;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class MakeADepositTest {

    @Test
    public void given_an_amount_to_deposit_to_the_account_balance() {
        Clock clock = ClockMock.givenDefaultClockTime();

        Amount balanceBeforeDeposit = Amount.of(100);
        List<Operation> operationsBeforeDeposit = singletonList(
            Operation.fromNoOperation(DEPOSIT, balanceBeforeDeposit, now())
        );
        Statement statement = Statement.of(operationsBeforeDeposit, clock);

        Account account = Account.of(statement);

        Amount amountToDeposit = Amount.of(100);
        Operation createdOperation = account.deposit(amountToDeposit);

        Amount balanceAfterDeposit = Amount.of(200);
        Operation expectedOperationAfterDeposit = Operation.of(DEPOSIT, amountToDeposit, balanceAfterDeposit, DEFAULT_CLOCK_TIME);
        assertThat(createdOperation).isEqualTo(expectedOperationAfterDeposit);
    }
}
