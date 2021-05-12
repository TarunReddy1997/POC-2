package com.example.demo.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Orders;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//=================product=====================
	@PostMapping("/create")
	public Product create(@RequestBody Product product) {
		return productService.create(product);
	}

	@GetMapping("/getAllProducts") 
	Iterable<Product> getAllProducts() {
		return productService.findAllProduct();
	}

	@GetMapping("/findProductById/{id}")
	public Optional<Product> getProductById(@PathVariable("id") Integer id) {
		return productService.findProductById(id);
	}

	@DeleteMapping("/deleteProducts") 
	public void deleteProduct(@PathVariable("id") Integer  id) {
		productService.delete(id);
	}

	@PutMapping("/updateProduct/{id}/{name}")
	public Product updateProduct(@PathVariable("id") Integer id,@PathVariable("name") String name) {
		return productService.updateProduct(id, name);
	}
	
	//======================Orders===============================
	@PostMapping("/createOrder")
	public Orders create(@RequestBody Orders orders) {
		return productService.create(orders);
	}
	
	@GetMapping("/getAllOrders")
	Iterable<Orders> getAllOrders() {
		return productService.findAllOrder();
	}
	
	@GetMapping("/getOrderById/{oid}")
	public String orderById(@PathVariable("oid") Integer oid) {
		return productService.findOrderById(oid);
	}
	
	@DeleteMapping("/deleteOrder")
	public void deleteOrder(@PathVariable("oid") Integer oid) {
		productService.deleteOrder(oid);
	}
	
	@PutMapping("/updateOrder/oid={noid}/quantity={nquantity}")
	public Orders updateOrder(@PathVariable("noid") Integer oid,@PathVariable("nquantity") Integer quantity) {
		return productService.updateOrder(oid, quantity);
	}
	
	@PutMapping("/placeOrders")
	public String placeOrders(@RequestParam("id") Integer id,@RequestParam("quantity") Integer quantity) {
		return productService.placeOrder(id,quantity);
	}
}
