package com.nathan.example.explorecali;

import com.nathan.example.explorecali.data.entity.TourPackage;
import com.nathan.example.explorecali.data.repo.TourPackageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExplorecaliApplicationTests {

	@Autowired
	TourPackageRepository tourPackageRepository;

	@Test
	void contextLoads() {
		this.tourPackageRepository.deleteById(1);
		System.out.println("Deleted successfully!");
	}

}
