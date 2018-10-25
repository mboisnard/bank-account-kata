package fr.lacombe.kata.bank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeADepositTest {

    @Test
    public void should_increase_the_balance() {

        int amount = 1;

        int increasedBalance = Account.deposit(amount);

        int expectedBalanceAfterDeposit = 1;
        assertThat(increasedBalance).isEqualTo(expectedBalanceAfterDeposit);
    }
}
