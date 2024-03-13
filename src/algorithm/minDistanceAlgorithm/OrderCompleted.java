package algorithm.minDistanceAlgorithm;

import entity.Order;

public class OrderCompleted {
    private final Order order;
    private boolean isCompleted;

    public OrderCompleted(Order order, boolean isCompleted) {
        this.order = order;
        this.isCompleted = isCompleted;
    }

    public Order getOrder() {
        return order;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
