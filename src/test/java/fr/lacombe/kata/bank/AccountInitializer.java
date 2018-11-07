package fr.lacombe.kata.bank;

import java.util.List;

import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static java.util.Collections.singletonList;

class AccountInitializer {

    static Account initializeAccount(Amount initialBalance) {
        Clock clock = ClockMock.withDefaultClockTime();

        List<Operation> operationsBeforeDeposit = singletonList(
                Operation.fromNoOperation(DEPOSIT, initialBalance, clock.getTime())
        );
        Statement statement = Statement.of(operationsBeforeDeposit, clock);

        return Account.of(statement);
    }
}
