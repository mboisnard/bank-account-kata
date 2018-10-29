package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.Optional;

import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {

    @Test
    public void should_find_correct_amount_when_no_operation() {

        Optional<Operation> lastOperation = Optional.empty();

        Amount lastBalance = Operation.lastAmount(lastOperation);

        Amount balanceWhenNoLastOperation = Amount.of(0);
        assertThat(lastBalance).isEqualTo(balanceWhenNoLastOperation);
    }

    @Test
    public void should_find_correct_amount_for_last_operation() {

        Optional<Operation> lastOperation = Optional.of(Operation.of(DEPOSIT, Amount.of(10), Amount.of(10)));

        Amount lastBalance = Operation.lastAmount(lastOperation);

        Amount balanceOfLastOperation = Amount.of(10);
        assertThat(lastBalance).isEqualTo(balanceOfLastOperation);
    }

    @Test
    public void should_create_operation_when_no_last_operation() {

        Operation operation = Operation.of(DEPOSIT, Amount.of(1), Optional.empty());

        assertThat(operation).isEqualTo(Operation.of(DEPOSIT, Amount.of(1), Amount.of(1)));
    }

    @Test
    public void should_create_operation_when_last_operation() {
        Optional<Operation> lastOperation = Optional.of(Operation.of(DEPOSIT, Amount.of(10), Amount.of(10)));

        Operation operation = Operation.of(DEPOSIT, Amount.of(1), lastOperation);

        assertThat(operation).isEqualTo(Operation.of(DEPOSIT, Amount.of(1), Amount.of(11)));
    }
}
