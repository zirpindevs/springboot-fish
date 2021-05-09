package com.example.springbootfish.controller;

import com.example.springbootfish.model.Fish;
import com.example.springbootfish.repository.FishRepository;
import com.example.springbootfish.util.HibernateUtil;
import io.swagger.annotations.ApiOperation;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FishController {

    private final Logger log = LoggerFactory.getLogger(FishController.class);

    private final FishRepository fishRepo;

    public FishController(FishRepository repository) {
        this.fishRepo = repository;
    }

    @GetMapping("/fishes")
    public List<Fish> findFishes(){
        log.debug("REST request to find all employees");
        return fishRepo.findAll();
    }

    @GetMapping("/fishes/count")
    public Long countFish(Fish fish) {
        return fishRepo.count();

    }

    @GetMapping("/fishes/{id}")
    public ResponseEntity<Fish> findOne(@PathVariable Long id){
        log.debug("REST request to find one fish: {} ",id);
        Optional<Fish> fishOpt = fishRepo.findById(id);
        if(fishOpt.isPresent())
            return ResponseEntity.ok().body(fishOpt.get());

       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // 4 . CREATE
    @PostMapping("/fishes")
    public void createFish(@RequestBody Fish fish) throws URISyntaxException {
        log.debug("REST request to save a fish: {} ", fish);
/*        if (fish.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);*/

        Fish createdFish = fishRepo.save(fish);
 /*       return ResponseEntity
                .created(new URI("/api/fishes/" + createdFish.getId()))
                .body(createdFish);*/


    Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        System.out.println(fish);
    // guardamos
        session.save(fish);
    // session.detach(employee1);
        System.out.println(fish);
        session.getTransaction().commit();

        System.out.println(fish);
        session.close();
    }



    // 3. RETRIEVE ONE BY PROPERTY

    @GetMapping("/fishes/buscar/{color}")
    public ResponseEntity<Fish> findOne(@PathVariable String color) throws URISyntaxException {
        log.debug(" REQUEST to find one fish by color: {} ", color);

        Fish findFish = fishRepo.findByColor(color);
        if(findFish == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok().body(findFish);
    }

    //FILTRAR POR SIZE
    @GetMapping("/fishes/long_size/{size}")
    @ApiOperation("filtra por long size")
    public ResponseEntity<Fish> filterBySize(@PathVariable Long size){
        log.debug(" REQUEST to find allfish by size: {} ", size);
        Fish findFish = fishRepo.findAllByLongSize(size);
        if(findFish == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().body(findFish);
    }

        // 5. UPDATE
    @PutMapping("/fishes/{id}")
    public ResponseEntity<Fish> updateFish(@RequestBody Fish fish){
        log.debug("REST request to update one fish: {} ",fish);

        if(fish.getId() == null) {
            log.warn("update fish without id");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Fish updatedFish = fishRepo.save(fish);
        return ResponseEntity.ok().body(updatedFish);
    }

    /*
    // 8 . SORT
    Sort colorSort = Sort.by("color");
		System.out.println(fishRepo.findAll(colorSort));
    // 9. PAGE

    // 6. DELETE

     */
    @DeleteMapping("/fishes/{id}")
    public ResponseEntity<Void> deleteFish(@PathVariable Long id){
        log.debug("REST request to deleteFish a fish: {} ", id);

        if (fishRepo.existsById(id))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        fishRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //DELETE ALL
    @DeleteMapping("/fishes/")
    public ResponseEntity<Void> deleteAll(){
        log.debug("REST request to deleteAll a fish");

        fishRepo.deleteAll();
        return ResponseEntity.noContent().build();
    }



}
