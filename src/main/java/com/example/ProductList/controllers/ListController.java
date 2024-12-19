package com.example.ProductList.controllers;

import com.example.ProductList.dto.ListDto;
import com.example.ProductList.services.ListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/list")
@Tag(name = "List Controller", description = "Создание, обновление и удаление списков продуктов")
public class ListController {

    private final ListService listService;

    public ListController(ListService listService){
        this.listService = listService;
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Get list by id", description = "Получение списка продуктов по иденитификатору")
    public ListDto getListById(
            @PathVariable @Parameter(description = "Идентификатор списка", example = "1") Long id){
        return listService.getById(id);
    }

    @GetMapping(path = "/getAll")
    @Operation(summary = "Get all lists", description = "Поулчение всех списков")
    public List<ListDto> getAllLists(){
        return listService.getAll();
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Create new list", description = "Создание нового списка")
    public Map<Boolean, String> createList(
            @RequestBody @Parameter(description = "Экземпляр сущности списка") ListDto listDto){
        listService.create(listDto);
        return Map.of(true, "Список создан");
    }

    @PutMapping(path = "/addProduct/{listId}")
    @Operation(summary = "Add product to list", description = "Добавление продукта в список")
    public Map<Boolean, String> addProduct(
            @PathVariable @Parameter(description = "Идентификатор списка", example = "1") Long listId,
            @RequestParam @Parameter(description = "Идентификатор продкута", example = "1") Long productId){
        listService.addProduct(listId, productId);
        return Map.of(true, "Продукт добавлен");
    }

    @PutMapping(path = "/removeProduct/{listId}")
    @Operation(summary = "Remove product from list", description = "Удаление продукта из списка")
    public Map<Boolean, String> removeProduct(
            @PathVariable @Parameter(description = "Идентификатор списка", example = "1") Long listId,
            @RequestParam @Parameter(description = "Идентификатор продкута", example = "1") Long productId){
        listService.removeProduct(listId, productId);
        return Map.of(true, "Продукт удален");
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Delete list", description = "Удаление списка")
    public Map<Boolean, String> deleteList(
            @PathVariable @Parameter(description = "Идентифткатор списка", example = "1") Long id){
        listService.delete(id);
        return Map.of(true, "Список удален");
    }
}
