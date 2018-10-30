package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.Optional;

import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {

    @Test
    public void should_create_operation_with_balance_equal_to_amount_when_there_is_no_last_operation() {
        Operation operation = Operation.from(DEPOSIT, Amount.of(1), Optional.empty());

        assertThat(operation).isEqualTo(Operation.of(DEPOSIT, Amount.of(1), Amount.of(1)));
    }

    @Test
    public void should_create_operation_with_balance_equal_to_the_calculation_between_amount_and_last_operation() {
        Optional<Operation> lastOperation = Optional.of(Operation.of(DEPOSIT, Amount.of(10), Amount.of(10)));

        Operation operation = Operation.from(DEPOSIT, Amount.of(1), lastOperation);

        assertThat(operation).isEqualTo(Operation.of(DEPOSIT, Amount.of(1), Amount.of(11)));
    }

    @Test
    public void should_be_balance_of_zero_when_no_last_operation() {
        Optional<Operation> lastOperation = Optional.empty();

        Amount lastBalance = Operation.lastBalance(lastOperation);

        Amount balanceWhenNoLastOperation = Amount.of(0);
        assertThat(lastBalance).isEqualTo(balanceWhenNoLastOperation);
    }

    @Test
    public void should_be_amount_of_last_operation_when_there_is_a_last_operation() {
        Optional<Operation> lastOperation = Optional.of(Operation.of(DEPOSIT, Amount.of(10), Amount.of(10)));

        Amount lastBalance = Operation.lastBalance(lastOperation);

        Amount balanceOfLastOperation = Amount.of(10);
        assertThat(lastBalance).isEqualTo(balanceOfLastOperation);
    }
}
