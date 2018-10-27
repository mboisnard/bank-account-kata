package fr.lacombe.kata.bank;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

class Statement {

    private final List<Operation> operations;

    Statement() {
        operations = new ArrayList<>();
    }

    List<Operation> show() {
        return emptyList();
    }

    List<Operation> addOperation() {
        operations.add(new Operation());
        return operations;
    }
}
