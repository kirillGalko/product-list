package com.example.ProductList.dto;

import com.example.ProductList.entity.Product;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class ListDto {
    private long id;
    private String name;
    private List<ProductDto> products = List.of();
}
