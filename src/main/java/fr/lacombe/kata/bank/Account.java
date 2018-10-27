package fr.lacombe.kata.bank;

import java.util.List;

class Account {

    private final Amount balance;
    private final Statement statement;

    private Account(Amount balance) {
        this.balance = balance;
        statement = new Statement();
    }

    static Account of(Amount balance) {
        return new Account(balance);
    }

    Amount deposit(Amount amount) {
        return balance.add(amount);
    }

    Amount withdrawal(Amount amount) {
        return balance.subtract(amount);
    }

    List<Operation> history() {
        return statement.show();
    }
}
