package com.example.ProductList.dto;

import com.example.ProductList.services.ListService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Schema(description = "Сущность продукта")
public class ProductDto {
    @Schema(description = "Уникальный идентификатор продукта", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private long id;
    @Schema(description = "Наименование продукта", example = "Продукт 1")
    private String name;
    @Schema(description = "Описание продукта", example = "Описание продукта 1")
    private String description;
    @Schema(description = "Количество килокалорий в продукте", example = "1500")
    private int kcal;
}
