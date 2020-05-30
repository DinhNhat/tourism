package com.nathan.example.explorecali.data.entity;

import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tourrating")
public class TourRating {
    @EmbeddedId
    private TourRatingPk pk;

    @ManyToOne
    @MapsId("tour_id")
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne
    @MapsId("customer_id")
    @JoinColumn(name = "customer_id")
    private Explorer explorer;

    @Column(name = "score", nullable = false)
    private Integer score;
    @Column(name = "cus_comment", length = 255)
    private String comment;

    public TourRating() {}

    public TourRating(TourRatingPk pk, Integer score, String comment) {
        this.pk = pk;
        this.score = score;
        this.comment = comment;
    }

    public TourRatingPk getPk() {
        return pk;
    }

    public void setPk(TourRatingPk pk) {
        this.pk = pk;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "TourRating{" +
                "pk=" + pk +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TourRating that = (TourRating) obj;
        return Objects.equals(pk, that.pk) &&
                Objects.equals(score, that.score) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, score, comment);
    }
}
