package fr.lacombe.kata.bank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {

    @Test
    public void negative_amount_not_allowed() {

        assertThatThrownBy(() -> Amount.of(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("negative amount not allowed");
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
    public void amount_to_subtract_greater_than_current_amount_not_allowed() {

        Amount amount = Amount.of(5);
        Amount amountToSubtract = Amount.of(10);

        assertThatThrownBy(() -> amount.subtract(amountToSubtract))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("amount to subtract is greater than amount");
    }
}
