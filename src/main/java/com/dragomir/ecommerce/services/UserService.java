package com.dragomir.ecommerce.services;

import com.dragomir.ecommerce.models.Admin;
import com.dragomir.ecommerce.models.User;
import com.dragomir.ecommerce.repositories.AdminRepository;
import com.dragomir.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @PersistenceContext
    EntityManager em;
    public void convertToAdmin(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null)
            return;
        em.detach(user);
        Admin admin = new Admin(username, user.getPassword(), user.getEmail(), user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getPhoneNumber1(), user.getPhoneNumber2(), user.getAddress1(), user.getAddress2(), user.getCarts(), user.getUserOrders());
        adminRepository.save(admin);
    }
}
