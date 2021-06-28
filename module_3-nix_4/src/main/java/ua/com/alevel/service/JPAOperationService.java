package ua.com.alevel.service;

import ua.com.alevel.dao.impl.OperationDAO;
import ua.com.alevel.exeption.AccessToDataException;
import ua.com.alevel.exeption.NotFoundToDataException;
import ua.com.alevel.model.entity.*;

import javax.persistence.EntityManager;
import java.util.List;

public class JPAOperationService {

    private final OperationDAO operationDAO;

    public JPAOperationService(EntityManager en) {
        this.operationDAO = new OperationDAO(en);
    }

    public <T extends Category> void save(Operation<T> operation) throws AccessToDataException {

        if (operation.getCategories().isEmpty())
            throw new AccessToDataException("Operation should have valid categories");

        Class<?> objClass = operation.getCategories().iterator().next().getClass();

        if (objClass.equals(ExpenseCategory.class) && operation.getTransaction() > 0)
            throw new AccessToDataException("Expense operation must contain negative value");
        if (objClass.equals(IncomeCategory.class) && operation.getTransaction() < 0)
            throw new AccessToDataException("Income operation must contain positive value");

        try {
            operationDAO.save(operation);
        } catch (AccessToDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<IncomeCategory> getIncomeCategories() throws AccessToDataException {
        return operationDAO.getIncomeCategories();
    }

    public List<ExpenseCategory> getExpenseCategories() throws AccessToDataException {
        return operationDAO.getExpenseCategories();
    }

    public User findUserByEmail(String email) throws NotFoundToDataException {
        return operationDAO.getUserByEmail(email);
    }

    public List<Account> findAccountsOfUser(Long id) throws NotFoundToDataException {
        return operationDAO.getAccountsOfUser(id);
    }

    public List<IncomeCategory> findIncomeCategoriesByListOfIds(List<Long> ids) throws AccessToDataException {
        return operationDAO.getIncomeCategoriesById(ids);
    }

    public List<ExpenseCategory> findExpenseCategoriesByListOfIds(List<Long> ids) throws AccessToDataException {
        return operationDAO.getExpenseCategoriesById(ids);
    }
}
