package ua.nure.botsula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.botsula.model.*;
import ua.nure.botsula.service.PlayerService;
import ua.nure.botsula.service.TeamService;
import ua.nure.botsula.service.TournamentService;
import ua.nure.botsula.util.PlayerPropertiesEditor;
import ua.nure.botsula.util.PropertiesEditor;
import ua.nure.botsula.util.TournamentPropertyEditor;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Alexandr on 14.05.2017.
 */
@Controller
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private PropertiesEditor propertiesEditor;
    @Autowired
    private PlayerPropertiesEditor playerPropertiesEditor;
    @Autowired
    private TournamentPropertyEditor tournamentPropertyEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Team.class, this.propertiesEditor);
        binder.registerCustomEditor(Tournament.class, this.tournamentPropertyEditor);
        binder.registerCustomEditor(Player.class, this.playerPropertiesEditor);
    }

    @RequestMapping(value = "form_aplication", params = {"team_id", "game_id"}, method = RequestMethod.GET)
    public
    @ResponseBody
    ModelAndView addApplication(Model m, @PathVariable @RequestParam(value = "team_id") String teamId, @RequestParam(value = "game_id") String gameId) {


        Game game = gameService.findGameById(Long.parseLong(gameId));

        Team team = teamService.findTeamById(Long.parseLong(teamId));
        List<Player> players = playerService.findPlayersByTeam(team);
        for (Player player : players) {
            System.out.println(player);
        }
        m.addAttribute("game", game);
        m.addAttribute("players", players);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("statist/form_aplication");
        return modelAndView;
    }

    @RequestMapping(value = "add_team",
            method = RequestMethod.GET)
    public
    @ResponseBody
    ModelAndView addTeam(Model m) {
        m.addAttribute("newTeam", new Team());
        List<Tournament> tournaments = tournamentService.findAll();
        m.addAttribute("tournaments", tournaments);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("statist/add_team");

        return modelAndView;

    }

    @RequestMapping(value = "form_aplication", params = {"game_id", "team_id"}, method = RequestMethod.POST)
    public String addAplication(@ModelAttribute Game game, Model model, @RequestParam("game_id") String id, @RequestParam("team_id") String teamId) {

        Team team = teamService.findTeamById(Long.parseLong(teamId));
        Game game1 = gameService.findGameById(Long.parseLong(id));
        Set<Player> playersList = game.getPlayers();
        Set<Player> finalPlayerList = game1.getPlayers();
        Set<Player> temp = new HashSet<>();
        for (Iterator<Player> iterator = finalPlayerList.iterator(); iterator.hasNext(); ) {
            Player player = iterator.next();
            if (player.getTeam().equals(team) && !playersList.contains(player)) {
                temp.add(player);
            }
        }
        finalPlayerList.removeAll(temp);
        finalPlayerList.addAll(playersList);
        game1.setPlayers(finalPlayerList);
        gameService.save(game1);
        return "redirect:/statist_tournament";
    }

    @RequestMapping(value = "add_team", method = RequestMethod.POST)
    public String addTeamClick(@ModelAttribute Team newTeam, @ModelAttribute MultipartFile file, Model model) {


        try {
            newTeam.setSymbol(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        teamService.save(newTeam);


        System.out.print(file);
        return "redirect:/statist_tournament";
    }


    @RequestMapping(value = "show_team", params = {"id"})
    @ResponseBody
    public ModelAndView showTeam(Model model, @RequestParam(value = "id") String id) {
        Team team = teamService.findTeamById(Long.parseLong(id));
        List<Player> players = playerService.findPlayersByTeam(team);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("team", team);
        modelAndView.addObject("players", players);
        modelAndView.setViewName("statist/show_team");
        return modelAndView;
    }

    @RequestMapping(value = "add_player", params = {"team_id"}, method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView addPlayerPage(Model model, @RequestParam(value = "team_id") String teamId) {
        Long team = Long.parseLong(teamId);
        Team teams = teamService.findTeamById(team);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newPlayer", new Player());
        modelAndView.addObject("team", teams);
        modelAndView.setViewName("statist/add_player");
        return modelAndView;
    }

    @RequestMapping(value = "add_player", method = RequestMethod.POST)
    public String addPlayerClick(@ModelAttribute Player newPlayer, Model model) {
        playerService.save(newPlayer);
        System.out.print(newPlayer);
        StringBuilder address = new StringBuilder();
        address.append("redirect:/show_team?id=");
        address.append(newPlayer.getTeam().getId());

        return address.toString().trim();
    }

    @RequestMapping(value = "view_player_info", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showPlayerInfo(@RequestParam(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        Player player = playerService.findPlayerById(Long.parseLong(id));
        modelAndView.addObject("player", player);
        modelAndView.setViewName("statist/view_player_info");
        return modelAndView;
    }

    @RequestMapping(value = "team_list")
    public String showTeamsList(Model model) {
        List<Team> teams = teamService.findAll();
        model.addAttribute("teams", teams);
        return "statist/teams_list";
    }
}
