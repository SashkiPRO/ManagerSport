package ua.nure.botsula.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */
@Entity
@Table(name = "tournament")
public class Tournament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "icon")
    private byte[] icon;
    @NotEmpty(message = "Empty value")
    @Size(min = 3, max = 20, message = "A lot of symbols!")
    @Column(name = "name")
    private String name;
    @Column(name = "administrator")
    private String administrator;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @OneToMany(mappedBy = "tournament", fetch = FetchType.EAGER)
    private List<Team> teams;

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @OneToMany(mappedBy = "tournament", fetch = FetchType.EAGER)
    private List<Tour> tours;
    @OneToMany(mappedBy = "tournament", fetch = FetchType.EAGER)
    private List<Game> games;

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }
}
