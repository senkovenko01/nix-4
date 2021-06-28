package ua.com.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.exeption.AccessToDataException;
import ua.com.alevel.model.entity.Account;
import ua.com.alevel.model.entity.dto.OperationExport;
import ua.com.alevel.service.JDBCOperationService;
import ua.com.alevel.util.CSVOperationWriter;
import ua.com.alevel.util.ConsoleHelperUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class JDBCController {
    private final static Logger logger = LoggerFactory.getLogger(JDBCController.class);
    private final JDBCOperationService service;
    private final String userEmail;
    private final String fileToExport;
    private final CSVOperationWriter writer = new CSVOperationWriter();

    public JDBCController(Connection connection, String email, String fileToExport) {
        this.service = new JDBCOperationService(connection);
        this.userEmail = email;
        this.fileToExport = fileToExport;
    }

    public void JDBCRun(BufferedReader reader) {
        ConsoleHelperUtil utils = new ConsoleHelperUtil();
        try {
            List<Account> availableAccounts = service.getAccountsByUserEmail(userEmail);
            utils.accountTable(availableAccounts);
            List<Long> availableAccountsIds = new ArrayList<>();
            for (Account a : availableAccounts) {
                availableAccountsIds.add(a.getId());
            }
            System.out.println("Enter the id of account: ");
            long id = utils.chooseTheOwnAccount(reader, availableAccountsIds);
            System.out.println("Enter first date to check transactions history\nDate format: d/m/yy");
            Timestamp from = utils.readDate(reader);
            System.out.println("If you want to current date, press 1, or press 0 to enter your date");
            Timestamp to;
            if (reader.readLine().equals("1"))
                to = new Timestamp(System.currentTimeMillis());
            else {
                System.out.println("To date: ");
                to = utils.readDate(reader);
            }
            List<OperationExport> list = service.findOperationsInPeriod(id, from, to);
            writer.exportReport(fileToExport, list, service.getIncomesAndBalanceForPeriod(list));
            System.out.println("History was saved to file operations.csv");
        } catch (IOException | AccessToDataException e) {
            logger.error(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
