package ua.nure.botsula.controller;

import net.proselyte.springsecurityapp.model.*;
import net.proselyte.springsecurityapp.service.*;
import net.proselyte.springsecurityapp.util.TableCreator;
import net.proselyte.springsecurityapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


/**
 * Controller for {@link net.proselyte.springsecurityapp.model.User}'s pages.
 *
 * @author Aleksandr Botsula
 * @version 1.0
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SystemFacade systemFacade;

    @Autowired
    private SecurityService securityService;
    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private HallService hallService;
    @Autowired
    private GameService gameService;
    @Autowired
    private TourService tourService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model, @ModelAttribute User user) {
        userValidator.validate(userForm, bindingResult);
        ModelAndView modelAndView = new ModelAndView();


        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
            return modelAndView;
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());


        modelAndView.addObject(user);
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout, String username) {
        System.out.println(username);
        if (error != null) {
            System.out.print(error);
            model.addAttribute("error", "Неверный логин или пароль!");
        }


        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }
        return "login";
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {

        return "about";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    String index(Model model, @ModelAttribute User user) {

        return "index";
    }

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public String players(Model model) {

        return "players";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model) {
        return "statist/test";
    }

    @RequestMapping(value = "/statist_tournament", method = RequestMethod.GET)
    public String statist(Model model) {
        List<Tournament> tournaments = tournamentService.findAll();
        model.addAttribute("tournaments", tournaments);

        return "statist/statist_tournament";
    }


    @RequestMapping(value = "/tournament_show",
            params = {"id"}
    )
    public
    @ResponseBody
    ModelAndView showTournament(Model model, @RequestParam(value = "id") String id) {
        System.out.print(id);
        Tournament tournament = tournamentService.findTournamentById(Long.parseLong(id));
        model.addAttribute("item", tournament);
        List<Team> teams = tournament.getTeams();
        List<TableCreator> tables = new ArrayList<>();
        for (Team team : teams) {
            tables.add(new TableCreator(team, tournament.getGames()));
        }

        ModelAndView mw = new ModelAndView();
        mw.addObject("tables", tables);
        mw.setViewName("statist/tournament_show");
        return mw;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("tourForm") Tournament tournForm, BindingResult bindingResult, Model model) {

        System.out.println(tournForm);

        return "redirect:/statis_tournament";
    }

    @RequestMapping(value = "/admin_cabinet", method = RequestMethod.GET)
    public String adminCabinet(Model model){
        return "admin/admin_info";
    }

}
