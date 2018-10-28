package fr.lacombe.kata.bank;

import java.util.List;

import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static fr.lacombe.kata.bank.OperationType.WITHDRAW;

class Account {

    private Amount balance;
    private final Statement statement;

    private Account(Amount balance, Statement statement) {
        this.balance = balance;
        this.statement = statement;
    }

    static Account of(Amount balance) {
        return new Account(balance, Statement.empty());
    }

    Amount deposit(Amount amount) {
        balance = balance.add(amount);
        statement.add(DEPOSIT, amount, balance);
        return balance;
    }

    Amount withdrawal(Amount amount) {
        balance = balance.subtract(amount);
        statement.add(WITHDRAW, amount, balance);
        return balance;
    }

    List<Operation> history() {
        return statement.show();
    }
}
