import algorithm.minDistanceAlgorithm.CourierWithOrders;
import algorithm.minDistanceAlgorithm.MinDistanceAlgorithm;
import entity.Courier;
import entity.Order;
import input.InputHandler;

import java.io.IOException;
import java.util.List;

public class OrderDistributionApp {
    public static void main(String[] args) throws IOException {
        InputHandler inputHandler = new InputHandler();
        List<Order> orders = inputHandler.readOrders();
        List<Courier> couriers = inputHandler.readCouriers();

        MinDistanceAlgorithm minDistanceAlgorithm = new MinDistanceAlgorithm();
        List<CourierWithOrders> courierWithOrders = minDistanceAlgorithm.distributeOrders(orders, couriers);

        for (CourierWithOrders courier : courierWithOrders) {
            courier.printOrdersAndTotalRevenue(orders);
        }
    }
}