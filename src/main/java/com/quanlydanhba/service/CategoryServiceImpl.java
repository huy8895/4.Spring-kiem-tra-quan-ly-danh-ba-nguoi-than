package com.quanlydanhba.service;

import com.quanlydanhba.model.Category;
import com.quanlydanhba.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void save(Category model) {
        categoryRepository.save(model);
    }

    @Override
    public void remove(long id) {
        categoryRepository.delete(id);
    }
}
