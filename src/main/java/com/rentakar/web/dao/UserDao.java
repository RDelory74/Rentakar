package com.rentakar.web.dao;

import com.rentakar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

        @Query("SELECT u.dateOfBirth FROM User u WHERE u.id = :id")
        LocalDate getDateOfBirth(int id);



}
