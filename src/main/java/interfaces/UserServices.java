package interfaces;

import dto.request.RegisterRequest;
import dto.response.RegisterResponse;

public interface UserServices {
    RegisterResponse register(RegisterRequest registerRequest);

}
