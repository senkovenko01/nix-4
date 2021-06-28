package ua.com.alevel.dao;

import ua.com.alevel.exeption.AccessToDataException;
import ua.com.alevel.model.entity.ExpenseCategory;
import ua.com.alevel.model.entity.IncomeCategory;

import java.util.List;

public interface CategorySearcher {
    List<IncomeCategory> getIncomeCategories() throws AccessToDataException;

    List<ExpenseCategory> getExpenseCategories() throws AccessToDataException;

    List<IncomeCategory> getIncomeCategoriesById(List<Long> listOfId) throws AccessToDataException;

    List<ExpenseCategory> getExpenseCategoriesById(List<Long> listOfId) throws AccessToDataException;
}
