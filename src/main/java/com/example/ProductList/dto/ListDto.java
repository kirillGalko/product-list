package com.example.ProductList.dto;

import com.example.ProductList.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Schema(description = "Сущность списка")
public class ListDto {
    @Schema(description = "Уникальный идентификатор списка", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private long id;
    @Schema(description = "Имя списка", example = "Список 1")
    private String name;
    @Schema(description = "Список продуктов, входящих в список", accessMode = Schema.AccessMode.READ_ONLY)
    private List<ProductDto> products = List.of();
}
