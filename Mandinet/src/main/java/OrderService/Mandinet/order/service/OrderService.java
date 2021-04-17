package OrderService.Mandinet.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OrderService.Mandinet.order.model.Order;
import OrderService.Mandinet.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository order;
	
	public int createOrder(Order ord) {
		ord.setOrderId(ord.getCustomerId()+ord.getProductId());
		order.save(ord);
		return 1;
	}
	
	public int removeOrder(String orderid) {
		order.deleteByorderId(orderid);
		return 1;
	}
	
	public Order getOrderById(String orderid) {
		
		Order ord = order.findByorderId(orderid);
		return ord;
	}
	
	public List<Order> getOrderByProductId(String productid) {
		List<Order> lstOrd = order.findByproductId(productid);
		return lstOrd;
	}
	
	public List<Order> getOrderByCustomerId(String customerid) {
		List<Order> lstOrd = order.findBycustomerId(customerid);
		return lstOrd;
	}
}
