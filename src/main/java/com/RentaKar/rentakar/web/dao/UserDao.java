package com.RentaKar.rentakar.web.dao;

import com.RentaKar.rentakar.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> findAll();
    User findById(int id);
    User save(User user);
}
