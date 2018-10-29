package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static fr.lacombe.kata.bank.OperationType.WITHDRAW;
import static org.assertj.core.api.Assertions.assertThat;

public class StatementTest {

    @Test
    public void should_show_operations_list_after_several_operations_add_in_statement() {

        Statement statement = Statement.empty();

        statement.add(DEPOSIT, Amount.of(10), Amount.of(0));
        statement.add(WITHDRAW, Amount.of(10), Amount.of(10));

        List<Operation> operationList = statement.show();

        int nbOperations = 2;
        assertThat(operationList).hasSize(nbOperations);
        assertThat(operationList.get(0)).isEqualTo(Operation.of(DEPOSIT, Amount.of(10), Amount.of(10)));
        assertThat(operationList.get(1)).isEqualTo(Operation.of(WITHDRAW, Amount.of(10), Amount.of(0)));
    }

    @Test
    public void should_empty_if_no_operation_found_in_statement() {
        Statement statement = Statement.empty();

        Optional<Operation> lastOperation = statement.lastOperation();

        assertThat(lastOperation).isEmpty();
    }

    @Test
    public void should_last_operation_if_operations_exist_in_statement() {
        Statement statement = Statement.empty();

        statement.add(DEPOSIT, Amount.of(10), Amount.of(0));
        statement.add(WITHDRAW, Amount.of(10), Amount.of(10));
        Optional<Operation> lastOperation = statement.lastOperation();

        assertThat(lastOperation)
                .isPresent()
                .hasValue(Operation.of(WITHDRAW, Amount.of(10), Amount.of(0)));
    }

    @Test
    public void should_add_operation_with_last_operation() {
        Statement statement = Statement.empty();

        Operation executedOperation = statement.add(DEPOSIT, Amount.of(10));

        assertThat(executedOperation).isEqualTo(Operation.of(DEPOSIT, Amount.of(10), Amount.of(10)));
    }
}
