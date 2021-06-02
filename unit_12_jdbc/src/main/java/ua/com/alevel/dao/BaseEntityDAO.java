package ua.com.alevel.dao;

import java.util.List;

public interface BaseEntityDAO<T> {
    List<T> read();

    void update(int id, T entity);
}
