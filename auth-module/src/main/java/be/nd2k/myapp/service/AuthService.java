package be.nd2k.myapp.service;

import be.nd2k.myapp.dto.SignUpDto;
import be.nd2k.myapp.exception.UserAlreadyExistException;
import be.nd2k.myapp.model.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    User register(SignUpDto signUpDto) throws UserAlreadyExistException;
}
