package ua.nure.botsula.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alexandr on 30.04.2017.
 */
@Entity
@Table(name = "red_card")
public class RedCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "minute")
    private int minute;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

}
