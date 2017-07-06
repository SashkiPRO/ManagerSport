package ua.nure.botsula.controller;

import net.proselyte.springsecurityapp.model.*;
import net.proselyte.springsecurityapp.service.HallService;
import net.proselyte.springsecurityapp.service.TournamentService;
import net.proselyte.springsecurityapp.util.HallPropertiesEditor;
import net.proselyte.springsecurityapp.util.PropertiesEditor;
import net.proselyte.springsecurityapp.util.TourPropertyEditor;
import net.proselyte.springsecurityapp.util.TournamentPropertyEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alexandr on 06.05.2017.
 */
@Controller
public class TournamentContoller {
    @Autowired
    private TournamentService tournamentService;
    @Autowired
    private TourService tourService;
    @Autowired
    private HallService hallService;
    @Autowired
    private PropertiesEditor propertiesEditor;
    @Autowired
    private HallPropertiesEditor hallPropertiesEditor;
    @Autowired
    private TourPropertyEditor tourPropertyEditor;
    @Autowired
    private GameService gameService;
    @Autowired
    private TournamentPropertyEditor tournamentPropertyEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Team.class, this.propertiesEditor);
        binder.registerCustomEditor(Hall.class, this.hallPropertiesEditor);
        binder.registerCustomEditor(Tour.class, this.tourPropertyEditor);
        binder.registerCustomEditor(Tournament.class, this.tournamentPropertyEditor);
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String loadFormPage(Model m) {
        m.addAttribute("tournament", new Tournament());
        return "statist/formPage";
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute @Valid Tournament tournament, BindingResult bindingResult, @ModelAttribute MultipartFile file, Model model) {
        if (bindingResult.hasErrors()) {
            populateError("name", model, bindingResult);
            return "statist/formPage";
        }

        try {
            tournament.setIcon(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        tournamentService.save(tournament);


        System.out.print(file);
        return "redirect:/statist_tournament";
    }

    @RequestMapping(value = "add_tour",method = RequestMethod.GET)
    public @ResponseBody ModelAndView addTour(Model m ){
        List<Tournament> tournaments =tournamentService.findAll();
            m.addAttribute("newTour", new Tour());
        m.addAttribute("tournaments", tournaments);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("statist/add_tour");
        return modelAndView;
    }
    @RequestMapping(value = "add_tour", method = RequestMethod.POST)
    public String addTour(@ModelAttribute Tour newTour, Model model){
        tourService.save(newTour);
        StringBuilder path = new StringBuilder();
        path.append("redirect:/tournament_show");
        path.append("?id="+newTour.getTournament().getId());
        return path.toString().trim();
    }
    @RequestMapping(value = "tours_view", method = RequestMethod.GET)
    public String toursList(Model model){
        List<Tour> tours = tourService.findAll();
        model.addAttribute("tours", tours);
        return "statist/tours_view";
    }


    @RequestMapping(value = "add_match",
            params = {"id"},
            method = RequestMethod.GET)
    public
    @ResponseBody
    ModelAndView addGame(Model m, @RequestParam(value = "id") String id) {
        m.addAttribute("newGame", new Game());
        m.addAttribute("item", tournamentService.findTournamentById(Long.parseLong(id)));
        List<Tour> tours = tourService.findAll();
        m.addAttribute("tours", tours);
        List<Hall> halls = hallService.findAll();
        m.addAttribute("halls", halls);
        List<Tournament> tournaments = tournamentService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("statist/match_add");

        return modelAndView;

    }

    @RequestMapping(value = "removeTournament", params = {"tournament_id"}, method = RequestMethod.GET)
    public
    @ResponseBody ModelAndView removeTournament(Model m, @RequestParam(value = "tournament_id") String id){
        Tournament tournament = tournamentService.findTournamentById(Long.parseLong(id));
        tourService.delete(tournament.getTours());
        tournamentService.remove(tournament);
      ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/statist_tournament");
       return modelAndView;
    }
    @RequestMapping(value = "add_match", method = RequestMethod.POST)
    public String addMatchClick(@ModelAttribute Game newGame, Model model) {
        gameService.save(newGame);

        return "redirect:/statist_tournament";
    }

    private void populateError(String field, Model model, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors(field)) {
            model.addAttribute(field + "Error", bindingResult.getFieldError(field).getDefaultMessage());
        }
    }

    @RequestMapping(value = "/results_show", params = {"id"}, method = RequestMethod.GET)
    public String resultPage(Model model, @RequestParam(value = "id") String id) {
        model.addAttribute("tournament", tournamentService.findTournamentById(Long.parseLong(id)));
        return "statist/results";
    }

}
