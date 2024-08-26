package services;

import data.model.User;
import data.repository.Users;
import dto.request.RegisterRequest;
import dto.response.RegisterResponse;
import interfaces.UserServices;
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

}
