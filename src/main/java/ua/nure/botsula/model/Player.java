package ua.nure.botsula.model;

import org.hibernate.annotations.Type;
import org.joda.time.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Alexandr on 30.04.2017.
 */
@Entity
@Table(name = "player")
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "number")
    private int number;

    @Column(name = "position")
    private String position;

    @Lob @Basic
    @Column(name = "photo")
    private byte[] photo;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Column(name = "birth_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private DateTime birthDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    private List<YellowCard> yellowCards;

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "players")
    private Set<Game> games;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (number != player.number) return false;
        if (!firstName.equals(player.firstName)) return false;
        if (!id.equals(player.id)) return false;
        if (!lastName.equals(player.lastName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        return
                 firstName + '\''
                 + lastName + '\'' +
                 number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    @Transient
    public String getBirthDateString() {
        String birthDateString = "";
        if (birthDate != null) {
            birthDateString = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd").print(birthDate);
        }
        return birthDateString;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<YellowCard> getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(List<YellowCard> yellowCards) {
        this.yellowCards = yellowCards;
    }

    public List<RedCard> getRedCards() {
        return redCards;
    }

    public void setRedCards(List<RedCard> redCards) {
        this.redCards = redCards;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    @OneToMany(mappedBy = "player",fetch = FetchType.EAGER)
    private List<RedCard> redCards;

    @OneToMany(mappedBy = "player",fetch = FetchType.EAGER)
    private List<Goal> goals;

}
