package com.javapractice.demo.controller;


import com.javapractice.demo.dao.AnimalsRepository;
import com.javapractice.demo.entities.Animals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/Animals")
@RestController
public class AnimalsRestController {
    private final AnimalsRepository AnimalsRepository;
    @Autowired
    public  AnimalsRestController(AnimalsRepository AnimalsRepository){
        this.AnimalsRepository = AnimalsRepository;
    }
    @GetMapping("/{id}")
    public Animals getById(@PathVariable("id") UUID id) {
        return AnimalsRepository.findById(id).get();
    }
    @PostMapping
    public Animals create(@RequestBody Animals Animals) {
        UUID id = Animals.getId();
        if(id !=null){
            if (AnimalsRepository.existsById(Animals.getId())){
                throw new EntityExistsException("User alredy exists");
            }
        }
        return AnimalsRepository.save(Animals);
    }
    @GetMapping
    public List<Animals> getAll() {
        return AnimalsRepository.findAll();
    }
    @PutMapping
    public Animals update(@RequestBody Animals Animals) {
        UUID id = Animals.getId();
        return AnimalsRepository.save(Animals);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") UUID id) {
        AnimalsRepository.deleteById(id);
    }
}




