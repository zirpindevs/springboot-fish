package com.example.springbootfish.repository;

import com.example.springbootfish.model.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, Long> {

    public Fish findAllByLongSize(Long longSize);
    public Fish findByColor(String color);

}
