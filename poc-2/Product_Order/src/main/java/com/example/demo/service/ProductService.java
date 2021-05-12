package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDao;
import com.example.demo.dao.ProductDao;
import com.example.demo.model.Orders;
import com.example.demo.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	//Product=========================
	public Product create(Product product) {
		return productDao.save(product);
	} 
	
	public Iterable<Product> findAllProduct() {
		return productDao.findAll();
	}
	
	public Optional<Product> findProductById(Integer id) { 
		return productDao.findById(id);
	}
	
	public void delete(Integer id) {
		productDao.deleteById(id);
	}
	
	public Product updateProduct(Integer id,String name) {
		Product product = productDao.findById(id).orElse(new Product());
		return productDao.save(product);
	}
	
	//Orders================================
	public Orders create(Orders orders) {
		return orderDao.save(orders);
	}
	
	public Iterable<Orders> findAllOrder() {
		return orderDao.findAll();
	}
	
	public String findOrderById(Integer oid) {
		String res="";
		Optional<Orders> list = orderDao.findById(oid);
		if(list.isPresent()) {
			res="success";
		}
		else {
			res="entered order is not present";
		}
		return list.toString()+" "+res;
	}
	
	public void deleteOrder(Integer oid) {
		orderDao.deleteById(oid);
	}
	

	public Orders updateOrder(Integer oid,Integer quantity) {
		Orders orders = orderDao.findById(oid).orElse(new Orders());
		orders.setQuantity(quantity);
		return orderDao.save(orders);
	}

	public String placeOrder(Integer id, Integer quantity) {
		Orders orders = new Orders();
		orders.setOid(id);
		orders.setQuantity(quantity);
		return orderDao.save(orders)+"";
	}
	
	
}
