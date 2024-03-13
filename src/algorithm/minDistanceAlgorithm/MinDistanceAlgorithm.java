package algorithm.minDistanceAlgorithm;

import algorithm.OrderDistributionAlgorithm;
import entity.*;

import java.util.ArrayList;
import java.util.List;

public class MinDistanceAlgorithm implements OrderDistributionAlgorithm {

    @Override
    public List<CourierWithOrders> distributeOrders(List<Order> orders, List<Courier> couriers) {
        List<OrderCompleted> ordersCompleted = new ArrayList<>();
        for (Order order : orders)
            ordersCompleted.add(new OrderCompleted(order, false));
        List<CourierWithOrders> courierWithOrders = new ArrayList<>();
        for (Courier courier : couriers)
            courierWithOrders.add(new CourierWithOrders(courier.getGeo(), new ArrayList<>()));

        int distributedOrdersCount = 0;
        while (distributedOrdersCount < ordersCompleted.size()) {
            double minDistanceToOrder = Double.MAX_VALUE;
            int courierIndex = -1;
            CourierWithOrders courierWithMinDistance = new CourierWithOrders(null, null);
            for (int i = 0; i < courierWithOrders.size(); i++) {
                findNearestOrder(courierWithOrders.get(i), ordersCompleted);
                if (courierWithOrders.get(i).getDistanceToNearestOrder() + courierWithOrders.get(i).getCompletedDistance() < minDistanceToOrder) {
                    minDistanceToOrder = courierWithOrders.get(i).getDistanceToNearestOrder() + courierWithOrders.get(i).getCompletedDistance();
                    courierWithMinDistance = courierWithOrders.get(i);
                    courierIndex = i;
                }
            }
            courierWithOrders.get(courierIndex).setCompletedDistance(courierWithMinDistance.getCompletedDistance() + minDistanceToOrder +
                    calcDistance(orders.get(courierWithMinDistance.getNearestOrderIndex()).getFrom(), orders.get(courierWithMinDistance.getNearestOrderIndex()).getTo() ));
            courierWithOrders.get(courierIndex).setGeo(ordersCompleted.get(courierWithMinDistance.getNearestOrderIndex()).getOrder().getTo());
            ordersCompleted.get(courierWithMinDistance.getNearestOrderIndex()).setCompleted(true);
            List<Integer> orderNumbers = courierWithOrders.get(courierIndex).getOrderNumbers();
            orderNumbers.add(courierWithMinDistance.getNearestOrderIndex());
            courierWithOrders.get(courierIndex).setOrderNumbers(orderNumbers);
            distributedOrdersCount++;
        }
        return courierWithOrders;
    }

    private void findNearestOrder(CourierWithOrders courier, List<OrderCompleted> order) {
        double min = Double.MAX_VALUE;
        int minOrderIndex = -1;
        for (int i = 0; i < order.size(); i++) {
            if (!order.get(i).isCompleted()) {
                double distance = courier.getCompletedDistance() + calcDistance(courier.getGeo(), order.get(i).getOrder().getFrom());
                if (distance < min) {
                    min = distance;
                    minOrderIndex = i;
                }
            }
        }
        courier.setNearestOrderIndex(minOrderIndex);
        courier.setDistanceToNearestOrder(min);
    }

    private double calcDistance(Geo from, Geo to) {
        return 111.134861111 * (180/Math.PI) * Math.acos(
                Math.sin(from.getLatitude() * (Math.PI/180)) * Math.sin(to.getLatitude() * (Math.PI/180)) +
                        Math.cos(from.getLatitude() * (Math.PI/180)) * Math.cos(to.getLatitude() * (Math.PI/180)) *
                                Math.cos( (from.getLongitude() - to.getLongitude()) * (Math.PI/180))
        );
    }
}
