package com.quanlydanhba.repository;

import com.quanlydanhba.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IUserRepository extends PagingAndSortingRepository<User,Long> {
    Page<User> findAllByUsernameContaining(String username, Pageable pageable);
}
