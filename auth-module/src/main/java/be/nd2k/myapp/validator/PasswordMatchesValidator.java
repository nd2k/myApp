package be.nd2k.myapp.validator;

import be.nd2k.myapp.dto.SignUpDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        SignUpDto signUpDto = (SignUpDto) object;
        return signUpDto.getPassword().equals(signUpDto.getMatchingPassword());
    }
}
