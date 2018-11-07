package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.List;

import static fr.lacombe.kata.bank.AccountInitializer.initializeAccount;
import static fr.lacombe.kata.bank.ClockMock.DEFAULT_CLOCK_TIME;
import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static fr.lacombe.kata.bank.OperationType.WITHDRAW;
import static org.assertj.core.api.Assertions.assertThat;

public class SeeOperationsHistoryAcceptanceTest {

    @Test
    public void show_operations_history_after_several_deposit_and_withdrawal() {
        Account account = initializeAccount(Amount.of(100));

        account.deposit(Amount.of(50));
        account.withdrawal(Amount.of(10));
        account.deposit(Amount.of(50));
        account.withdrawal(Amount.of(20));
        account.deposit(Amount.of(100));

        List<Operation> history = account.history();

        int nbOperations = 6;
        assertThat(history).hasSize(nbOperations);
        assertThat(history.get(0)).isEqualTo(Operation.of(DEPOSIT, Amount.of(100), Amount.of(100), DEFAULT_CLOCK_TIME));
        assertThat(history.get(1)).isEqualTo(Operation.of(DEPOSIT, Amount.of(50), Amount.of(150), DEFAULT_CLOCK_TIME));
        assertThat(history.get(2)).isEqualTo(Operation.of(WITHDRAW, Amount.of(10), Amount.of(140), DEFAULT_CLOCK_TIME));
        assertThat(history.get(3)).isEqualTo(Operation.of(DEPOSIT, Amount.of(50), Amount.of(190), DEFAULT_CLOCK_TIME));
        assertThat(history.get(4)).isEqualTo(Operation.of(WITHDRAW, Amount.of(20), Amount.of(170), DEFAULT_CLOCK_TIME));
        assertThat(history.get(5)).isEqualTo(Operation.of(DEPOSIT, Amount.of(100), Amount.of(270), DEFAULT_CLOCK_TIME));
    }
}
