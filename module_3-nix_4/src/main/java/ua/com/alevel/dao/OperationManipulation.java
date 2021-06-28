package ua.com.alevel.dao;

import ua.com.alevel.exeption.AccessToDataException;
import ua.com.alevel.model.entity.Category;
import ua.com.alevel.model.entity.Operation;


public interface OperationManipulation {
    <T extends Category> void save(Operation<T> operation) throws AccessToDataException;
}
