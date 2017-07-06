package util;


/**
 * Created by Alexandr on 12.06.2017.
 */

import net.proselyte.springsecurityapp.model.User;

public class GameVisitStatisticCreator {
   private User user;
    private int gameVisited;
    private int gameMissed;
    private int total;
    private double percentVisitedGames;
    public GameVisitStatisticCreator() {
    }

    public GameVisitStatisticCreator(User user, int gameVisited, int gameMissed, int total, double percentVisitedGames) {
        this.user = user;
        this.gameVisited = gameVisited;
        this.gameMissed = gameMissed;
        this.total = total;
        this.percentVisitedGames = percentVisitedGames;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;


    }


    public int getGameVisited() {
        return gameVisited;
    }

    public void setGameVisited(int gameVisited) {
        this.gameVisited = gameVisited;
    }

    public int getGameMissed() {
        return gameMissed;
    }

    public void setGameMissed(int gamedMissed) {
        this.gameMissed = gamedMissed;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getPercentVisitedGames() {
        return percentVisitedGames;
    }

    public void setPercentVisitedGames(double percentVisitedGames) {
        this.percentVisitedGames = percentVisitedGames;
    }
}
