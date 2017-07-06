package ua.nure.botsula.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Alexandr on 30.04.2017.
 */
@Entity
@Table(name = "hall")
public class Hall implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "adress")
    private String adress;
    @Basic
    @Column(name = "picture")
    private byte[] picture;

    @OneToMany(mappedBy = "hall")
    private List<Game> games;

    @OneToMany(mappedBy = "hall")
    private List<Event> events;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hall hall = (Hall) o;

        if (!adress.equals(hall.adress)) return false;
        if (!name.equals(hall.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + adress.hashCode();
        return result;
    }
}
