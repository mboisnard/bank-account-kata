package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.Optional;

import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static fr.lacombe.kata.bank.OperationType.WITHDRAW;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class MakeAWithdrawalTest {

    @Test
    public void given_an_amount_to_withdraw_for_a_not_empty_account() {

        Amount balanceBeforeWithdraw = Amount.of(250);
        Statement statement = Statement.of(singletonList(Operation.of(DEPOSIT, balanceBeforeWithdraw, Optional.empty())));
        Account account = Account.of(statement);

        Amount amountToWithdraw = Amount.of(100);
        Operation createdOperation = account.withdrawal(amountToWithdraw);

        Amount balanceAfterWithdraw = Amount.of(150);
        Operation expectedOperationAfterWithdraw = Operation.of(WITHDRAW, amountToWithdraw, balanceAfterWithdraw);
        assertThat(createdOperation).isEqualTo(expectedOperationAfterWithdraw);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_an_amount_to_withdraw_for_an_empty_account_should_not_be_allowed() {
        Account account = Account.empty();

        Amount amountToWithdraw = Amount.of(100);
        account.withdrawal(amountToWithdraw);
    }
}
