package com.nathan.example.explorecali.web;

import com.nathan.example.explorecali.data.entity.Tour;
import com.nathan.example.explorecali.data.entity.TourRating;
import com.nathan.example.explorecali.data.entity.TourRatingPk;
import com.nathan.example.explorecali.data.repo.TourRatingRepository;
import com.nathan.example.explorecali.data.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingWebServiceController {
    TourRatingRepository tourRatingRepository;
    TourRepository tourRepository;

    @Autowired
    public TourRatingWebServiceController(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
        this.tourRatingRepository = tourRatingRepository;
        this.tourRepository = tourRepository;
    }

    protected TourRatingWebServiceController() {}


    @RequestMapping(method = RequestMethod.GET)
    public Page<RatingDTO> getAllRatingsForTour(@PathVariable(value = "tourId")int tourId, Pageable pageable) {
        verifyTour(tourId);
        Page<TourRating> tourRatingPage = this.tourRatingRepository.findByPk_TourId(tourId, pageable);
        List<RatingDTO> ratingDTOList = tourRatingPage.getContent().stream().map(tourRating -> toDto(tourRating))
                .collect(Collectors.toList());
        return new PageImpl<RatingDTO>(ratingDTOList, pageable, tourRatingPage.getTotalPages());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void creatTourRating(@PathVariable(value = "tourId")Integer tourId, @RequestBody @Validated RatingDTO ratingDto) {
        Tour tour = verifyTour(tourId);
        this.tourRatingRepository.save(new TourRating(new TourRatingPk(tour.getId(),
                ratingDto.getCustomerId()), ratingDto.getScore(), ratingDto.getComment()));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/average")
    public AbstractMap.SimpleEntry<String, Double> getAverage(@PathVariable(value = "tourId")int tourId) {
        verifyTour(tourId);
        List<TourRating> tourRatings = this.tourRatingRepository.findByPk_TourId(tourId);
        OptionalDouble average = tourRatings.stream().mapToInt(TourRating::getScore).average();
        return new AbstractMap.SimpleEntry<String, Double>("average", average.isPresent()?average.getAsDouble():null);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public RatingDTO updateWithPut(@PathVariable(value = "tourId")int tourId, @RequestBody @Validated RatingDTO ratingDTO) {
        TourRating tourRating = verifyTourRating(tourId, ratingDTO.getCustomerId());
        tourRating.setScore(ratingDTO.getScore());
        tourRating.setComment(ratingDTO.getComment());
        return toDto(this.tourRatingRepository.save(tourRating));
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public RatingDTO updateWithPatch(@PathVariable(value = "tourId")int tourId, @RequestBody @Validated RatingDTO ratingDTO) {
        TourRating tourRating = verifyTourRating(tourId, ratingDTO.getCustomerId());
        if(ratingDTO.getScore() != null) {
            tourRating.setScore(ratingDTO.getScore());
        }
        if (ratingDTO.getComment() != null) {
            tourRating.setComment(ratingDTO.getComment());
        }
        return toDto(this.tourRatingRepository.save(tourRating));
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "/{customerId}")
    public void delete(@PathVariable(value = "tourId")int tourId, @PathVariable(value = "customerId")int customerId) {
        TourRating tourRating = verifyTourRating(tourId, customerId);
        tourRatingRepository.delete(tourRating);
    }


    /**
     * Verify and return the TourRating for a particular tourId and Customer
     * @param tourId
     * @param customerId
     * @return the found TourRating
     * @throws NoSuchElementException if no TourRating found
     */
    private TourRating verifyTourRating(int tourId, int customerId) throws NoSuchElementException {
        TourRating rating = tourRatingRepository.findByPk_TourIdAndExplorerId(tourId, customerId);
        if (rating == null) {
            throw new NoSuchElementException("Tour-Rating pair for request("
                    + tourId + " for customer" + customerId);
        }
        return rating;
    }

    /**
     * Convert the TourRating entity to a RatingDto
     *
     * @param tourRating
     * @return RatingDto
     */
    private RatingDTO toDto(TourRating tourRating) {
        return new RatingDTO(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().getExplorerId());
    }


    /**
     * Verify and return the Tour given a tourId.
     *
     * @param tourId
     * @return the found Tour
     * @throws NoSuchElementException if no Tour found.
     */
    private Tour verifyTour(int tourId) throws NoSuchElementException {
        return this.tourRepository.findById(tourId)
                .orElseThrow(() -> new NoSuchElementException("Tour does not exist " + tourId));
    }

    /**
     * Exception handler if NoSuchElementException is thrown in this Controller
     *
     * @param ex
     * @return Error message String.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }
}
