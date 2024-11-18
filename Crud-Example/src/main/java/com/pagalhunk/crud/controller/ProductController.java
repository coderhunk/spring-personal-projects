package com.pagalhunk.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pagalhunk.crud.entity.Product;
import com.pagalhunk.crud.service.ProductService;

@RestController
public class ProductController {
	// this controller class will talk to service class
	// it has a product service
	@Autowired
	private ProductService service;
	
	// post method 
	//@RequestBody anotation to tell this to accept jason request
	//regeg
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		 
		return service.saveProduct(product);
	}
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		 
		return service.saveProducts(products);
	}
	@GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
    	// can also use @requestPrameter here 
    	// but using oath variable insures that the parameter has been passe dor else 404
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
	

}
