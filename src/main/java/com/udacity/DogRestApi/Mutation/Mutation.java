package com.udacity.DogRestApi.Mutation;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.DogRestApi.entity.Dog;
import com.udacity.DogRestApi.repository.DogRepository;
import com.udacity.DogRestApi.service.BreedNotFoundException;
import com.udacity.DogRestApi.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog updateDogName(String name, Long id ){

       Optional<Dog> optionalDog= dogRepository.findById(id);

       if(optionalDog.isPresent()){

           Dog dog = optionalDog.get();

           dog.setName(name);
           dogRepository.save(dog);

           return dog;



       }

       else{

           throw new DogNotFoundException("Dog not found",id);

       }




    }

    public boolean deleteDogBreed(String breed){

        boolean deleted = false;

        Iterable<Dog> allDogs = dogRepository.findAll();

        for(Dog d:allDogs){

            if(d.getBreed().equals(breed)){


               dogRepository.delete(d);

               deleted = true;

            }
        }

        if(!deleted){

            throw  new BreedNotFoundException("Breed Not Found", breed);


        }


        return deleted;



    }


}
