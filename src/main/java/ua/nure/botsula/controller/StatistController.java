package ua.nure.botsula.controller;

import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.service.RoleService;
import net.proselyte.springsecurityapp.service.UserService;
import net.proselyte.springsecurityapp.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Alexandr on 18.06.2017.
 */
@Controller
public class StatistController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordValidator passwordValidator;
    @RequestMapping(value = "statist_cabinet")
    public String coachCabinet(Model model){
        return "statist/statist_info";
    }











































    @RequestMapping(value = "edit_statist", method = RequestMethod.GET)
    public String editAdmin(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        User editUser= userService.findByLogin(user.getLogin());
        model.addAttribute("editUser", editUser);
        return "statist/edit_statist";
    }
    @RequestMapping(value = "edit_statist", method = RequestMethod.POST)
    public String updateAdmin(Model model, @ModelAttribute("editUser") User editUser, HttpSession session){
        User userUpdate = (User) session.getAttribute("User");
        User user = userService.findById(userUpdate.getId());
        user.setFirstName(editUser.getFirstName());
        user.setLastName(editUser.getLastName());
        user.setBirthDate(editUser.getBirthDate());
        System.out.print(user.getPassword());
        userService.update(user);

        System.out.print(editUser.getBirthDate()+editUser.getFirstName());
        return "redirect:/statist_cabinet";
    }
    @RequestMapping(value = "change_password_statist", method = RequestMethod.GET)
    public String changePassword(Model model){
        model.addAttribute("newUser", new User());
        return "statist/change_password";
    }
    @RequestMapping(value = "change_password_statist", method = RequestMethod.POST)
    public String commitChangePassword(Model model, @ModelAttribute("newUser") User newUser, HttpSession session,BindingResult bindingResult){

        passwordValidator.validate(newUser, bindingResult);
        if(bindingResult.hasErrors()){
            return "statist/change_password";
        }
        User user =(User)session.getAttribute("User");
        user.setPassword(newUser.getNewPassword());
        userService.save(user);
        return "redirect:/statist_cabinet";
    }
    @RequestMapping(value = "edit_avatar_statist", method = RequestMethod.GET)
    public String editAvatar(Model model){
        return "statist/edit_avatar";
    }
    @RequestMapping(value = "edit_avatar_statist", method = RequestMethod.POST)
    public String saveAdminAvatar(Model model, @ModelAttribute MultipartFile file, HttpSession session){
        User user =(User)session.getAttribute("User");
        try {
            user.setImage(file.getBytes());
        }catch (IOException ex){
            System.out.print("File empty");
        }
        userService.update(user);
        return "redirect:/statist_cabinet";
    }
}
