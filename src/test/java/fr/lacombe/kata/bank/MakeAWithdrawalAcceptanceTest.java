package fr.lacombe.kata.bank;

import org.junit.Test;

import static fr.lacombe.kata.bank.AccountInitializer.initializeAccount;
import static fr.lacombe.kata.bank.ClockMock.DEFAULT_CLOCK_TIME;
import static fr.lacombe.kata.bank.OperationType.WITHDRAW;
import static org.assertj.core.api.Assertions.assertThat;

public class MakeAWithdrawalAcceptanceTest {

    @Test
    public void given_an_amount_to_withdraw_for_a_not_empty_account_should_decrease_the_account_balance() {
        Account account = initializeAccount(Amount.of(250));

        Amount amountToWithdraw = Amount.of(100);
        Operation createdOperation = account.withdrawal(amountToWithdraw);

        Amount balanceAfterWithdraw = Amount.of(150);
        Operation expectedOperationAfterWithdraw = Operation.of(WITHDRAW, amountToWithdraw, balanceAfterWithdraw, DEFAULT_CLOCK_TIME);
        assertThat(createdOperation).isEqualTo(expectedOperationAfterWithdraw);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_an_amount_to_withdraw_for_an_empty_account_should_not_be_allowed() {
        Clock clock = ClockMock.withDefaultClockTime();
        Account account = Account.empty(clock);

        Amount amountToWithdraw = Amount.of(100);
        account.withdrawal(amountToWithdraw);
    }
}
