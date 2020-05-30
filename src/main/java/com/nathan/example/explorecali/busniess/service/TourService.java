package com.nathan.example.explorecali.busniess.service;

import com.nathan.example.explorecali.data.entity.Tour;
import com.nathan.example.explorecali.data.entity.TourPackage;
import com.nathan.example.explorecali.data.repo.TourPackageRepository;
import com.nathan.example.explorecali.data.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        super();
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

//    public Tour createTour(String name, String blurb, String desc, double price,
//                           String diff, String graph, int tourLength,
//                           String region, String keywords, Integer tPackageCode) {
//        TourPackage tPackage = (TourPackage) this.tourPackageRepository.findById(tPackageCode);
//        if (tPackage == null) {
//            throw new RuntimeException("Tour package does not exist: " + tPackageCode);
//        }
//        return this.tourRepository.save(new Tour(name, blurb, desc, price, diff, graph, tourLength, region, keywords, tPackage));
//    }

    public Iterable<Tour> lookup() {
        return this.tourRepository.findAll();
    }

    public long total() {
        return this.tourRepository.count();
    }
}
