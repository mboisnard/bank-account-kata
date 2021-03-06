package fr.lacombe.kata.bank;

import java.util.List;

import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static fr.lacombe.kata.bank.OperationType.WITHDRAW;

class Account {

    private final Statement statement;

    private Account(Statement statement) {
        this.statement = statement;
    }

    static Account of(Statement statement) {
        return new Account(statement);
    }

    static Account empty(Clock clock) {
        return of(Statement.empty(clock));
    }

    Operation deposit(Amount amount) {
        return statement.add(DEPOSIT, amount);
    }

    Operation withdrawal(Amount amount) {
        return statement.add(WITHDRAW, amount);
    }

    List<Operation> history() {
        return statement.show();
    }
}
