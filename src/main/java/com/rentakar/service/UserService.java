package com.rentakar.service;


import com.rentakar.exceptions.LicenseNotValid;
import com.rentakar.model.User;
import com.rentakar.model.Order;
import com.rentakar.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserDao userDao;
    private final String orderServiceUrl = "http://localhost:9092/orders";
    private final String vehiculeServiceUrl = "http://localhost:9091/vehicules";
    private final RestTemplate restTemplate = new RestTemplate();


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
            System.out.println("User with id: " + id + " found  ||");
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
                System.out.println("License ID is not correct ||");
                System.out.println("Creating User cancelled ||");
            }
        } catch (URISyntaxException e) {
            throw new LicenseNotValid("Votre License n'est pas valide");
        }
        return userDao.save(user);
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
                System.out.println("License n° " + user.getLicenceid() + " Accepted ||");
                System.out.println("User with id: " + id + " updated ||");
                return userDao.save(updatedUser);
            } else {
                System.out.println("License ID is not correct ||");
                System.out.println("Creating User cancelled ||");
            }
        } catch (URISyntaxException e) {
            throw new LicenseNotValid("Votre licence n'est pas valide");
        }
        }
        return userDao.save(updatedUser);
    }

    public User deleteUser(int id) {
        User user = userDao.findById(id).orElse(null);
        if (user != null) {
            System.out.println("User with id: " + id + " found  ||");
            userDao.deleteById(id);
            System.out.println("User with id: " + id + " deleted ||");
            return null;
        } else {
            System.out.println("User with id: " + id + " not found");
            return null;
        }
    }



    public boolean checkLicence(User user) throws URISyntaxException {
        String LicenceToCheck = String.valueOf(user.getLicenceid());
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8081/licenses/{licenceid}")
                .buildAndExpand(LicenceToCheck)
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        boolean LicenceChecked = Boolean.TRUE.equals(restTemplate.getForObject(uri, Boolean.class));
        return LicenceChecked;
    }

    public List<Order> getOrdersByUserId(int id) {
        String url = orderServiceUrl + "/?userId=" + id;
        ResponseEntity<List<Order>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Order>>() {}
        );
        return response.getBody();
    }
}

