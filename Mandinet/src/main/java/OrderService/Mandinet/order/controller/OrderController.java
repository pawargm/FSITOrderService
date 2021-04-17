package OrderService.Mandinet.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import OrderService.Mandinet.order.model.Order;
import OrderService.Mandinet.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderservice;
	
	@RequestMapping(value="/order/create", method=RequestMethod.POST)
	public HttpStatus create(@RequestBody Order order) {
		HttpStatus ret = null;
		
		if(orderservice.createOrder(order) == 1) {
			ret = HttpStatus.OK;
		} else {
			ret = HttpStatus.NOT_FOUND;
		}
		return ret;
	}
	
	@RequestMapping(value="/order/delete", method=RequestMethod.DELETE)
	public HttpStatus remove(@RequestParam String customerId, @RequestParam String productId) {
		
		String orderid = customerId+productId;
		System.out.println(orderid);
		HttpStatus ret = null;
		
		if(orderservice.removeOrder(orderid) == 1) {
			ret = HttpStatus.OK;
		} else {
			ret = HttpStatus.NOT_FOUND;
		}
		return ret;
	}
	
	@RequestMapping(value="/order/getOrderById", method=RequestMethod.GET)
	public Order getOrderById(@RequestParam String orderid) {
		Order lstOrder = orderservice.getOrderById(orderid);
		if( lstOrder == null ) {
			System.out.println("ERROR::getOrderById:Record not found");
			return lstOrder;
		}
		return lstOrder;
	}
	
	@RequestMapping(value="/order/getOrderByProductId", method=RequestMethod.GET)
	public List<Order> getOrderByProductId(@RequestParam String productid) {
		
		List<Order> lstOrder = orderservice.getOrderByProductId(productid);
		if(lstOrder == null) {
			System.out.println("ERROR::getOrderByProductId:Record not found");
			return lstOrder;
		}
		return lstOrder;
	}
	
	@RequestMapping(value="/order/getOrderByCustomerId", method=RequestMethod.GET)
	public List<Order> getOrderByCustomerId(@RequestParam String customerid) {
		
		List<Order> lstOrder = orderservice.getOrderByCustomerId(customerid);
		if(lstOrder == null) {
			System.out.println("ERROR::getOrderByCustomerId: Record not found");
			return lstOrder;
		}
		return lstOrder;
	}
}
