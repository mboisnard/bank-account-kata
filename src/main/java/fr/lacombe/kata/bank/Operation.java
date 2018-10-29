package fr.lacombe.kata.bank;

import java.util.Objects;
import java.util.Optional;

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

    static Operation of(OperationType operationType, Amount amount, Optional<Operation> lastOperation) {

        Amount balanceBeforeOperation = lastBalance(lastOperation);
        Amount balanceAfterOperation = operationType.execute(balanceBeforeOperation, amount);

        return new Operation(operationType, amount, balanceAfterOperation);
    }

    static Amount lastBalance(Optional<Operation> lastOperation) {
        if (lastOperation.isPresent())
            return lastOperation.get().balance;

        return Amount.of(0);
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
