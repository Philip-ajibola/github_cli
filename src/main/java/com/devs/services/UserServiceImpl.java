package com.devs.services;

import com.devs.data.model.User;
import com.devs.data.repository.Users;
import com.devs.dto.request.LoginRequest;
import com.devs.dto.request.RegisterRequest;
import com.devs.dto.response.LoginResponse;
import com.devs.dto.response.RegisterResponse;
import com.devs.interfaces.UserServices;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServices {
    private final Users users;
    private final ModelMapper modelMapper;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User check = users.findByUsername(registerRequest.getUsername());
        if(check != null)throw new IllegalArgumentException("User already exist");
        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .email(registerRequest.getEmail())
                .build();
        users.save(user);
        return modelMapper.map(user, RegisterResponse.class);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = users.findByUsername(loginRequest.getUsername());
        if(user == null)throw new IllegalArgumentException("User not found");
        if(!user.getPassword().equals(loginRequest.getPassword()))throw new IllegalArgumentException("Wrong password");
        User user1 = User.builder()
                .username(loginRequest.getUsername())
                .password(loginRequest.getPassword())
                .build();
        users.save(user1);
        return modelMapper.map(user1, LoginResponse.class);
    }

}
