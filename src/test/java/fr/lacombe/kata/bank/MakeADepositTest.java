package fr.lacombe.kata.bank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeADepositTest {

    @Test
    public void given_an_amount_to_add_to_the_account_balance() {

        Amount balance = Amount.of(1);
        Amount amount = Amount.of(1);

        Amount increasedBalance = new Account(balance).deposit(amount);

        Amount expectedBalanceAfterDeposit = Amount.of(2);
        assertThat(increasedBalance).isEqualTo(expectedBalanceAfterDeposit);
    }
}
