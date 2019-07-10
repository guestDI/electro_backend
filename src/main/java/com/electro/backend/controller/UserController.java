package com.electro.backend.controller;

import com.electro.backend.model.User;
import com.electro.backend.repository.UserRepository;
import com.electro.backend.validator.LoginUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginUserValidator loginUserValidator;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public long loginUser(@RequestBody User user) {
        loginUserValidator.validate(user);
        User userLogin = userRepository.login(user.getUsername(), user.getPassword());
        if (userLogin == null) {
            throw new RuntimeException("Not found");
        }

//        loginInterceptor.register(userLoginDTO.getId(), userLoginDTO.getToken());

        return userLogin.getId();
    }
}
