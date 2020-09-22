package com.quanlydanhba.service;

import com.quanlydanhba.model.User;
import com.quanlydanhba.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserServiceImpl implements IUserService{
    @Autowired
    IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User model) {
        userRepository.save(model);
    }

    @Override
    public void remove(long id) {
        userRepository.delete(id);
    }

    @Override
    public Page<User> findAllByUserContaining(String username, Pageable pageable) {
        return userRepository.findAllByUsernameContaining(username,pageable);
    }

    @Override
    public Iterable<User> findAllByProvince(User user) {
        return null;
    }
}
