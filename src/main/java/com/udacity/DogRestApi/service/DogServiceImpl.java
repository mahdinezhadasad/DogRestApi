package com.udacity.DogRestApi.service;

import com.udacity.DogRestApi.entity.Dog;
import com.udacity.DogRestApi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DogServiceImpl implements DogService{

    @Autowired
    DogRepository dogRepository;

    @Override
    public List<Dog> retriveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retriveDogsBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }

    @Override
    public String retriveBreedById(Long id) {
       // Optional<String> optionalbreed = Optional.ofNullable(dogRepository.findBreedById(id));
       // String breed = optionalbreed.orElseThrow(DogNotFoundException::new);

        String breed = dogRepository.findBreedById(id);
        return breed;
    }


    @Override
    public List<String> retriveAllName() {
        return (List<String>) dogRepository.findAllName();
    }
}