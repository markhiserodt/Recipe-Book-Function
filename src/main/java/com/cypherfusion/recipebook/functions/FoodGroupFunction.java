package com.cypherfusion.recipebook.functions;

import com.cypherfusion.recipebook.entity.FoodGroup;
import com.cypherfusion.recipebook.service.FoodGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class FoodGroupFunction {

    private static final Logger LOG = LoggerFactory.getLogger(FoodGroupFunction.class);
    private final FoodGroupService foodGroupService;

    public FoodGroupFunction(FoodGroupService foodGroupService) {
        this.foodGroupService = foodGroupService;
    }

    @Bean
    public Supplier<List<FoodGroup>> get() {
        LOG.info("get() FoodGroups called");
        return foodGroupService::get;
    }

    @Bean
    public Consumer<FoodGroup> add() {
        LOG.info("add() FoodGroups called");
        return foodGroupService::add;
    }

}
