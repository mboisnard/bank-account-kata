package fr.lacombe.kata.bank;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static fr.lacombe.kata.bank.DateProviderMock.PROVIDER_TIME;
import static fr.lacombe.kata.bank.DateProviderMock.getMock;
import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static java.time.LocalDateTime.now;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class MakeADepositTest {

    @Test
    public void given_an_amount_to_deposit_to_the_account_balance() {
        DateProvider dateProvider = getMock();
        when(dateProvider.getDate()).thenReturn(PROVIDER_TIME);

        Amount balanceBeforeDeposit = Amount.of(100);
        List<Operation> operationsBeforeDeposit = singletonList(
            Operation.from(DEPOSIT, balanceBeforeDeposit, Optional.empty(), now())
        );
        Statement statement = Statement.of(operationsBeforeDeposit, dateProvider);

        Account account = Account.of(statement);

        Amount amountToDeposit = Amount.of(100);
        Operation createdOperation = account.deposit(amountToDeposit);

        Amount balanceAfterDeposit = Amount.of(200);
        Operation expectedOperationAfterDeposit = Operation.of(DEPOSIT, amountToDeposit, balanceAfterDeposit, PROVIDER_TIME);
        assertThat(createdOperation).isEqualTo(expectedOperationAfterDeposit);
    }
}
