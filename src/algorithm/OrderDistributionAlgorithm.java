package algorithm;

import algorithm.minDistanceAlgorithm.CourierWithOrders;
import entity.Courier;
import entity.Order;

import java.util.List;

public interface OrderDistributionAlgorithm {
    List<CourierWithOrders> distributeOrders(List<Order> orders, List<Courier> couriers);
}
