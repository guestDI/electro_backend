package com.electro.backend.validator;

import com.electro.backend.model.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by d.ihnatovich on 10/30/2017.
 */
@Component
public class LoginUserValidator {

    public void validate(User user) throws RuntimeException {
        if(StringUtils.isEmpty(user.getUsername())){
            throw new RuntimeException("Username is empty");
        }

        if(StringUtils.isEmpty(user.getPassword())){
            throw new RuntimeException("Password is empty");
        }
    }
}
