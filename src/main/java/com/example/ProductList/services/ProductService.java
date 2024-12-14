package com.example.ProductList.services;

import com.example.ProductList.dto.ProductDto;
import com.example.ProductList.entity.Product;
import com.example.ProductList.repositories.ListRepository;
import com.example.ProductList.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    private final ListRepository listRepository;

    public ProductDto getById(Long id){
        log.info("get by id " + id);
        Product product = productRepository.findById(id).orElseThrow();
        return mapToDto(product);
    }

    public List<ProductDto> getAll(){
        log.info("get all");
        return productRepository.findAll()
                .stream()
                .map(ProductService::mapToDto)
                .toList();
    }

    public void create(ProductDto productDto){
        log.info("create");
        Product product = mapToEntity(productDto);
        productRepository.save(product);
    }

    public void delete(Long id){
        log.info("delete");
        Product product = productRepository.findById(id).orElseThrow();
        List<com.example.ProductList.entity.List> productLists = product.getLists();
        for(com.example.ProductList.entity.List list : productLists){
            list.removeProduct(product);
            listRepository.save(list);
        }
        productRepository.deleteById(id);
    }

    public static ProductDto mapToDto(Product product){
        ProductDto productDto =  new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setKcal(product.getKcal());
        return productDto;
    }

    public static Product mapToEntity(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setKcal(productDto.getKcal());
        return product;
    }
}
