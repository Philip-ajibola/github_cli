package com.devs.interfaces;

import com.devs.dto.request.LoginRequest;
import com.devs.dto.request.RegisterRequest;
import com.devs.dto.response.LoginResponse;
import com.devs.dto.response.RegisterResponse;

public interface UserServices {
    RegisterResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
}
