package be.nd2k.myapp.controller;

import be.nd2k.myapp.dto.SignUpDto;
import be.nd2k.myapp.dto.UserResponse;
import be.nd2k.myapp.exception.UserAlreadyExistException;
import be.nd2k.myapp.model.User;
import be.nd2k.myapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    @ResponseBody
    public UserResponse signUp(@Valid @RequestBody SignUpDto signUpDto, BindingResult bindingResult) {
        UserResponse userResponse = new UserResponse();
        if (bindingResult.hasErrors()) {
            List<String> validationErrors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
            userResponse.setValidationErrors(validationErrors);
            userResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            userResponse.setUser(null);
            userResponse.setStatus("error");
            userResponse.setMessage("Validations failed");
            return userResponse;
        }
        try {
            User newUser = authService.register(signUpDto);
            userResponse.setHttpStatus(HttpStatus.CREATED);
            userResponse.setMessage("User successfully created");
            userResponse.setStatus("success");
            userResponse.setUser(newUser);
            return userResponse;
        } catch (UserAlreadyExistException userAlreadyExistException) {
            userResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            userResponse.setUser(null);
            userResponse.setStatus("error");
            userResponse.setMessage(userAlreadyExistException.getMessage());
            return userResponse;
        }
    }
}
