package com.example.springbootfish;

import com.example.springbootfish.model.Fish;
import com.example.springbootfish.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class SpringbootFishApplication{

	@Autowired
	private FishRepository fishRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFishApplication.class, args);
	}



	/*	System.out.println("----------------------------------------------------------------------------------------");
		long peces = fishRepo.count();
		System.out.println("numero peces:" + peces);

		// 4 . CREATE

		Fish fish1 = new Fish("trucha", 10L, "azul", "dulce", "fria", true);
		fishRepo.save(fish1);

		Fish fish2 = new Fish("salmon", 40L, "rosa", "todas", "fria", true);
		fishRepo.save(fish2);

		Fish fish99 = new Fish("megalodon", 400L, "negro", "salada", "fria", false);
		fishRepo.save(fish99);

		Fish fish3 = new Fish("piranha", 4L, "blanco", "dulce", "caliente", true);
		fishRepo.save(fish3);
		Fish fish4 = new Fish("tiburon", 40L, "azul", "salada", "caliente", false);
		fishRepo.save(fish4);

		peces = fishRepo.count();
		System.out.println("----------------------------------------------------------------------------------------");

		System.out.println("numero peces:" + peces);
		System.out.println("----------------------------------------------------------------------------------------");

		// 1. RETRIEVE ALL
		List<Fish> fishList = fishRepo.findAll();
		System.out.println(fishList);
		System.out.println("----------------------------------------------------------------------------------------");
		// 2. RETRIEVE ONE
		System.out.println("El pez con Id " + fish99.getId() + " es " + fishRepo.findById(fish99.getId()));
		System.out.println("----------------------------------------------------------------------------------------");

		// 3. RETRIEVE ONE BY PROTERTY
		System.out.println(fishRepo.findByFamilyName("salmon"));
		System.out.println("----------------------------------------------------------------------------------------");


		// 5. UPDATE

		// 8 . SORT
		Sort colorSort = Sort.by("color");
		System.out.println(fishRepo.findAll(colorSort));
		// 9. PAGE
		System.out.println("----------------------------------------------------------------------------------------");

		// 6. DELETE
		fishRepo.delete(fish99);
		System.out.println(fishRepo.findAll());
		System.out.println("----------------------------------------------------------------------------------------");

		// 7. DELETE ALL
		fishRepo.deleteAll();
		System.out.println(fishRepo.findAll());

		System.out.println("----------------------------------------------------------------------------------------");

	}*/
}
