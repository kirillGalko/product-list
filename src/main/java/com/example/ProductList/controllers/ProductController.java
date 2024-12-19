package com.example.ProductList.controllers;

import com.example.ProductList.dto.ProductDto;
import com.example.ProductList.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/product")
@Tag(name = "Product controller", description = "Создание, обновление и удаление продуктов")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping(path = "/get/{id}")
    @Operation(summary = "Get product by id", description = "Получение продукта по идентификатору")
    public ProductDto getProductById(
            @PathVariable @Parameter(description = "Идентификатор продукта", example = "1") Long id){
        return service.getById(id);
    }

    @GetMapping(path = "/getAll")
    @Operation(summary = "Get all products", description = "Получение всех продуктов")
    public List<ProductDto> getAllProducts(){
        return service.getAll();
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Create new product", description = "Создание нового продукта")
    public Map<Boolean, String> createProduct(
            @RequestBody @Parameter(description = "Экземпляр сущности продукта") ProductDto productDto){
        service.create(productDto);
        return Map.of(true, "Продукт сохранен");
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Delete product", description = "Удаление продукта")
    public Map<Boolean, String> deleteProduct (
            @PathVariable @Parameter(description = "Идентификатор продукта", example = "1") Long id){
        service.delete(id);
        return Map.of(true, "Продукт удален");
    }
}
