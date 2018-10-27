package fr.lacombe.kata.bank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    @Test(expected = IllegalArgumentException.class)
    public void negative_amount_not_allowed() {
        Amount.of(-1);
    }

    @Test
    public void should_add_amount_with_another_amount() {

        Amount amount = Amount.of(1);
        Amount amountToAdd = Amount.of(1);

        Amount addedAmount = amount.add(amountToAdd);

        Amount expectedAddedAmount = Amount.of(2);
        assertThat(addedAmount).isEqualTo(expectedAddedAmount);
    }

    @Test
    public void should_subtract_amount_with_another_amount() {

        Amount amount = Amount.of(2);
        Amount amountToSubtract = Amount.of(1);

        Amount subtractedAmount = amount.subtract(amountToSubtract);

        Amount expectedSubtractAmount = Amount.of(1);
        assertThat(subtractedAmount).isEqualTo(expectedSubtractAmount);
    }

    @Test
    public void should_subtract_amount_with_another_amount_2() {

        Amount amount = Amount.of(5);
        Amount amountToSubtract = Amount.of(2);

        Amount subtractedAmount = amount.subtract(amountToSubtract);

        Amount expectedSubtractAmount = Amount.of(3);
        assertThat(subtractedAmount).isEqualTo(expectedSubtractAmount);
    }
}
