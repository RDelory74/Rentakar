package com.rentakar.web.dao;

import com.rentakar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
   // List<User> findAll();

   // User findById(int id);

    //User save(User user);

    //User deleteUser(int id);
}
