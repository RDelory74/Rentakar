package com.RentaKar.rentakar.web.dao;

import com.RentaKar.rentakar.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Robert", "Deplante", 499865, "25.10.1980"));
        users.add(new User(2, "Jhon", "Dumoulin", 599862, "17.02.1996"));
        users.add(new User(3, "Maîté", "Pasla", 599684, "01.05.1968"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(int id, User user) {
        users.set(id, user);
        return user;
    }

    @Override
    public User deleteUser(int id) {
        users.remove(id);
        return null;
    }

}
