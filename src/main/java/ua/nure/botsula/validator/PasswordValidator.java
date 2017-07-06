package ua.nure.botsula.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.nure.botsula.model.User;
import ua.nure.botsula.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Created by Alexandr on 09.06.2017.
 */
@Component
public class PasswordValidator implements Validator {

@Autowired
private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
@Autowired
private HttpSession session;
        @Override
        public boolean supports(Class<?> aClass) {
            return User.class.equals(aClass);
        }


        @Override
        public void validate(Object o, Errors errors) {
            User user = (User) o;
            User user2= (User) session.getAttribute("User");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "Required");
            if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
                errors.rejectValue("newPassword", "Size.userForm.password");
            }
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "Required");
            if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
                errors.rejectValue("confirmPassword", "Size.userForm.password");
            }


            if(!bCryptPasswordEncoder.matches(user.getPassword(), user2.getPassword())){
                errors.rejectValue("password", "Different.paswords");
            }
            if(!user.getNewPassword().equals(user.getConfirmPassword())){
                errors.rejectValue("confirmPassword", "Different.paswords");
            }


        }
}
