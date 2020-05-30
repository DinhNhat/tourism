package com.nathan.example.explorecali;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExplorecaliApplication implements CommandLineRunner {
//	@Autowired
//	TourService tourService;
//
//	@Autowired
//	TourPackageService tourPackageService;
//
//	@Autowired
//	ExplorerService explorerService;
//
//	@Autowired
//	StateRepository stateRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExplorecaliApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Spring boot 2");
//		System.out.println("\n********Total number of explorers***********");
//		System.out.println(this.explorerService.total());
//
//		System.out.println("\n********Total number of states***********");
//		System.out.println(this.stateRepository.count());
		// Create Package Vietnam
//		this.tourPackageService.createTourPackage("Vietnam title", "Vietnam description", "Vietnamese graphic");
//		this.tourPackageService.lookup().forEach(System.out::println);
//		System.out.println("\n********Total number of packages***********");
//		System.out.println(this.tourPackageService.total());
//		 Create Tour Package Vietnam
//		this.tourService.createTour("Vietname tour", "Vietnamese blurb", "Vietnamese description",
//				1200, "Medium", "Vietnamese graphic", 5,
//				"Asia", "Sea, Coast, Island", 10);
//		this.tourService.lookup().forEach(System.out::println);
//		System.out.println("\n********Total number of tours***********");
//		System.out.println(this.tourService.total());
	}
}
