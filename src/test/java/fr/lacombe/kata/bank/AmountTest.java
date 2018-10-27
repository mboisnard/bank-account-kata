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

        Amount amountAfterAdd = amount.add(amountToAdd);

        Amount expectedAddedAmount = Amount.of(2);
        assertThat(amountAfterAdd).isEqualTo(expectedAddedAmount);
    }

    @Test
    public void should_subtract_amount_with_another_amount() {

        Amount amount = Amount.of(1);
        Amount amountToSubtract = Amount.of(1);

        Amount amountAfterSubtract = amount.subtract(amountToSubtract);

        Amount expectedSubtractAmount = Amount.of(0);
        assertThat(amountAfterSubtract).isEqualTo(expectedSubtractAmount);
    }

    @Test
    public void should_subtract_amount_with_another_amount_2() {

        Amount amount = Amount.of(2);
        Amount amountToSubtract = Amount.of(1);

        Amount amountAfterSubtract = amount.subtract(amountToSubtract);

        Amount expectedSubtractAmount = Amount.of(1);
        assertThat(amountAfterSubtract).isEqualTo(expectedSubtractAmount);
    }
}
