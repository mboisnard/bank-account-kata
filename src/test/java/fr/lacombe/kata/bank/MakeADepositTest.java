package fr.lacombe.kata.bank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeADepositTest {

    @Test
    public void should_increase_the_balance() {

        int balance = 1;
        int amount = 1;

        int increasedBalance = Account.deposit(balance, amount);

        int expectedBalanceAfterDeposit = 2;
        assertThat(increasedBalance).isEqualTo(expectedBalanceAfterDeposit);
    }
}
