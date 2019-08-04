package com.backend.twitter.config;

import com.backend.twitter.entity.Role;
import com.backend.twitter.entity.User;
import com.backend.twitter.repository.RoleRepository;
import com.backend.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){

        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            this.createUsers("Galdino", "dgstihler@gmail.com", passwordEncoder.encode("123456"), "FREE");
            this.createUsers("Amanda", "admin", passwordEncoder.encode("123456"), "VIP");
        }

    }

    public void createUsers(String name, String email, String password, String role){

        Role roleObjetc = new Role();
        roleObjetc.setName(role);

        this.roleRepository.save(roleObjetc);

        User user = new User(name, email, password, Arrays.asList(roleObjetc));
        userRepository.save(user);

    }

}
