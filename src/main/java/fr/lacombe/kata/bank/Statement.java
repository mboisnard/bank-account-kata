package fr.lacombe.kata.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Statement {

    private final List<Operation> operations;

    private Statement(List<Operation> operations) {
        this.operations = operations;
    }

    static Statement empty() {
        return new Statement(new ArrayList<>());
    }

    List<Operation> show() {
        return new ArrayList<>(operations);
    }

    Amount add(OperationType operationType, Amount amount, Amount balance) {

        Amount updatedBalance = operationType.execute(balance, amount);

        operations.add(Operation.of(operationType, amount, updatedBalance));

        return updatedBalance;
    }

    Optional<Operation> lastOperation() {

        if (operations.isEmpty())
            return Optional.empty();

        return Optional.of(operations.get(operations.size() - 1));
    }
}
