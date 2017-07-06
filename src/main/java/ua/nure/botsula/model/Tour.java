package ua.nure.botsula.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Alexandr on 01.05.2017.
 */
@Entity
@Table(name = "game_tour")
public class Tour implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
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

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @Override
    public String toString() {
        return name+"("+tournament+")";

    }

    @OneToMany(mappedBy = "tour", fetch = FetchType.EAGER)
    private List<Game> games;
}
