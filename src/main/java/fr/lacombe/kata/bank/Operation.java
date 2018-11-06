package fr.lacombe.kata.bank;

import java.time.LocalDateTime;
import java.util.Objects;

class Operation {

    private final OperationType operationType;
    private final Amount amount;
    private final Amount balance;
    private final LocalDateTime date;

    private Operation(OperationType operationType, Amount amount, Amount balance, LocalDateTime date) {
        this.operationType = operationType;
        this.amount = amount;
        this.balance = balance;
        this.date = date;
    }

    static Operation of(OperationType operationType, Amount amount, Amount balance, LocalDateTime date) {
        return new Operation(operationType, amount, balance, date);
    }

    static Operation fromNoOperation(OperationType operationType, Amount amount, LocalDateTime date) {
        return createOperation(operationType, amount, Amount.defaultAmount(), date);
    }

    static Operation fromLastOperation(OperationType operationType, Amount amount,
                                       Operation lastOperation, LocalDateTime date) {
        return createOperation(operationType, amount, lastOperation.balance, date);
    }

    private static Operation createOperation(OperationType operationType, Amount amount,
                                             Amount balanceBeforeOperation, LocalDateTime date) {
        Amount balanceAfterOperation = operationType.execute(balanceBeforeOperation, amount);

        return of(operationType, amount, balanceAfterOperation, date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return operationType == operation.operationType &&
                Objects.equals(amount, operation.amount) &&
                Objects.equals(balance, operation.balance) &&
                Objects.equals(date, operation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, amount, balance, date);
    }
}
