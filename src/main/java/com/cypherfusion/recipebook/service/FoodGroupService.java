package com.cypherfusion.recipebook.service;

import org.springframework.stereotype.Service;
import com.cypherfusion.recipebook.entity.FoodGroup;
import com.cypherfusion.recipebook.repository.FoodGroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodGroupService {
    FoodGroupRepository repository;

    public FoodGroupService(FoodGroupRepository repository) {
        this.repository = repository;
    }

    public List<FoodGroup> get() {
        return this.repository.findAll();
    }

    public FoodGroup add(FoodGroup foodGroup) {
        return this.repository.save(foodGroup);
    }

    public FoodGroup update(FoodGroup foodGroup) {
        Optional<FoodGroup> foodGroupOptional = this.repository.findById(foodGroup.getId());
        if (foodGroupOptional.isEmpty()) {
            throw new RuntimeException();
        }
        FoodGroup foodGroupDb = foodGroupOptional.get();
        foodGroupDb.setName(foodGroup.getName());
        return this.repository.save(foodGroupDb);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
