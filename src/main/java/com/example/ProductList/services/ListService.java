package com.example.ProductList.services;

import com.example.ProductList.dto.ListDto;
import com.example.ProductList.entity.List;
import com.example.ProductList.entity.Product;
import com.example.ProductList.repositories.ListRepository;
import com.example.ProductList.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ListService {

    private final ListRepository listRepository;

    private final ProductRepository productRepository;

    public ListDto getById(Long id){
        log.info("get by id: " + id);
        List list = listRepository.findById(id).orElseThrow();
        return mapToDto(list);
    }

    public java.util.List<ListDto> getAll(){
        log.info("get all");
        return listRepository.findAll()
                .stream()
                .map((ListService::mapToDto))
                .toList();
    }

    public void create(ListDto listDto){
        log.info("create new list");
        List list = mapToEntity(listDto);
        listRepository.save(list);
    }

    public void addProduct(Long listId, Long productId){
        log.info("add product " + productId + " to list " + listId);
        List list = listRepository.findById(listId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        list.addProduct(product);
        listRepository.save(list);
    }

    public void removeProduct(Long listId, Long productId){
        log.info("remove product " + productId + " from list " + listId);
        List list = listRepository.findById(listId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        list.removeProduct(product);
        listRepository.save(list);
    }

    public void delete(Long id){
        log.info("delete item: " + id);
        listRepository.deleteById(id);
    }

    public static ListDto mapToDto(List list){
        ListDto listDto = new ListDto();
        listDto.setId(list.getId());
        listDto.setName(list.getName());
        listDto.setProducts(list.getProducts().stream()
                .map(ProductService::mapToDto)
                .toList());
        return listDto;
    }

    public static List mapToEntity(ListDto listDto){
        List list = new List();
        list.setName(listDto.getName());
        list.setProducts(listDto.getProducts().stream()
                .map(ProductService::mapToEntity)
                .collect(Collectors.toSet()));
        return list;
    }
}
