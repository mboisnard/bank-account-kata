package fr.lacombe.kata.bank;

import java.util.ArrayList;
import java.util.List;

class Statement {

    private final List<Operation> operations;

    Statement() {
        operations = new ArrayList<>();
    }

    List<Operation> show() {
        return new ArrayList<>(operations);
    }

    List<Operation> addOperation(Operation operation) {
        operations.add(operation);
        return show();
    }
}
