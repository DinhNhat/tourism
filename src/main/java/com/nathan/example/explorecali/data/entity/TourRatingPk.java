package com.nathan.example.explorecali.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class TourRatingPk implements Serializable {
    @Column(name = "tour_id")
    private Integer tourId;

    @Column(name = "customer_id")
    private Integer explorerId;

    public TourRatingPk() {}

    public TourRatingPk(Integer tour, Integer explorer) {
        this.tourId = tour;
        this.explorerId = explorer;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getExplorerId() {
        return explorerId;
    }

    public void setExplorerId(Integer explorerId) {
        this.explorerId = explorerId;
    }

    @Override
    public int hashCode() {
        int result = tourId.hashCode();
        result = 31 * result + explorerId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TourRatingPk that = (TourRatingPk) o;

        if (!tourId.equals(that.tourId)) return false;
        return explorerId.equals(that.explorerId);
    }

    @Override
    public String toString() {
        return "TourRatingPk{" +
                "tour=" + tourId +
                ", explorer=" + explorerId +
                '}';
    }
}
