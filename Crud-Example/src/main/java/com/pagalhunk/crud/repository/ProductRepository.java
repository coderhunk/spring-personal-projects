package com.pagalhunk.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagalhunk.crud.entity.Product;

// the second argument for the jpsarespository class bis the primary key of my entity class
public interface ProductRepository extends JpaRepository<Product,Integer> {

	Optional<Product> findByName(String name);

}
