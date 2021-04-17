package OrderService.Mandinet.order.model;

import java.util.*;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;

@Document
public class Order {

	@Indexed(name="orderid", unique=true)
	private String orderId; //CustomerID + ProductID
	@NotNull
	private String customerId;
	@NotNull
	private String productId;
	private String deliveryAddress;
	private int orderPlaced;	// 1 means order is delevery succesfully
								// 0 means order is not develveryed yet
								// 2 means order has some issue to delever
	private String estimatedTime;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public int getOrderPlaced() {
		return orderPlaced;
	}
	public void setOrderPlaced(int orderPlaced) {
		this.orderPlaced = orderPlaced;
	}
	public String getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	
		
}
