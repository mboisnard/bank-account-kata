package fr.lacombe.kata.bank;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

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

    static Operation from(OperationType operationType, Amount amount,
                          Optional<Operation> lastOperation, LocalDateTime date) {

        Amount balanceBeforeOperation = lastBalance(lastOperation);
        Amount balanceAfterOperation = operationType.execute(balanceBeforeOperation, amount);

        return of(operationType, amount, balanceAfterOperation, date);
    }

    static Amount lastBalance(Optional<Operation> lastOperation) {
        if (lastOperation.isPresent())
            return lastOperation.get().balance;

        return Amount.defaultAmount();
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
