package ua.com.alevel.dao;

import ua.com.alevel.entity.BaseEntity;

import java.util.List;

public interface BaseEntityService<T extends BaseEntity> {
    void create(T entity);
    List<T> readAll();
    void update(T id);
    void delete(String id);
    T getById(String id);
}
