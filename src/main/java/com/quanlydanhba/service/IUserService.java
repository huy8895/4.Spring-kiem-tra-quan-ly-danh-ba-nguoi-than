package com.quanlydanhba.service;

import com.quanlydanhba.model.Category;
import com.quanlydanhba.model.User;
import com.quanlydanhba.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Iterable<User> findAll();

    User findById(long id);

    void save(User model);

    void remove(long id);

    Page<User> findAllByUserContaining(String firstName, Pageable pageable);

    Page<User> findAllByUsernameContainingAndCategory(String username, Category category, Pageable pageable);

    Iterable<User> findAllByProvince(User user);

}
