package com.RentaKar.rentakar.Service;


import com.RentaKar.rentakar.model.User;
import com.RentaKar.rentakar.web.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    //injection
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        System.out.print("Fetching all users ||");
        return userDao.findAll();
    }

    public User getUserById(int id) {
        System.out.print("User with id: " + id + " found  ||");
        return userDao.findById(id);
    }

    public User saveUser(User user) {
        try {
            if (checkLicence(user)) {
                System.out.print("License n° " + user.getLicenceid() + " Accepted ||");
                System.out.print("User " + user.getFirstname() + " created ||");
                return userDao.save(user);
            } else {
                System.out.print("License ID is not correct ||");
                System.out.print("Creating User cancelled ||");
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public User updateUserById(int id, User user) {
        User updatedUser = userDao.findById(id);
        userDao.deleteUser(id);
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setLicenceid(user.getLicenceid());
        updatedUser.setDateOfBirth(user.getDateOfBirth());
        try {
            if (checkLicence(updatedUser)) {
                System.out.print("License n° " + user.getLicenceid() + " Accepted ||");
                System.out.print("User with id: " + id + " updated ||");
                return userDao.save(updatedUser);
            } else {
                System.out.print("License ID is not correct ||");
                System.out.print("Creating User cancelled ||");
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public User deleteUser(int id) {
        userDao.deleteUser(id);
        System.out.print("User with id: " + id + " deleted ||");
        return null;
    }


    public boolean checkLicence(User user) throws URISyntaxException {
        String LicenceToCheck = String.valueOf(user.getLicenceid());
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8081/licenses/{licenceId}")
                .buildAndExpand(LicenceToCheck)
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        boolean LicenceChecked = Boolean.TRUE.equals(restTemplate.getForObject(uri, Boolean.class));
        return LicenceChecked;
    }
}

