package com.example.ProductList.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "lists")
@Data
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "product_list",
    joinColumns = @JoinColumn(name = "list_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    public void addProduct(Product product){
        this.products.add(product);
//        product.getLists().add(this);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
//        product.getLists().remove(this);
    }
}
