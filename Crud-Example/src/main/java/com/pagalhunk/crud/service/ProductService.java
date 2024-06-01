package com.pagalhunk.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagalhunk.crud.entity.Product;
import com.pagalhunk.crud.repository.ProductRepository;

@Service
public class ProductService {
	//the service class has a product repo  interface
	//inject it
	
	@Autowired
	private ProductRepository repository;
	
	//post methods 
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
		}
	
	public Product getProductById(int id) {
		//return null if not present
		return repository.findById(id).orElse(null);
	}
	public Product getProductByName(String name) {
		//return null if not present
		return repository.findByName(name).orElse(null);
	}
	
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product removed:  "+id;
	}
	public Product updateProduct(Product product) {
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
	

}
