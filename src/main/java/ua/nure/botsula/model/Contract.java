package ua.nure.botsula.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alexandr on 14.06.2017.
 */
@Entity
@Table(name = "contract")
public class Contract  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "date_start")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private DateTime dateStart;

    @Column(name = "salary")
    private double salary;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userContract;

    @Lob@Basic
    @Column(name = "document")
    private byte[] document;
    @Column(name = "during")
    private int during;
    @Transient
    private String startDateString;
    @Transient
    private String finishDateString;

    public Contract() {
    }

    @Transient
    public String getFinishDateString() {
    return "";
    }
    @Transient
    public String getStartDateString() {
        startDateString = "";
        if (dateStart != null) {
            startDateString = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm").print(dateStart);
        }
        return startDateString;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(DateTime dateStart) {
        this.dateStart = dateStart;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        byte[] newDocument = document;
        this.document = newDocument;
    }

    public void setStartDateString(String startDateString) {
        this.startDateString = startDateString;
    }

    public void setFinishDateString(String finishDateString) {
        this.finishDateString = finishDateString;
    }

    public User getUser() {
        return userContract;
    }

    public void setUser(User user) {
        this.userContract = user;
    }

    public int getDuring() {
        return during;
    }

    public void setDuring(int during) {
        this.during = during;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        if (Double.compare(contract.salary, salary) != 0) return false;
        if (id != null ? !id.equals(contract.id) : contract.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
