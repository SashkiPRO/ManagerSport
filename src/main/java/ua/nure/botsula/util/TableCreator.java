package ua.nure.botsula.util;

import net.proselyte.springsecurityapp.model.Game;
import net.proselyte.springsecurityapp.model.Team;

import java.util.List;

/**
 * Created by Alexandr on 03.05.2017.
 */
public class TableCreator {
    private Team team;
    private List<Game> gameList;
    private int game;
    private int win;
    private int lose;
    private int draw;
    private int goalScored;
    private int goalMissed;
    private int points;

    public TableCreator() {
    }

    public Team getTeam() {
        return team;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public int getGame() {
        return game;
    }

    public int getWin() {
        return win;
    }

    public int getLose() {
        return lose;
    }

    public int getDraw() {
        return draw;
    }

    public int getGoalScored() {
        return goalScored;
    }

    public int getGoalMissed() {
        return goalMissed;
    }

    public int getPoints() {
        return points;
    }

    public TableCreator(Team team, List<Game> gameList) {

        this.team = team;
        this.gameList = gameList;
        game = 0;
        win = 0;
        lose = 0;
        goalMissed = 0;
        goalScored = 0;
        points = 0;
        draw = 0;
        countPoints(team, gameList);

    }

    private void countPoints(Team team, List<Game> list) {
        for (Game game : list) {
            separateGame(team, game);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableCreator that = (TableCreator) o;

        if (draw != that.draw) return false;
        if (game != that.game) return false;
        if (goalMissed != that.goalMissed) return false;
        if (goalScored != that.goalScored) return false;
        if (lose != that.lose) return false;
        if (points != that.points) return false;
        if (win != that.win) return false;
        if (gameList != null ? !gameList.equals(that.gameList) : that.gameList != null) return false;
        if (team != null ? !team.equals(that.team) : that.team != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = game;
        result = 31 * result + points;
        return result;
    }

    private void separateGame(Team team, Game unit) {


        if (team.equals(unit.getHomeTeam()) && unit.getAwayTeam() != null) {
            if (unit.getHomeTeamGoals() != null) {
                game++;
                if (unit.getHomeTeamGoals() > unit.getAwayTeamGoals()) {

                    win++;
                    points += 3;
                    goalMissed += unit.getAwayTeamGoals();
                    goalScored += unit.getHomeTeamGoals();
                } else if (unit.getHomeTeamGoals().equals(unit.getAwayTeamGoals())) {
                    draw++;
                    points++;
                    goalMissed += unit.getAwayTeamGoals();
                    goalScored += unit.getHomeTeamGoals();
                } else {
                    lose++;
                    goalMissed += unit.getAwayTeamGoals();
                    goalScored += unit.getHomeTeamGoals();
                }
            }

        } else {

            if (unit.getAwayTeamGoals() != null) {
                if (team.equals(unit.getAwayTeam()) && unit.getHomeTeam() != null) {
                    game++;
                    if (unit.getAwayTeamGoals() > unit.getHomeTeamGoals()) {
                        win++;
                        points += 3;
                        goalMissed += unit.getHomeTeamGoals();
                        goalScored += unit.getAwayTeamGoals();
                    } else if (unit.getAwayTeamGoals().equals(unit.getHomeTeamGoals())) {
                        draw++;
                        points++;
                        goalMissed += unit.getHomeTeamGoals();
                        goalScored += unit.getAwayTeamGoals();
                    } else {
                        lose++;
                        goalMissed += unit.getHomeTeamGoals();
                        goalScored += unit.getAwayTeamGoals();
                    }
                }
            }
        }
    }
}



