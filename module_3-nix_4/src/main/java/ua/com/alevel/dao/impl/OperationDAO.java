package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.CategorySearcher;
import ua.com.alevel.dao.OperationManipulation;
import ua.com.alevel.dao.UserSearcher;
import ua.com.alevel.exeption.AccessToDataException;
import ua.com.alevel.exeption.NotFoundToDataException;
import ua.com.alevel.model.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class OperationDAO implements CategorySearcher, OperationManipulation, UserSearcher {
    private final EntityManager entityManager;

    public OperationDAO(EntityManager en) {
        this.entityManager = en;
    }

    @Override
    public <T extends Category> void save(Operation<T> operation) throws AccessToDataException {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(operation);
            var account = entityManager.find(Account.class, operation.getAccount().getId());
            account.setBalance(account.getBalance() + operation.getTransaction());
            entityManager.merge(account);
            transaction.commit();
        } catch (RuntimeException e) {
            transaction.rollback();
            throw new AccessToDataException(e);
        }
    }

    @Override
    public List<IncomeCategory> getIncomeCategoriesById(List<Long> listOfId) throws AccessToDataException {
        try {
            TypedQuery<IncomeCategory> query = entityManager.createQuery
                    ("select c from IncomeCategory c where c.id in :ids", IncomeCategory.class).setParameter("ids", listOfId);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw new AccessToDataException(e);
        }
    }

    @Override
    public List<ExpenseCategory> getExpenseCategoriesById(List<Long> listOfId) throws AccessToDataException {
        try {
            TypedQuery<ExpenseCategory> query = entityManager.createQuery
                    ("select c from ExpenseCategory c where c.id in :ids", ExpenseCategory.class).setParameter("ids", listOfId);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw new AccessToDataException(e);
        }
    }

    @Override
    public List<IncomeCategory> getIncomeCategories() throws AccessToDataException {
        try {
            TypedQuery<IncomeCategory> query = entityManager.createQuery
                    ("select i from IncomeCategory i order by i.incomeName asc", IncomeCategory.class);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw new AccessToDataException(e);
        }
    }

    @Override
    public List<ExpenseCategory> getExpenseCategories() throws AccessToDataException {
        try {
            TypedQuery<ExpenseCategory> query = entityManager.createQuery
                    ("select e from ExpenseCategory e order by e.expenseName asc", ExpenseCategory.class);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw new AccessToDataException(e);
        }
    }

    @Override
    public User getUserByEmail(String email) throws NotFoundToDataException {
        try {
            TypedQuery<User> query = entityManager.createQuery
                    ("select u from User u where u.email=:email", User.class);
            query.setParameter("email", email);
            query.setMaxResults(1);
            return query.getSingleResult();
        } catch (RuntimeException e) {
            throw new NotFoundToDataException(email, User.class);
        }
    }

    @Override
    public List<Account> getAccountsOfUser(Long id) throws NotFoundToDataException {
        TypedQuery<Account> query = entityManager.createQuery
                ("select a from Account a where a.user.id=:id", Account.class);
        query.setParameter("id", id);
        if (query.getResultList().isEmpty())
            throw new NotFoundToDataException("User has not any accounts");
        return query.getResultList();

    }

}

