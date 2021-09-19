package com.codegym.model.repository.user;

import com.codegym.model.bean.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
