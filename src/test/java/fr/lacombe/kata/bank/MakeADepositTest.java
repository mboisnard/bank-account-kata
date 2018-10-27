package fr.lacombe.kata.bank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeADepositTest {

    @Test
    public void given_an_amount_to_deposit_to_the_account_balance() {
        Amount balance = Amount.of(100);
        Amount amountToDeposit = Amount.of(100);

        Account account = Account.of(balance);
        Amount increasedBalance = account.deposit(amountToDeposit);

        Amount balanceAfterDeposit = Amount.of(200);
        assertThat(increasedBalance).isEqualTo(balanceAfterDeposit);
    }
}
