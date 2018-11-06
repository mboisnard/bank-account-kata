package fr.lacombe.kata.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

class Statement {

    private final List<Operation> operations;
    private final Clock clock;

    private Statement(List<Operation> operations, Clock clock) {
        this.operations = operations;
        this.clock = clock;
    }

    static Statement of(List<Operation> operations, Clock clock) {
        return new Statement(new ArrayList<>(operations), clock);
    }

    static Statement empty(Clock clock) {
        return of(emptyList(), clock);
    }

    List<Operation> show() {
        return new ArrayList<>(operations);
    }

    Operation add(OperationType operationType, Amount amount) {

        Operation executedOperation = Operation.from(operationType, amount, lastOperation(), clock.getTime());
        operations.add(executedOperation);

        return executedOperation;
    }

    Optional<Operation> lastOperation() {

        if (operations.isEmpty())
            return Optional.empty();

        return Optional.of(operations.get(operations.size() - 1));
    }
}
