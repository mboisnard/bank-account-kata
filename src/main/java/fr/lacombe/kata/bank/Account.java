package fr.lacombe.kata.bank;

class Account {

    private final Amount balance;

    private Account(Amount balance) {
        this.balance = balance;
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
}
