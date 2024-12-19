package com.example.ProductList.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
        title = "Product List API",
        description = "API списоков продуктов",
        version = "1.0.0",
        contact = @Contact(
                name = "Kirill Galko",
                email = "kirillg28031983@gmail.com"
        )
    )
)
public class OpenApiConfig {
}
