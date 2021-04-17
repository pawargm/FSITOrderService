package OrderService.Mandinet.order.repository;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import OrderService.Mandinet.order.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

	
	public Order findByorderId(String orderid);
	public List<Order> findByproductId(String productid);
	public List<Order> findBycustomerId(String customerid);
	public void deleteByorderId(String orderid);
	
}
