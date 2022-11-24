package com.javapractice.demo.controller;


import com.javapractice.demo.dao.AnimalsRepository;
import com.javapractice.demo.entities.Animals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/animals")
@RestController
public class AnimalsRestController {
    private final AnimalsRepository animalsRepository;
    @Autowired
    public  AnimalsRestController(AnimalsRepository animalsRepository){
        this.animalsRepository = animalsRepository;
    }
    @GetMapping("/{id}")
    public Animals getById(@PathVariable("id") UUID id) {
        return animalsRepository.findById(id).get();
    }
    @PostMapping
    public Animals create(@RequestBody Animals animals) {
        UUID id = animals.getId();
        if(id !=null){
            if (animalsRepository.existsById(animals.getId())){
                throw new EntityExistsException("User alredy exists");
            }
        }
        return animalsRepository.save(animals);
    }
    @GetMapping
    public List<Animals> getAll() {
        return animalsRepository.findAll();
    }
    @PutMapping
    public Animals update(@RequestBody Animals animals) {
        UUID id = animals.getId();
        return animalsRepository.save(animals);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id) {
        animalsRepository.deleteById(id);
    }
}




