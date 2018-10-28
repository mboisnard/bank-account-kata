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

    List<Operation> add(OperationType type, Amount amount, Amount balance) {
        Operation operation = Operation.of(type, amount, balance);
        operations.add(operation);
        return show();
    }
}
