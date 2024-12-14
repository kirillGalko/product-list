package com.example.ProductList.repositories;

import com.example.ProductList.entity.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<List, Long> {
}
