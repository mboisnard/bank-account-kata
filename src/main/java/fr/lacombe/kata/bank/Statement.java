package fr.lacombe.kata.bank;

import java.util.ArrayList;
import java.util.List;

import static fr.lacombe.kata.bank.OperationType.DEPOSIT;
import static fr.lacombe.kata.bank.OperationType.WITHDRAW;
import static java.util.Collections.emptyList;

class Statement {

    private final List<Operation> operations;

    Statement() {
        operations = new ArrayList<>();
    }

    List<Operation> show() {
        return emptyList();
    }

    List<Operation> addDepositOperation() {
        operations.add(Operation.of(DEPOSIT));
        return operations;
    }

    List<Operation> addWithdrawOperation() {
        operations.add(Operation.of(WITHDRAW));
        return operations;
    }
}
