package ua.nure.botsula.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

/**
 * Created by Alexandr on 02.06.2017.
 */
@Entity
@Table(name = "default_images")
public class DefaultImage {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
   private String name;
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name = "image")
    private byte[] image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
