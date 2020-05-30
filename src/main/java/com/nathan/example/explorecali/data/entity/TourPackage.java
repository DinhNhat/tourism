package com.nathan.example.explorecali.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "packages")
public class TourPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "packageId")
    private Integer id;
    @Column(name = "packageTitle")
    private String title;
    @Column(name = "packageDescription")
    private String description;
    @Column(name = "packageGraphic")
    private String graphic;

    @OneToMany(mappedBy = "tourPackage",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Tour> tours = new ArrayList<>();

    public TourPackage() {}

    public TourPackage(String title, String description, String graphic) {
        this.title = title;
        this.description = description;
        this.graphic = graphic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public List<Tour> getTours() {
        return tours;
    }

    @Override
    public String toString() {
        return "TourPackage{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", graphic='" + graphic + '\'' +
                ", tours=" + tours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourPackage that = (TourPackage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(graphic, that.graphic) && Objects.equals(tours, that.getTours());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, graphic);
    }
}
