package ua.com.alevel.util;

import ua.com.alevel.model.entity.Account;
import ua.com.alevel.model.entity.ExpenseCategory;
import ua.com.alevel.model.entity.IncomeCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ConsoleHelperUtil {

    public void expenseTable(List<ExpenseCategory> categories) {
        List<String[]> table = new ArrayList<>();
        table.add(new String[]{"id", "expense"});
        for (ExpenseCategory c : categories) {
            String[] row = new String[2];
            row[0] = c.getId().toString();
            row[1] = c.getExpenseName();
            table.add(row);
        }
        for (String[] s : table) {
            System.out.println(Arrays.toString(s));
        }
    }

    public void incomeTable(List<IncomeCategory> categories) {
        List<String[]> table = new ArrayList<>();
        table.add(new String[]{"id", "income"});
        for (IncomeCategory c : categories) {
            String[] row = new String[2];
            row[0] = c.getId().toString();
            row[1] = c.getIncomeName();
            table.add(row);
        }
        for (String[] s : table) {
            System.out.println(Arrays.toString(s));
        }
    }

    public void accountTable(List<Account> accounts) {
        List<String[]> table = new ArrayList<>();
        table.add(new String[]{"id", "account name", "balance"});
        for (Account a : accounts) {
            String[] row = new String[3];
            row[0] = a.getId().toString();
            row[1] = a.getAccountName();
            row[2] = a.getBalance().toString();
            table.add(row);
        }
        for (String[] s : table) {
            System.out.println(Arrays.toString(s));
        }
    }

    public long readLong(BufferedReader reader) throws IOException {
        while (true) {
            String text = reader.readLine();
            try {
                return Integer.parseInt(text.trim());
            } catch (NumberFormatException e) {
                System.out.println("You must write int");
            }
        }

    }

    public long chooseTheOwnAccount(BufferedReader reader, List<Long> accountSecurityId) throws IOException {
        while (true) {
            long id = readLong(reader);
            if (accountSecurityId.contains(id)) {
                return id;
            } else {
                System.out.println("This user haven't accounts");
            }
        }
    }

    public Timestamp readDate(BufferedReader reader) throws IOException {
        DateFormat formatter = new SimpleDateFormat("d/M/yy");
        Timestamp date;
        while (true) {
            try {
                Date dateRead = formatter.parse(reader.readLine());
                date = new Timestamp(dateRead.getTime());
                break;
            } catch (ParseException e) {
                System.out.println("Incorrect date");
            }
        }
        return date;
    }

}
