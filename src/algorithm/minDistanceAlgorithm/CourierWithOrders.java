package algorithm.minDistanceAlgorithm;

import entity.Geo;
import entity.Order;

import java.util.List;

public class CourierWithOrders {
    private Geo geo;
    private int nearestOrderIndex;
    private double distanceToNearestOrder;
    private double completedDistance;
    private List<Integer> orderNumbers;

    public CourierWithOrders(Geo geo, List<Integer> orderNumbers) {
        this.geo = geo;
        this.orderNumbers = orderNumbers;
    }

    public void printOrders() {
        System.out.println(orderNumbers);
    }

    public void printOrdersAndTotalRevenue(List<Order> orders) {
        double totalRevenue = 0;
        for (Integer orderNumber : orderNumbers) {
            totalRevenue += orders.get(orderNumber).getPrice();
        }
        System.out.print(orderNumbers);
        System.out.println(" - " + totalRevenue);
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public int getNearestOrderIndex() {
        return nearestOrderIndex;
    }

    public void setNearestOrderIndex(int nearestOrderIndex) {
        this.nearestOrderIndex = nearestOrderIndex;
    }

    public double getDistanceToNearestOrder() {
        return distanceToNearestOrder;
    }

    public void setDistanceToNearestOrder(double distanceToNearestOrder) {
        this.distanceToNearestOrder = distanceToNearestOrder;
    }

    public double getCompletedDistance() {
        return completedDistance;
    }

    public void setCompletedDistance(double completedDistance) {
        this.completedDistance = completedDistance;
    }

    public List<Integer> getOrderNumbers() {
        return orderNumbers;
    }

    public void setOrderNumbers(List<Integer> orderNumbers) {
        this.orderNumbers = orderNumbers;
    }
}
