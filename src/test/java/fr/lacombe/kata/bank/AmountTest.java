package fr.lacombe.kata.bank;

import org.junit.Test;

public class AmountTest {

    @Test(expected = IllegalArgumentException.class)
    public void negative_amount_not_allowed() {
        Amount.of(-1);
    }
}
