package com.electro.backend.service;

import com.electro.backend.model.User;
import com.electro.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public User login(String username, String password) {
//        User user = userRepository.login(username, password);
//        UserLoginDTO userLoginDTO = null;
//        if (nonNull(user)) {
//            userLoginDTO = userConverter.convertUserLogin(user);
//        }
//
//        return  userLoginDTO;
//    }
}
