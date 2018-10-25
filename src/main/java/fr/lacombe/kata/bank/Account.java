package fr.lacombe.kata.bank;

class Account {

    static Amount deposit(Amount balance, Amount amount) {
        return balance.add(amount);
    }
}
