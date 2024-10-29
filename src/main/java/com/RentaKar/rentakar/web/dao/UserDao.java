package com.RentaKar.rentakar.web.dao;

import com.RentaKar.rentakar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
   // List<User> findAll();

   // User findById(int id);

    //User save(User user);

    //User deleteUser(int id);
}
