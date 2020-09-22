package com.quanlydanhba.service;


import com.quanlydanhba.model.Category;

public interface ICategoryService {
    Iterable<Category> findAll();

    Category findById(long id);

    void save(Category model);

    void remove(long id);
}
