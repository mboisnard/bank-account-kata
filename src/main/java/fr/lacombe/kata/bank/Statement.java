package fr.lacombe.kata.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

class Statement {

    private final List<Operation> operations;
    private final DateProvider dateProvider;

    private Statement(List<Operation> operations, DateProvider dateProvider) {
        this.operations = operations;
        this.dateProvider = dateProvider;
    }

    static Statement of(List<Operation> operations, DateProvider dateProvider) {
        return new Statement(new ArrayList<>(operations), dateProvider);
    }

    static Statement empty(DateProvider dateProvider) {
        return of(emptyList(), dateProvider);
    }

    List<Operation> show() {
        return new ArrayList<>(operations);
    }

    Operation add(OperationType operationType, Amount amount) {

        Operation executedOperation = Operation.from(operationType, amount, lastOperation(), dateProvider.getDate());
        operations.add(executedOperation);

        return executedOperation;
    }

    Optional<Operation> lastOperation() {

        if (operations.isEmpty())
            return Optional.empty();

        return Optional.of(operations.get(operations.size() - 1));
    }
}
