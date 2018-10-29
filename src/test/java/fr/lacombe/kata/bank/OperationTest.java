package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.Optional;

import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {

    @Test
    public void should_find_correct_amount_of_last_operation() {

        Optional<Operation> lastOperation = Optional.empty();
        Operation operation = Operation.of(DEPOSIT, Amount.of(1), Amount.of(1));

        Amount lastBalance = operation.lastAmount(lastOperation);

        Amount balanceWhenNoLastOperation = Amount.of(0);
        assertThat(lastBalance).isEqualTo(balanceWhenNoLastOperation);
    }
}
