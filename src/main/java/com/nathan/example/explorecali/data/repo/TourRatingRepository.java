package com.nathan.example.explorecali.data.repo;

import com.nathan.example.explorecali.data.entity.TourRating;
import com.nathan.example.explorecali.data.entity.TourRatingPk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported=false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {
    /**
     * Lookup all the TourRatings for a tour.
     *
     * @param tourId is the tour Identifier
     * @return a List of any found TourRatings
     */
    List<TourRating> findByPk_TourId(Integer tourId);

    /**
     * Lookup a page of TourRatings for a tour.
     *
     * @param tourId tourId is the tour Identifier
     * @param pageable details for the desired page
     * @return a Page of any found TourRatings
     */
    Page<TourRating> findByPk_TourId(Integer tourId, Pageable pageable);

    /**
     * Lookup a TourRating by the TourId and Customer Id
     * @param tourId
     * @param customerId
     * @return TourRating if found, null otherwise.
     */
    TourRating findByPk_TourIdAndExplorerId(Integer tourId, Integer customerId);
}
