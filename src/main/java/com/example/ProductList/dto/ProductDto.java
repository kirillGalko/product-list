package com.example.ProductList.dto;

import com.example.ProductList.services.ListService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private int kcal;
}
