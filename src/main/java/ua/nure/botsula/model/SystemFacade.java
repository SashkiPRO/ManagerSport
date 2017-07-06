package ua.nure.botsula.model;

//import net.proselyte.springsecurityapp.dao.PlayerDao;
import net.proselyte.springsecurityapp.dao.PlayerDao;
import net.proselyte.springsecurityapp.service.DefaultImageService;
import net.proselyte.springsecurityapp.service.TeamService;
import net.proselyte.springsecurityapp.service.TournamentService;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Created by Alexandr on 11.04.2017.
 */
@Component("playerFacade")
@Scope("singleton")
public class SystemFacade {
   @Autowired
    private PlayerDao playerDao;
    private Player player;

    @Autowired
    private DefaultImageService defaultImageService;
    private DefaultImage defaultImage;


    public DefaultImage getDefaultImage(Long id) {
        return defaultImageService.findImageById(id);
    }

    public void setDefaultImage(DefaultImage defaultImage) {
        this.defaultImage = defaultImage;
    }

    @Autowired
    private TeamService teamService;
    private  Team team;
    @Autowired
    private TournamentService tournamentService;
    private Tournament tournament;

    @Autowired
    UserService userService;
    private User user;

    public User getUser(Long id) {
        return userService.findById(id);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Player getPlayer(Long id) {

        return playerDao.findPlayerById(id);
    }

    public Team getTeam(Long id) {
        return teamService.findTeamById(id);
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Tournament getTournament(Long id) {
        return tournamentService.findTournamentById(id);
    }

    public void setTournament( Tournament tournament) {
        final Tournament tournament1 =tournament;
        this.tournament = tournament1;
    }
}
