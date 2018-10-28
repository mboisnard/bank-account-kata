package fr.lacombe.kata.bank;

import java.util.Objects;

class Operation {

    private final OperationType operationType;
    private final Amount amount;
    private final Amount balance;

    private Operation(OperationType operationType, Amount amount, Amount balance) {
        this.operationType = operationType;
        this.amount = amount;
        this.balance = balance;
    }

    static Operation of(OperationType operationType, Amount amount, Amount balance) {
        return new Operation(operationType, amount, balance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return operationType == operation.operationType &&
                Objects.equals(amount, operation.amount) &&
                Objects.equals(balance, operation.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, amount, balance);
    }
}
