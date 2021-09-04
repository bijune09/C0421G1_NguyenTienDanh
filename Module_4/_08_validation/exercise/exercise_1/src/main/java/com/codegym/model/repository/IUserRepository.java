package com.codegym.model.repository;

import com.codegym.model.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
