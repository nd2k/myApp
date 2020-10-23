package be.nd2k.myapp.dto;

import be.nd2k.myapp.validator.PasswordMatches;
import be.nd2k.myapp.validator.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@PasswordMatches
public class SignUpDto {

    @NotNull(message = "FirstName field is mandatory")
    @NotEmpty(message = "FirstName field is mandatory")
    private String firstName;
    @NotNull(message = "LastName field is mandatory")
    @NotEmpty(message = "LastName field is mandatory")
    private String lastName;
    @ValidEmail
    @NotNull(message = "Email field is mandatory")
    @NotEmpty(message = "Email field is mandatory")
    private String email;
    @NotNull(message = "Password field is mandatory")
    @NotEmpty(message = "Password field is mandatory")
    private String password;
    private String matchingPassword;

}
