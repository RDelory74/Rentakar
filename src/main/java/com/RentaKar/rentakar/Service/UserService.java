package com.RentaKar.rentakar.Service;


import com.RentaKar.rentakar.exceptions.LicenseNotValid;
import com.RentaKar.rentakar.exceptions.UserNotFoundException;
import com.RentaKar.rentakar.model.User;
import com.RentaKar.rentakar.web.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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
        User user = userDao.findById(id).orElse(null);
        if(user != null) {
            System.out.print("User with id: " + id + " found  ||");
            return user;
        }
        System.out.print("User with id: " + id + " not found");
        return null;
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
            throw new LicenseNotValid("Votre License n'est pas valide");
        }
        return null;
    }

    public User updateUserById(int id, User user) {
        User updatedUser = userDao.findById(id).orElse(null);
        if (updatedUser != null) {
        userDao.deleteById(id);
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
            throw new LicenseNotValid("Votre licence n'est pas valide");
        }
        }
        return null;
    }

    public User deleteUser(int id) {
        User user = userDao.findById(id).orElse(null);
        if (user != null) {
            System.out.print("User with id: " + id + " found  ||");
            userDao.deleteById(id);
            System.out.print("User with id: " + id + " deleted ||");
            return null;
        } else {
            System.out.print("User with id: " + id + " not found");
            return null;
        }
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

