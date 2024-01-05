package com.cypherfusion.recipebook.service;

import org.springframework.stereotype.Service;
import com.cypherfusion.recipebook.entity.Food;
import com.cypherfusion.recipebook.repository.FoodRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    FoodRepository repository;

    public FoodService(FoodRepository repository) {
        this.repository = repository;
    }

    public List<Food> get() {
        return this.repository.findAll();
    }

    public Food add(Food food) {
        return this.repository.save(food);
    }

    public Food update(Food food) {
        Optional<Food> foodOptional = this.repository.findById(food.getId());
        if (foodOptional.isEmpty()) {
            throw new RuntimeException();
        }
        Food foodDb = foodOptional.get();
        foodDb.setName(food.getName());
        foodDb.setFoodGroup(food.getFoodGroup());
        return this.repository.save(foodDb);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}