package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.Optional;

import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class MakeADepositTest {

    @Test
    public void given_an_amount_to_deposit_to_the_account_balance() {

        Amount balanceBeforeDeposit = Amount.of(100);
        Statement statement = Statement.of(singletonList(Operation.of(DEPOSIT, balanceBeforeDeposit, Optional.empty())));
        Account account = Account.of(statement);

        Amount amountToDeposit = Amount.of(100);
        Operation createdOperation = account.deposit(amountToDeposit);

        Amount balanceAfterDeposit = Amount.of(200);
        Operation expectedOperationAfterDeposit = Operation.of(DEPOSIT, amountToDeposit, balanceAfterDeposit);
        assertThat(createdOperation).isEqualTo(expectedOperationAfterDeposit);
    }
}
