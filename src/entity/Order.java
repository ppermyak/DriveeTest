package entity;

public class Order {
    private final Geo from;
    private final Geo to;
    private final double price;

    public Order(Geo from, Geo to, double price) {
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public Geo getFrom() {
        return from;
    }

    public Geo getTo() {
        return to;
    }

    public double getPrice() {
        return price;
    }
}
