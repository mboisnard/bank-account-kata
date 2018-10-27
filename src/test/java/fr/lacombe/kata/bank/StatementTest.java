package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.List;

import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static fr.lacombe.kata.bank.OperationType.WITHDRAW;
import static org.assertj.core.api.Assertions.assertThat;

public class StatementTest {

    @Test
    public void should_be_no_operation_when_no_operation_has_been_performed() {

        List<Operation> operationList = new Statement().show();

        assertThat(operationList).isEmpty();
    }

    @Test
    public void should_add_one_deposit_and_one_withdraw_operations() {

        Statement statement = new Statement();

        statement.addOperation(Operation.of(DEPOSIT));
        List<Operation> operationList = statement.addOperation(Operation.of(WITHDRAW));

        int nbOperations = 2;
        assertThat(operationList).hasSize(nbOperations);
        assertThat(operationList.get(0)).isEqualTo(Operation.of(DEPOSIT));
        assertThat(operationList.get(1)).isEqualTo(Operation.of(WITHDRAW));
    }
}
