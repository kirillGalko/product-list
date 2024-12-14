package com.example.ProductList.controllers;

import com.example.ProductList.dto.ProductDto;
import com.example.ProductList.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping(path = "/get/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping(path = "/getAll")
    public List<ProductDto> getAllProducts(){
        return service.getAll();
    }

    @PostMapping(path = "/create")
    public Map<Boolean, String> createProduct(@RequestBody ProductDto productDto){
        service.create(productDto);
        return Map.of(true, "Продукт сохранен");
    }

    @DeleteMapping(path = "/delete/{id}")
    public Map<Boolean, String> deleteProduct (@PathVariable Long id){
        service.delete(id);
        return Map.of(true, "Продукт удален");
    }
}
