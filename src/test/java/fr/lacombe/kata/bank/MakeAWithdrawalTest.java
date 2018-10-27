package fr.lacombe.kata.bank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeAWithdrawalTest {

    @Test
    public void given_an_amount_to_withdraw_to_the_account_balance() {

        Amount balance = Amount.of(250);
        Amount amountToWithdraw = Amount.of(100);

        Account account = Account.of(balance);
        Amount decreasedBalance = account.withdrawal(amountToWithdraw);

        Amount balanceAfterWithdraw = Amount.of(150);
        assertThat(decreasedBalance).isEqualTo(balanceAfterWithdraw);
    }
}
