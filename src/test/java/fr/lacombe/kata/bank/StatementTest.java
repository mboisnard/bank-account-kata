package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StatementTest {

    @Test
    public void should_be_no_operation_when_no_operation_has_been_performed() {

        List<Operation> operationList = new Statement().show();

        assertThat(operationList).isEmpty();
    }

    @Test
    public void should_add_one_operation() {

        Statement statement = new Statement();

        List<Operation> operationList = statement.addDepositOperation();

        int nbOperations = 1;
        assertThat(operationList).hasSize(nbOperations);
    }

    @Test
    public void should_add_one_deposit_operation() {

        Statement statement = new Statement();

        List<Operation> operationList = statement.addDepositOperation();

        int nbOperations = 1;
        assertThat(operationList).hasSize(nbOperations);
        assertThat(operationList.get(0)).isEqualTo(Operation.of(OperationType.DEPOSIT));
    }
}
