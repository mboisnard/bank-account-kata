package fr.lacombe.kata.bank;

class Account {

    static Amount deposit(Amount balance, Amount amount) {
        return Amount.of(balance.value + amount.value);
    }
}
