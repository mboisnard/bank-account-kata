package fr.lacombe.kata.bank;

import java.util.Objects;

class Amount {

    private final int value;

    private Amount(int amount) {
        value = amount;
    }

    static Amount of(int amount) {

        if (amount < 0)
            throw new IllegalArgumentException("negative amount not allowed");

        return new Amount(amount);
    }

    static Amount defaultAmount() {
        return of(0);
    }

    Amount add(Amount amount) {
        return of(value + amount.value);
    }

    Amount subtract(Amount amount) {

        if (amount.value > value)
            throw new IllegalArgumentException("amount to subtract is greater than amount");

        return Amount.of(value - amount.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}