package com.ibm.demo;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.demo.service.OrderService;
import com.ibm.demo.entity.Order;


@RestController

public class OrderController {//frontend
	@Autowired
	OrderService orderservice;//DI
	@PostMapping("/order")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createOrder(@RequestBody @Valid Order order,BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(order);
		return orderservice.createOrder(order);
	}

	private void validateModel(Errors bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			throw new IllegalArgumentException("Something went wrong");
			
		}
		
	}
	

	@PutMapping("/order/{id}")
	void Updateorder(@RequestBody @Valid Order order,BindingResult bindingResult,@PathVariable("id") String orderId) {
		validateModel(bindingResult);
		System.out.println(orderId);
		order.setId(orderId);
		orderservice.updateOrder(order);
	}

	@DeleteMapping("/order/{id}")
	void DeleteOrder(@PathVariable("id") String orderId) {
		System.out.println(orderId);
		orderservice.deleteOrder(orderId);
		

	}

}
