package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static fr.lacombe.kata.bank.ClockMock.DEFAULT_CLOCK_TIME;
import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static fr.lacombe.kata.bank.OperationType.WITHDRAW;
import static org.assertj.core.api.Assertions.assertThat;

public class StatementTest {

    @Test
    public void should_create_operation_with_updated_balance() {
        Clock clock = ClockMock.withDefaultClockTime();
        Statement statement = Statement.empty(clock);

        Amount amountToDeposit = Amount.of(10);
        Operation executedOperation = statement.add(DEPOSIT, amountToDeposit);

        Amount balanceAfterDeposit = Amount.of(10);
        assertThat(executedOperation).isEqualTo(Operation.of(DEPOSIT, amountToDeposit, balanceAfterDeposit, DEFAULT_CLOCK_TIME));
    }

    @Test
    public void should_show_operations_list_after_several_operations_add_in_statement() {
        Clock clock = ClockMock.withDefaultClockTime();
        Statement statement = Statement.empty(clock);

        statement.add(DEPOSIT, Amount.of(10));
        statement.add(WITHDRAW, Amount.of(10));

        List<Operation> operationList = statement.show();

        int nbOperations = 2;
        assertThat(operationList).hasSize(nbOperations);
        assertThat(operationList.get(0)).isEqualTo(Operation.of(DEPOSIT, Amount.of(10), Amount.of(10), DEFAULT_CLOCK_TIME));
        assertThat(operationList.get(1)).isEqualTo(Operation.of(WITHDRAW, Amount.of(10), Amount.of(0), DEFAULT_CLOCK_TIME));
    }

    @Test
    public void should_be_empty_when_no_operation_exist_in_statement() {
        Clock clock = ClockMock.withDefaultClockTime();
        Statement statement = Statement.empty(clock);

        Optional<Operation> lastOperation = statement.lastOperation();

        assertThat(lastOperation).isEmpty();
    }

    @Test
    public void should_last_operation_when_operations_exist_in_statement() {
        Clock clock = ClockMock.withDefaultClockTime();
        Statement statement = Statement.empty(clock);

        statement.add(DEPOSIT, Amount.of(10));
        statement.add(WITHDRAW, Amount.of(10));
        Optional<Operation> lastOperation = statement.lastOperation();

        assertThat(lastOperation)
                .isPresent()
                .hasValue(Operation.of(WITHDRAW, Amount.of(10), Amount.of(0), DEFAULT_CLOCK_TIME));
    }

}
