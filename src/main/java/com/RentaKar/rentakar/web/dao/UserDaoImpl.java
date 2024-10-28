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
        users.add(new User(4, "Alice", "Dupont", 123456, "10.02.1990"));
        users.add(new User(5, "Bob", "Martin", 234567, "15.06.1985"));
        users.add(new User(6, "Maîté", "Pasla", 599684, "01.05.1968"));
        users.add(new User(7, "Charles", "Durand", 345678, "20.11.1978"));
        users.add(new User(8, "Emma", "Leroy", 456789, "25.12.2000"));
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
    public User deleteUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return user;
            }
        }
    return null;
    }
}
