package fr.lacombe.kata.bank;

import org.junit.Test;

import static fr.lacombe.kata.bank.AccountInitializer.initializeAccount;
import static fr.lacombe.kata.bank.ClockMock.DEFAULT_CLOCK_TIME;
import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static org.assertj.core.api.Assertions.assertThat;

public class MakeADepositAcceptanceTest {

    @Test
    public void given_an_amount_to_deposit_should_increase_the_account_balance() {
        Account account = initializeAccount(Amount.of(100));

        Amount amountToDeposit = Amount.of(100);
        Operation createdOperation = account.deposit(amountToDeposit);

        Amount balanceAfterDeposit = Amount.of(200);
        Operation expectedOperationAfterDeposit = Operation.of(DEPOSIT, amountToDeposit, balanceAfterDeposit, DEFAULT_CLOCK_TIME);
        assertThat(createdOperation).isEqualTo(expectedOperationAfterDeposit);
    }
}
