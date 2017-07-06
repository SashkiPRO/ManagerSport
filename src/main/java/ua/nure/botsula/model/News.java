package ua.nure.botsula.model;

import org.hibernate.annotations.Type;
import org.joda.time.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * Created by Alexandr on 06.06.2017.
 */
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "handler")
    private String handler;

    @Column(name = "text")
    private String text;
    public String getText() {
        return text;
    }

    public DateTime getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(DateTime newsDate) {
        this.newsDate = newsDate;
    }

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "dateNews")
    private DateTime newsDate;

    public void setText(String text) {
        this.text = text;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
