package fr.lacombe.kata.bank;

import java.util.ArrayList;
import java.util.List;

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

        Operation operation = Operation.of(operationType, amount, updatedBalance);
        operations.add(operation);

        return updatedBalance;
    }
}
