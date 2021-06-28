package ua.com.alevel.dao;

import ua.com.alevel.exeption.NotFoundToDataException;
import ua.com.alevel.model.entity.Account;
import ua.com.alevel.model.entity.User;

import java.util.List;

public interface UserSearcher {
    User getUserByEmail(String email) throws NotFoundToDataException;

    List<Account> getAccountsOfUser(Long id) throws NotFoundToDataException;
}
