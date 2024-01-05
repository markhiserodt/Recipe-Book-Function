package com.cypherfusion.recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cypherfusion.recipebook.entity.FoodGroup;

@Repository
public interface FoodGroupRepository extends JpaRepository<FoodGroup, Long> {
}
