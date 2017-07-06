package ua.nure.botsula.controller;

import net.proselyte.springsecurityapp.model.*;
import net.proselyte.springsecurityapp.service.*;
import net.proselyte.springsecurityapp.util.*;
import net.proselyte.springsecurityapp.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Alexandr on 10.06.2017.
 */
@Controller
public class CoachController {
    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;
    @Autowired
    private HallService hallService;
    @Autowired
    private HallPropertiesEditor hallPropertiesEditor;
    @Autowired
    private EventPropertiesEditor eventPropertiesEditor;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private PasswordValidator passwordValidator;
    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Hall.class, this.hallPropertiesEditor);
        binder.registerCustomEditor(User.class, this.eventPropertiesEditor);
    }

    @RequestMapping(value = "coach_cabinet")
    public String coachCabinet(Model model){
        return "coach/coach_info";
    }
    @RequestMapping(value = "add_event", method = RequestMethod.GET)
    public String addEventForm(Model model){
        List<Hall> hallList = hallService.findAll();
        model.addAttribute("newEvent", new Event());
        model.addAttribute("halls", hallList);
        return "coach/create_event";
    }
    @RequestMapping(value = "add_event", method = RequestMethod.POST)
    public String addEvent(Model model, @ModelAttribute("newEvent") Event newEvent){
      System.out.print(newEvent);
       eventService.save(newEvent);
        return "redirect:/coach_cabinet";
    }

    @RequestMapping(value = "event_list")
    public String eventList(Model model){
      List<Event> events =  eventService.findAllByOrderByDate();
    model.addAttribute("events", events);
        return "coach/event_list";
    }
    @RequestMapping(value = "participant_list", params = {"id"}, method = RequestMethod.GET)
    public String participantForm(Model model, @RequestParam(value = "id")String id){
        Event event = eventService.findEventById(Long.parseLong(id));
        Role role = roleService.findRoleById(4l);
        List<User> allUsers = userService.findAll();
        List<User> users = new ArrayList<>();
        for(User u:allUsers){
            if(u.getRoles().contains(role))
                users.add(u);
        }


        model.addAttribute("users", users);
        model.addAttribute("event", event);
        return "coach/participant_list";
    }
    @RequestMapping(value = "participant_list", params = {"id"}, method = RequestMethod.POST)
    public String participantConfirm(Model model, @RequestParam(value = "id")Long id,@ModelAttribute Event event ){
        Event event1 = eventService.findEventById(id);
        Set<User> userList = event.getUsers();

        event1.setUsers(userList);
        eventService.save(event1);

        for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();){
            User user = iterator.next();
            Message message = new Message();
            message.setEvent(event1);
            message.setStatus("unread");
            message.setUser(user);

            for(Message m:user.getMessages()){
                System.out.println(m.equals(message));

            }
            if(!user.getMessages().contains(message)) {
                System.out.println(user.getMessages().contains(message));
                messageService.save(message);
            }
        }
        return "redirect:/event_list";

    }
    @RequestMapping(value = "participant_answer", params = {"id"})
    public String participantAnswerShow(Model model, @RequestParam("id")Long id){
        Event event = eventService.findEventById(id);
      model.addAttribute("messages",event.getMessages());

        return "coach/participant_answer";
    }
    @RequestMapping(value = "players_games")
    public String playerGame(Model model){
        Role role = roleService.findRoleById(4l);
        List<User> allUsers = userService.findAll();
        List<User> players = new ArrayList<>();
        for(User u:allUsers){
            if(u.getRoles().contains(role))
                players.add(u);
        }
        List<GameVisitStatisticCreator> gameStatistic=new ArrayList<>();
        for (User user:players){
           int total=0;
           int missed=0;
           int visited=0;
           double percent=0.0;
            for(Iterator<Message> iterator = user.getMessages().iterator();iterator.hasNext();){
              Message message = iterator.next();
                if(message.getEvent().getType().equals("GAME")){
                    total++;
                    if (message.getStatus().equals("read")){
                        visited++;}else if (message.getStatus().equals("disagree")){
                        missed++;
                    }

                    if (total!=0){
                        percent=(visited*100)/total;
                    }else {
                        percent=0.0;
                    }

                }

            }
            gameStatistic.add(new GameVisitStatisticCreator(user,visited,missed,total,percent));
        }
            model.addAttribute("statistics", gameStatistic);
        return "coach/game_statistics";
    }
    @RequestMapping(value = "players_trainings")
    public String playerTraining(Model model){
        Role role = roleService.findRoleById(4l);
        List<User> allUsers = userService.findAll();
        List<User> players = new ArrayList<>();
        for(User u:allUsers){
            if(u.getRoles().contains(role))
                players.add(u);
        }
        List<GameVisitStatisticCreator> gameStatistic=new ArrayList<>();
        for (User user:players){
            int total=0;
            int missed=0;
            int visited=0;
            double percent=0.0;
            for(Iterator<Message> iterator = user.getMessages().iterator();iterator.hasNext();){
                Message message = iterator.next();
                if(message.getEvent().getType().equals("TRAINING")){
                    total++;
                    if (message.getStatus().equals("read")){
                        visited++;}else if (message.getStatus().equals("disagree")){
                        missed++;
                    }

                    if (total!=0){
                        percent=(visited*100)/total;
                    }else {
                        percent=0.0;
                    }

                }

            }
            gameStatistic.add(new GameVisitStatisticCreator(user,visited,missed,total,percent));
        }
        model.addAttribute("statistics", gameStatistic);


        return "coach/training_statistic";

    }
    @RequestMapping(value = "edit_user_coach", method = RequestMethod.GET)
    public String editAdmin(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        User editUser= userService.findByLogin(user.getLogin());
        model.addAttribute("editUser", editUser);
        return "coach/edit_coach";
    }
    @RequestMapping(value = "edit_user_coach", method = RequestMethod.POST)
    public String updateAdmin(Model model, @ModelAttribute("editUser") User editUser, HttpSession session){
        User userUpdate = (User) session.getAttribute("User");
        User user = userService.findById(userUpdate.getId());
        user.setFirstName(editUser.getFirstName());
        user.setLastName(editUser.getLastName());
        user.setBirthDate(editUser.getBirthDate());
        System.out.print(user.getPassword());
        userService.update(user);

        System.out.print(editUser.getBirthDate()+editUser.getFirstName());
        return "redirect:/coach_cabinet";
    }
    @RequestMapping(value = "change_password_coach", method = RequestMethod.GET)
    public String changePassword(Model model){
        model.addAttribute("newUser", new User());
        return "coach/change_password";
    }
    @RequestMapping(value = "change_password_coach", method = RequestMethod.POST)
    public String commitChangePassword(Model model, @ModelAttribute("newUser") User newUser, HttpSession session,BindingResult bindingResult){

        passwordValidator.validate(newUser, bindingResult);
        if(bindingResult.hasErrors()){
            return "coach/change_password";
        }
        User user =(User)session.getAttribute("User");
        user.setPassword(newUser.getNewPassword());
        userService.save(user);
        return "redirect:/coach_cabinet";
    }
    @RequestMapping(value = "edit_avatar_coach", method = RequestMethod.GET)
    public String editAvatar(Model model){
        return "coach/edit_avatar";
    }
    @RequestMapping(value = "edit_avatar_coach", method = RequestMethod.POST)
    public String saveAdminAvatar(Model model, @ModelAttribute MultipartFile file, HttpSession session){
        User user =(User)session.getAttribute("User");
        try {
            user.setImage(file.getBytes());
        }catch (IOException ex){
            System.out.print("File empty");
        }
        userService.update(user);
        return "redirect:/coach_cabinet";
    }
}
