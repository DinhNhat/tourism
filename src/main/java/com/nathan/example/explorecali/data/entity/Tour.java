package com.nathan.example.explorecali.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tourId")
    private Integer id;
    @Column(name = "tourName")
    private String name;
    @Column(name = "blurb", length = 1024)
    private String blurb;
    @Column(name = "description", length = 4096)
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "difficulty")
    private String difficulty;
    @Column(name = "graphic")
    private String graphic;
    @Column(name = "length")
    private Integer tourLength;
    @Column(name = "region")
    private String region;
    @Column(name = "keywords", length = 200)
    private String keywords;

    @ManyToOne
    @JoinColumn(name = "packageId")
    private TourPackage tourPackage;

    @OneToMany(mappedBy = "tour")
    private List<TourRating> tourRatings = new ArrayList<>();

    public Tour() {}

    public Tour(String name, String blurb, String description,
                Double price, String difficulty, String graphic,
                Integer tourLength, String region, String keywords, TourPackage tPackage) {
        this.name = name;
        this.blurb = blurb;
        this.description = description;
        this.price = price;
        this.difficulty = difficulty;
        this.graphic = graphic;
        this.tourLength = tourLength;
        this.region = region;
        this.keywords = keywords;
        this.tourPackage = tPackage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public Integer getTourLength() {
        return tourLength;
    }

    public void setTourLength(Integer tourLength) {
        this.tourLength = tourLength;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blurb='" + blurb + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", difficulty='" + difficulty + '\'' +
                ", graphic='" + graphic + '\'' +
                ", tourLength=" + tourLength +
                ", region='" + region + '\'' +
                ", keywords='" + keywords + '\'' +
                ", tourPackage=" + tourPackage.getTitle() +
                ", tourRatings=" + tourRatings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(id, tour.id) &&
                Objects.equals(name, tour.name) &&
                Objects.equals(description, tour.description) &&
                Objects.equals(blurb, tour.blurb) &&
                Objects.equals(price, tour.price) &&
                Objects.equals(difficulty, tour.difficulty) &&
                Objects.equals(graphic, tour.graphic) &&
                Objects.equals(keywords, tour.keywords) &&
                Objects.equals(tourLength, tour.tourLength) &&
                Objects.equals(region, tour.region) &&
                Objects.equals(keywords, tour.keywords);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
