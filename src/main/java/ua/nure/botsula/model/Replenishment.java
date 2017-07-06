package ua.nure.botsula.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * Created by Alexandr on 14.06.2017.
 */
@Entity
@Table(name = "replenishment")
public class Replenishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private DateTime date;
    @Transient
    private String dateString;
    @Column(name = "amount")
    private double amount;

    @Lob @Basic
    @Column(name = "image")
    private byte[] image;

    @Column(name = "description")
    private String description;

    public Replenishment() {
    }
    @Transient
    public String getDateString() {
        dateString = "";
        if (date != null) {
            dateString = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm").print(date);
        }
        return dateString;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
