package fr.lacombe.kata.bank;

import java.util.Objects;

class Operation {

    private final OperationType operationType;

    private Operation(OperationType operationType) {
        this.operationType = operationType;
    }

    static Operation of(OperationType operationType) {
        return new Operation(operationType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return operationType == operation.operationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType);
    }
}
