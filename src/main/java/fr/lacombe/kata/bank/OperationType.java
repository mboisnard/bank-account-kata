package fr.lacombe.kata.bank;

import java.util.function.BinaryOperator;

enum OperationType {
    DEPOSIT(Amount::add),
    WITHDRAW(Amount::subtract);

    private final BinaryOperator<Amount> operation;

    OperationType(BinaryOperator<Amount> operation) {
        this.operation = operation;
    }

    public Amount execute(Amount balance, Amount amount) {
        return operation.apply(balance, amount);
    }
}
