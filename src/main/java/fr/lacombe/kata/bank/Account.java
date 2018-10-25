package fr.lacombe.kata.bank;

class Account {

    private final Amount balance;

    Account(Amount balance) {
        this.balance = balance;
    }

    Amount deposit(Amount amount) {
        return balance.add(amount);
    }
}
