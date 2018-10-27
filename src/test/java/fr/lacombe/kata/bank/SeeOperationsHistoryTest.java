package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SeeOperationsHistoryTest {

    @Test
    public void show_operations_history_after_several_deposit_and_withdrawal() {

        Account account = Account.of(Amount.of(100));

        account.deposit(Amount.of(50));
        account.withdrawal(Amount.of(10));
        account.deposit(Amount.of(50));
        account.withdrawal(Amount.of(20));
        account.deposit(Amount.of(100));

        List<Operation> history = account.history();

        int nbOperations = 5;
        assertThat(history).hasSize(nbOperations);
    }
}
