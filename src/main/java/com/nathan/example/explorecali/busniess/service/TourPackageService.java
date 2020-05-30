package com.nathan.example.explorecali.busniess.service;

import com.nathan.example.explorecali.data.entity.Tour;
import com.nathan.example.explorecali.data.entity.TourPackage;
import com.nathan.example.explorecali.data.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        super();
    }


}
