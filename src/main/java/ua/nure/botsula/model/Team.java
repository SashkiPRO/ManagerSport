package ua.nure.botsula.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */
@Entity
@Table(name = "team")
public class Team implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "symbol")
    private byte[] symbol;
@OneToMany(mappedBy = "awayTeam")
    private List<Game> gamesAway;
    @OneToMany(mappedBy = "homeTeam")
    private List<Game> gamesHome;
    @OneToMany(mappedBy = "team")
    private List<Player> players;



    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (!id.equals(team.id)) return false;
        if (!name.equals(team.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getSymbol() {
        return symbol;
    }

    public void setSymbol(byte[] symbol) {
        this.symbol = symbol;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }




}
