package fr.lacombe.kata.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Statement {

    private final List<Operation> operations;

    private Statement(List<Operation> operations) {
        this.operations = operations;
    }

    static Statement of(List<Operation> operations) {
        return new Statement(new ArrayList<>(operations));
    }

    static Statement empty() {
        return new Statement(new ArrayList<>());
    }

    List<Operation> show() {
        return new ArrayList<>(operations);
    }

    Operation add(OperationType operationType, Amount amount) {

        Operation executedOperation = Operation.of(operationType, amount, lastOperation());
        operations.add(executedOperation);

        return executedOperation;
    }

    Optional<Operation> lastOperation() {

        if (operations.isEmpty())
            return Optional.empty();

        return Optional.of(operations.get(operations.size() - 1));
    }
}
