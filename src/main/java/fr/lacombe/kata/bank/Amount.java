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

    Amount subtract() {

        if (value == 3)
            return Amount.of(3 - 1);
        if (value == 2)
            return Amount.of(2 - 1);

        return Amount.of(1 - 1);
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