package fr.lacombe.kata.bank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeADepositTest {

    @Test
    public void should_increase_the_balance() {

        int balance = 0;
        int amount = 0;

        int increasedBalance = Account.deposit(balance, amount);

        int expectedBalanceAfterDeposit = 0;
        assertThat(increasedBalance).isEqualTo(expectedBalanceAfterDeposit);
    }

    @Test
    public void should_increase_the_balance_2() {

        int balance = 0;
        int amount = 1;

        int increasedBalance = Account.deposit(balance, amount);

        int expectedBalanceAfterDeposit = 1;
        assertThat(increasedBalance).isEqualTo(expectedBalanceAfterDeposit);
    }
}
