package be.nd2k.myapp.dto;

import be.nd2k.myapp.model.User;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class UserResponse {

    private String status;
    private String message;
    private User user;
    private List<String> validationErrors;
    private HttpStatus httpStatus;
}
