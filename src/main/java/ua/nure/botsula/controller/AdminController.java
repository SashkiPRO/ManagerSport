package ua.nure.botsula.controller;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import ua.nure.botsula.model.News;
import ua.nure.botsula.model.Role;
import ua.nure.botsula.model.User;
import ua.nure.botsula.service.NewsService;
import ua.nure.botsula.service.RoleService;
import ua.nure.botsula.service.UserService;
import ua.nure.botsula.util.Renamer;
import ua.nure.botsula.util.RolePropetiesEditor;
import ua.nure.botsula.validator.PasswordValidator;
import ua.nure.botsula.validator.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 05.06.2017.
 */
@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePropetiesEditor rolePropetiesEditor;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private PasswordValidator passwordValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private NewsService newsService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Role.class, this.rolePropetiesEditor);
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws ServletException {
        binder.registerCustomEditor(byte[].class,
                new ByteArrayMultipartFileEditor());
    }

    @RequestMapping(value = "createNewUser", method = RequestMethod.GET)
    public String createNewUser(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", roleService.findAll());
        return "admin/create_user_page";
    }

    @RequestMapping(value = "createNewUser", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("newUser") User newUser, @ModelAttribute MultipartFile file, BindingResult bindingResult) {

       /* userValidator.validate(newUser, bindingResult);
        if(bindingResult.hasErrors()){
            return "admin/create_user_page";
        }*/
        try {
            newUser.setImage(file.getBytes());
        } catch (IOException ex) {
            System.out.print("File empty");
        }
        newUser.setPassword(new Renamer().passwordCreator());
        String login = new Renamer().loginCreator(newUser.getFirstName(), newUser.getLastName());
        while (userService.findByLogin(login) != null) {
            login = new Renamer().loginCreator(newUser.getFirstName(), newUser.getLastName());
        }
        String passwordWitoutHash = newUser.getPassword();
        newUser.setLogin(login);
        System.out.println(newUser.getPassword());
        userService.save(newUser);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(newUser.getEmail());
        message.setSubject("Hello " + newUser.getFirstName());
        message.setText("Password: " + passwordWitoutHash + ", login: " + newUser.getLogin());
        javaMailSender.send(message);

        return "redirect:/admin_cabinet";
    }

    @RequestMapping(value = "view_coaches", method = RequestMethod.GET)
    public String showCoaches(Model model) {
        Role role = roleService.findRoleById(3l);
        List<User> allUsers = userService.findAll();
        List<User> coaches = new ArrayList<>();
        for (User u : allUsers) {
            if (u.getRoles().contains(role))
                coaches.add(u);
        }
        model.addAttribute("coaches", coaches);
        return "admin/coach_list";
    }

    @RequestMapping(value = "view_players", method = RequestMethod.GET)
    public String showPlayers(Model model) {
        Role role = roleService.findRoleById(4l);
        List<User> allUsers = userService.findAll();
        List<User> players = new ArrayList<>();
        for (User u : allUsers) {
            if (u.getRoles().contains(role))
                players.add(u);
        }


        model.addAttribute("players", players);
        return "admin/player_list";
    }

    @RequestMapping(value = "view_extras", method = RequestMethod.GET)
    public String showExtras(Model model) {
        Role role = roleService.findRoleById(5l);
        List<User> allUsers = userService.findAll();
        List<User> extras = new ArrayList<>();
        for (User u : allUsers) {
            if (u.getRoles().contains(role))
                extras.add(u);
        }

        model.addAttribute("extras", extras);
        return "admin/extras_list";
    }

    @RequestMapping(value = "view_economists", method = RequestMethod.GET)
    public String showEconomists(Model model) {
        Role role = roleService.findRoleById(6l);
        List<User> allUsers = userService.findAll();
        List<User> economists = new ArrayList<>();
        for (User u : allUsers) {
            if (u.getRoles().contains(role))
                economists.add(u);
        }
        model.addAttribute("economists", economists);
        return "admin/economists_list";
    }

    @RequestMapping(value = "add_news", method = RequestMethod.GET)
    public String newsFormCreate(Model model) {
        model.addAttribute("newNews", new News());
        return "admin/add_news";
    }

    @RequestMapping(value = "add_news", method = RequestMethod.POST)
    public String addNews(Model model, @ModelAttribute News newNews) {
        newNews.setNewsDate(new DateTime());
        newsService.save(newNews);
        return "redirect:/add_news?message=succes";
    }

    @RequestMapping(value = "news_list")
    public String showNews(Model model) {
        List<News> news = newsService.findAll();
        model.addAttribute("newsList", news);
        return "admin/news_list";
    }

    @RequestMapping(value = "edit_admin", method = RequestMethod.GET)
    public String editAdmin(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        User editUser = userService.findByLogin(user.getLogin());
        model.addAttribute("editUser", editUser);
        return "admin/edit_admin";
    }

    @RequestMapping(value = "edit_admin", method = RequestMethod.POST)
    public String updateAdmin(Model model, @ModelAttribute("editUser") User editUser, HttpSession session) {
        /*userService.save(editUser);*/
        User userUpdate = (User) session.getAttribute("User");
        User user = userService.findById(userUpdate.getId());
        user.setFirstName(editUser.getFirstName());
        user.setLastName(editUser.getLastName());
        user.setBirthDate(editUser.getBirthDate());
        System.out.print(user.getPassword());
        userService.update(user);

        System.out.print(editUser.getBirthDate() + editUser.getFirstName());
        return "redirect:/admin_cabinet";
    }

    @RequestMapping(value = "change_password", method = RequestMethod.GET)
    public String changePassword(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/change_password";
    }

    @RequestMapping(value = "change_password", method = RequestMethod.POST)
    public String commitChangePassword(Model model, @ModelAttribute("newUser") User newUser, HttpSession session, BindingResult bindingResult) {

        passwordValidator.validate(newUser, bindingResult);
        if (bindingResult.hasErrors()) {
            return "admin/change_password";
        }
        User user = (User) session.getAttribute("User");
        user.setPassword(newUser.getNewPassword());
        userService.save(user);
        return "redirect:/admin_cabinet";
    }

    @RequestMapping(value = "edit_avatar", method = RequestMethod.GET)
    public String editAvatar(Model model) {
        return "admin/edit_avatar";
    }

    @RequestMapping(value = "edit_avatar", method = RequestMethod.POST)
    public String saveAdminAvatar(Model model, @ModelAttribute MultipartFile file, HttpSession session) {
        User user = (User) session.getAttribute("User");
        try {
            user.setImage(file.getBytes());
        } catch (IOException ex) {
            System.out.print("File empty");
        }
        userService.update(user);
        return "redirect:/admin_cabinet";
    }

}
