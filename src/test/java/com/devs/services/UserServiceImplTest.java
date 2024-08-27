package com.devs.services;

import com.devs.dto.request.RegisterRequest;
import com.devs.interfaces.UserServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserServices userServices;
    @Test
    public void testToRegisterUser() {
//        RegisterRequest registerRequest = RegisterRequest.builder()
//                .username("name")
//                .password("password")
//                .email("email@gmail.com")
//                .build();
//        var registerResponse = userServices.register(registerRequest);
//        assertThat(registerResponse.getUsername().equals("name"));
    }

}