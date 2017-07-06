package ua.nure.botsula.model;

import org.hibernate.annotations.Type;
import org.joda.time.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Alexandr on 30.04.2017.
 */
@Entity
@Table(name = "game")
public class Game implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "home_team")
    private Team homeTeam;

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "player_games", joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private Set<Player> players;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (awayTeam != null ? !awayTeam.equals(game.awayTeam) : game.awayTeam != null) return false;
        if (awayTeamGoals != null ? !awayTeamGoals.equals(game.awayTeamGoals) : game.awayTeamGoals != null)
            return false;
        if (date != null ? !date.equals(game.date) : game.date != null) return false;
        if (dateString != null ? !dateString.equals(game.dateString) : game.dateString != null) return false;
        if (hall != null ? !hall.equals(game.hall) : game.hall != null) return false;
        if (homeTeam != null ? !homeTeam.equals(game.homeTeam) : game.homeTeam != null) return false;
        if (homeTeamGoals != null ? !homeTeamGoals.equals(game.homeTeamGoals) : game.homeTeamGoals != null)
            return false;
        if (id != null ? !id.equals(game.id) : game.id != null) return false;
        if (players != null ? !players.equals(game.players) : game.players != null) return false;
        if (tour != null ? !tour.equals(game.tour) : game.tour != null) return false;
        if (tournament != null ? !tournament.equals(game.tournament) : game.tournament != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (homeTeam != null ? homeTeam.hashCode() : 0);
        result = 31 * result + (players != null ? players.hashCode() : 0);
        result = 31 * result + (awayTeam != null ? awayTeam.hashCode() : 0);
        result = 31 * result + (hall != null ? hall.hashCode() : 0);
        result = 31 * result + (dateString != null ? dateString.hashCode() : 0);
        result = 31 * result + (tour != null ? tour.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (homeTeamGoals != null ? homeTeamGoals.hashCode() : 0);
        result = 31 * result + (tournament != null ? tournament.hashCode() : 0);
        result = 31 * result + (awayTeamGoals != null ? awayTeamGoals.hashCode() : 0);
        return result;
    }



    @ManyToOne
    @JoinColumn(name = "away_team")
    private Team awayTeam;
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;


    @Transient
    private String dateString;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;


    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private DateTime  date;

    public void setHomeTeamGoals(Integer homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    @Column(name = "home_team_goal")
    private Integer homeTeamGoals;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", dateString='" + dateString + '\'' +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;
    public Integer getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    public Integer getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    @Column(name = "away_team_goal")
    private Integer awayTeamGoals;
    public Long getId() {
        return id;
    }

    public void setAwayTeamGoals(Integer awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public DateTime getDate() {
        return date;
    }
    @Transient
    public String getDateString() {
         dateString = "";
        if (date != null) {
            dateString = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm").print(date);
        }
        return dateString;
    }
    public void setDate(DateTime date) {
        this.date = date;
    }


}
