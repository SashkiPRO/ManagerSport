package ua.nure.botsula.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Alexandr on 11.06.2017.
 */
@Entity
@Table(name = "event")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private DateTime date;
    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private List<Message> messages;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_events", joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;
    @Transient
    private String dateString;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }
    @Transient
    public String getDateString() {
        dateString = "";
        if (date != null) {
            dateString = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm").print(date);
        }
        return dateString;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (date != null ? !date.equals(event.date) : event.date != null) return false;
        if (hall != null ? !hall.equals(event.hall) : event.hall != null) return false;
        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (type != null ? !type.equals(event.type) : event.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (hall != null ? hall.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
