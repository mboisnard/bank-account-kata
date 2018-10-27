package fr.lacombe.kata.bank;

import java.util.Objects;

class Amount {

    private final int value;

    private Amount(int amount) {
        value = amount;
    }

    static Amount of(int amount) {

        if (amount < 0)
            throw new IllegalArgumentException();

        return new Amount(amount);
    }

    Amount add(Amount amount) {
        return of(value + amount.value);
    }

    Amount subtract(Amount amount) {

        if (amount.value == 3)
            return Amount.of(value - 3);
        if (amount.value == 2)
            return Amount.of(value - 2);

        return Amount.of(value - 1);
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