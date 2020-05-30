package com.nathan.example.explorecali.web;

import com.nathan.example.explorecali.busniess.service.TourPackageNotFoundException;
import com.nathan.example.explorecali.data.entity.TourPackage;
import com.nathan.example.explorecali.data.repo.TourPackageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourPackageWebServiceController {
//    private final TourPackageRepository tourPackageRepository;
//
//    public TourPackageWebServiceController(TourPackageRepository tourPackageRepository) {
//        this.tourPackageRepository = tourPackageRepository;
//    }
//
//    // Aggregate root
//    @GetMapping("/packages")
//    Iterable<TourPackage> all() {
//        return this.tourPackageRepository.findAll();
//    }
//
//    @PostMapping("/packages")
//    TourPackage newTourPackage(@RequestBody TourPackage tPackage) {
//        return this.tourPackageRepository.save(tPackage);
//    }
//
//    // Single item
//
//    @GetMapping("/packages/{id}")
//    TourPackage one(@PathVariable Integer id) {
//        return this.tourPackageRepository.findById(id).orElseThrow(() -> new TourPackageNotFoundException(id));
//    }
//
//    @PutMapping("/packages/{id}")
//    TourPackage replaceTourPackage(@RequestBody TourPackage newTourPackage, @PathVariable Integer id) {
//        return this.tourPackageRepository.findById(id).map(tPackage -> {
//            tPackage.setTitle(newTourPackage.getTitle());
//            tPackage.setDescription(newTourPackage.getDescription());
//            tPackage.setGraphic(newTourPackage.getGraphic());
//            return tourPackageRepository.save(tPackage);
//        }).orElseGet(() -> {
//            newTourPackage.setId(id);
//            return this.tourPackageRepository.save(newTourPackage);
//        });
//    }
//
//    @DeleteMapping("/packages/{id}")
//    void deleteTourPackage(@PathVariable Integer id) {
//        this.tourPackageRepository.deleteById(id);
//    }
}
