package com.ibm.searchorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderSearchController {
	@Autowired // is used for DI
	OrderService orderService; // DI
	
	@GetMapping("/order")
	List<Order> getOrders(){
		return orderService.getOrders();
	}
}