package com.nwesseli.c322spring2024lab3.controllers;

import com.nwesseli.c322spring2024lab3.model.AnimalData;
import com.nwesseli.c322spring2024lab3.repository.AnimalRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/animals")
public class AnimalController {
    private AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public boolean add(@RequestBody AnimalData data){
        try{
            return animalRepository.add(data);
        }catch (IOException e){
            return false;
        }

    }

    @GetMapping
    public List<AnimalData> findAll() {
        try{
            return animalRepository.findAll();
        }catch(IOException e){
            return null;
    }
}


    @GetMapping("/search")
    public List<AnimalData> search(@RequestParam String name,
                                   @RequestParam String picture,
                                   @RequestParam String location){
        try{
            System.out.println(name);;
            System.out.println(picture);
            System.out.println(location);
            return animalRepository.find(name, picture, location);
        }catch (IOException e){
            return null;
        }
    }
}
