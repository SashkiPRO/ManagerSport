package ua.nure.botsula.controller;

import net.proselyte.springsecurityapp.dao.MessageDao;
import net.proselyte.springsecurityapp.model.Message;
import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.service.MessageService;
import net.proselyte.springsecurityapp.service.UserService;
import net.proselyte.springsecurityapp.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alexandr on 12.06.2017.
 */
@Controller
public class PlayerController {
@Autowired
    private UserService userService;
@Autowired
private MessageService messageService;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private PasswordValidator passwordValidator;
    @RequestMapping(value = "player_cabinet")
    public String playerCabinet(Model model){
        return "player/player_info";
    }
    @RequestMapping(value = "player_events", params = {"user_id"})
    public String showEvents(Model model,@RequestParam(value = "user_id")Long id){
      User user=  userService.findById(id);
      List<Message> messages = messageDao.find(user);
    model.addAttribute("events", messages);
        return "player/answered_events";
    }
    @RequestMapping(value = "unanswered_events")
    public String unansweredEvents(Model model){
        return "player/unanswered_events";
    }
    @RequestMapping(value = "answer_page", params = {"id"})
    public String answerPage(Model model, @RequestParam(value = "id")Long id){
       Message message =  messageService.findMessageById(id);
        model.addAttribute("message", message);
        return "player/answer_page";
    }

    @RequestMapping (value = "accept_event", params = {"id"})
    public String acceptEvent(Model model, @RequestParam("id")Long id){
        Message message = messageService.findMessageById(id);
        message.setStatus("read");
        messageService.save(message);
        StringBuilder path = new StringBuilder();
        path.append("redirect:/answer_page?id=");
        path.append(id);
        return path.toString().trim();
    }
    @RequestMapping (value = "disagree_event", params = {"id"})
    public String disagreeEvent(Model model, @RequestParam("id")Long id){
        Message message = messageService.findMessageById(id);
        message.setStatus("disagree");
        messageService.save(message);
        StringBuilder path = new StringBuilder();
        path.append("redirect:/answer_page?id=");
        path.append(id);
        return path.toString().trim();
    }
    @RequestMapping(value = "edit_user_player", method = RequestMethod.GET)
    public String editAdmin(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        User editUser= userService.findByLogin(user.getLogin());
        model.addAttribute("editUser", editUser);
        return "player/edit_player";
    }
    @RequestMapping(value = "edit_user_player", method = RequestMethod.POST)
    public String updateAdmin(Model model, @ModelAttribute("editUser") User editUser, HttpSession session){
        /*userService.save(editUser);*/
        User userUpdate = (User) session.getAttribute("User");
        User user = userService.findById(userUpdate.getId());
        user.setFirstName(editUser.getFirstName());
        user.setLastName(editUser.getLastName());
        user.setBirthDate(editUser.getBirthDate());
        System.out.print(user.getPassword());
        userService.update(user);

        System.out.print(editUser.getBirthDate()+editUser.getFirstName());
        return "redirect:/player_cabinet";
    }
    @RequestMapping(value = "change_password_player", method = RequestMethod.GET)
    public String changePassword(Model model){
        model.addAttribute("newUser", new User());
        return "player/change_password";
    }
    @RequestMapping(value = "change_password_player", method = RequestMethod.POST)
    public String commitChangePassword(Model model, @ModelAttribute("newUser") User newUser, HttpSession session,BindingResult bindingResult){

        passwordValidator.validate(newUser, bindingResult);
        if(bindingResult.hasErrors()){
            return "player/change_password";
        }
        User user =(User)session.getAttribute("User");
        user.setPassword(newUser.getNewPassword());
        userService.save(user);
        return "redirect:/player_cabinet";
    }
    @RequestMapping(value = "edit_avatar_player", method = RequestMethod.GET)
    public String editAvatar(Model model){
        return "player/edit_avatar";
    }
    @RequestMapping(value = "edit_avatar_player", method = RequestMethod.POST)
    public String saveAdminAvatar(Model model, @ModelAttribute MultipartFile file, HttpSession session){
        User user =(User)session.getAttribute("User");
        try {
            user.setImage(file.getBytes());
        }catch (IOException ex){
            System.out.print("File empty");
        }
        userService.update(user);
        return "redirect:/player_cabinet";
    }


}
