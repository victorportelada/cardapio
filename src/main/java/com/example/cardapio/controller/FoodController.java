package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(FoodResponseDTO::new)
                .collect(Collectors.toList());
    }

}
