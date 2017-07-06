package ua.nure.botsula.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alexandr on 30.04.2017.
 */
@Entity
@Table(name = "goal")
public class Goal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "minute")
    private int minute;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

}
