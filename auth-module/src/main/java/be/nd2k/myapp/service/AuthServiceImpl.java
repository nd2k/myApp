package be.nd2k.myapp.service;

import be.nd2k.myapp.dto.SignUpDto;
import be.nd2k.myapp.exception.UserAlreadyExistException;
import be.nd2k.myapp.model.User;
import be.nd2k.myapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(SignUpDto signUpDto) throws UserAlreadyExistException {
        if(emailExist(signUpDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address : " + signUpDto.getEmail());
        } else {
            User newUser = new User();
            newUser.setEmail(signUpDto.getEmail());
            newUser.setFirstName(signUpDto.getFirstName());
            newUser.setLastName(signUpDto.getLastName());
            newUser.setPassword(signUpDto.getPassword());
            return userRepository.save(newUser);
        }
    }

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
