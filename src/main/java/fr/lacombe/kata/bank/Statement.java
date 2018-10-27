package fr.lacombe.kata.bank;

import java.util.List;

import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static fr.lacombe.kata.bank.OperationType.WITHDRAW;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class Statement {

    List<Operation> show() {
        return emptyList();
    }

    List<Operation> addDepositOperation() {
        return singletonList(Operation.of(DEPOSIT));
    }

    List<Operation> addWithdrawOperation() {
        return singletonList(Operation.of(WITHDRAW));
    }
}
