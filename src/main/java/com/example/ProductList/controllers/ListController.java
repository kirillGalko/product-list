package com.example.ProductList.controllers;

import com.example.ProductList.dto.ListDto;
import com.example.ProductList.services.ListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/list")
public class ListController {

    private final ListService listService;

    public ListController(ListService listService){
        this.listService = listService;
    }

    @GetMapping(path = "/get/{id}")
    public ListDto getListById(@PathVariable Long id){
        return listService.getById(id);
    }

    @GetMapping(path = "/getAll")
    public List<ListDto> getAllLists(){
        return listService.getAll();
    }

    @PostMapping(path = "/create")
    public Map<Boolean, String> createList(@RequestBody ListDto listDto){
        listService.create(listDto);
        return Map.of(true, "Список создан");
    }

    @PutMapping(path = "/addProduct/{listId}")
    public Map<Boolean, String> addProduct(@PathVariable Long listId, @RequestParam Long productId){
        listService.addProduct(listId, productId);
        return Map.of(true, "Продукт добавлен");
    }

    @PutMapping(path = "/removeProduct/{listId}")
    public Map<Boolean, String> removeProduct(@PathVariable Long listId, @RequestParam Long productId){
        listService.removeProduct(listId, productId);
        return Map.of(true, "Продукт удален");
    }

    @DeleteMapping(path = "/delete/{id}")
    public Map<Boolean, String> deleteList(@PathVariable Long id){
        listService.delete(id);
        return Map.of(true, "Список удален");
    }
}
