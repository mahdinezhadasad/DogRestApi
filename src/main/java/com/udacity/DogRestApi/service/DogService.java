package com.udacity.DogRestApi.service;

import com.udacity.DogRestApi.entity.Dog;

import java.util.List;

public interface DogService{

    List<Dog> retriveDogs();
    List<String> retriveDogsBreed();

    String retriveBreedById(Long id);

    List<String> retriveAllName();





}