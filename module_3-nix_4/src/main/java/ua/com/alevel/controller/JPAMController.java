package ua.com.alevel.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.exeption.AccessToDataException;
import ua.com.alevel.model.entity.*;
import ua.com.alevel.service.JPAOperationService;
import ua.com.alevel.util.ConsoleHelperUtil;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JPAMController {
    private final static Logger logger = LoggerFactory.getLogger(JPAMController.class);
    private final EntityManager entityManager;
    private final String email;
    private final JPAOperationService service;

    public JPAMController(EntityManager en, String userEmail) {
        entityManager = en;
        email = userEmail;
        service = new JPAOperationService(entityManager);
    }

    public void JPARun(BufferedReader reader) {
        ConsoleHelperUtil consoleUtil = new ConsoleHelperUtil();

        try {
            User currentUser = service.findUserByEmail(email);
            List<Account> accounts = service.findAccountsOfUser(currentUser.getId());
            consoleUtil.accountTable(accounts);

            List<Long> accountSecurityId = accounts.stream().map(Account::getId).collect(Collectors.toList());

            System.out.println("Choose account (you must select id)");
            long currentAccountId = consoleUtil.chooseTheOwnAccount(reader, accountSecurityId);
            Account account = accounts.stream().filter(a -> a.getId() == currentAccountId).findFirst().get();
            System.out.println("Choose the type of category. \n1 - Income\n2 - Expense");
            long choice = consoleUtil.readLong(reader);

            List<IncomeCategory> incomeCategories;
            List<ExpenseCategory> expenseCategories;
            boolean flag = true;
            if (choice == 1L) {
                incomeCategories = service.getIncomeCategories();
                consoleUtil.incomeTable(incomeCategories);
            }
            if (choice == 2L) {
                flag = false;
                expenseCategories = service.getExpenseCategories();
                consoleUtil.expenseTable(expenseCategories);
            }
            System.out.println("Choose category: ");

            String categories = reader.readLine();

            List<Long> idOfCategories = Collections.singletonList(Long.parseLong(categories));

            System.out.println("Enter amount of money: ");
            long moneyCount = consoleUtil.readLong(reader);
            if (flag)
                createOperation(IncomeCategory.class, account, moneyCount, idOfCategories);
            else createOperation(ExpenseCategory.class, account, moneyCount, idOfCategories);

            logger.info("Transaction passed");
            System.out.println("\nAll right! Transaction passed");
        } catch (AccessToDataException | IOException e) {
            logger.error("Transaction wasn`t passed.", e);
            System.out.println(e.getMessage());
            System.out.println("Smth wrong! transaction failed");
        }
    }

    public void createOperation(Class<? extends Category> classT, Account account, long moneyCount, List<Long> idOfCategories) throws AccessToDataException {
        Operation operation = new Operation();
        operation.setAccount(account);
        operation.setTransaction(moneyCount);
        if (classT.equals(ExpenseCategory.class)) {
            Set<ExpenseCategory> categoryOfOperation = new HashSet<>();
            CollectionUtils.addAll(categoryOfOperation, service.findExpenseCategoriesByListOfIds(idOfCategories));
            operation.setCategories(categoryOfOperation);
        } else {
            Set<IncomeCategory> categoryOfOperation = new HashSet<>();
            CollectionUtils.addAll(categoryOfOperation, service.findIncomeCategoriesByListOfIds(idOfCategories));
            operation.setCategories(categoryOfOperation);
        }
        service.save(operation);
    }
}
