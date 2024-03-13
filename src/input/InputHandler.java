package input;

import entity.Courier;
import entity.Geo;
import entity.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private final BufferedReader reader;

    public InputHandler() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public List<Order> readOrders() throws IOException {
        int ordersCount = Integer.parseInt(reader.readLine());
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < ordersCount; i++) {
            String s = reader.readLine();
            orders.add(new Order(new Geo(Double.parseDouble(s.split(" ")[0]), Double.parseDouble(s.split(" ")[1])),
                    new Geo(Double.parseDouble(s.split(" ")[2]), Double.parseDouble(s.split(" ")[3])),
                    Double.parseDouble(s.split(" ")[4])));
        }
        return orders;
    }

    public List<Courier> readCouriers() throws IOException {
        int couriersCount = Integer.parseInt(reader.readLine());
        List<Courier> couriers = new ArrayList<>();
        for (int i = 0; i < couriersCount; i++) {
            String s = reader.readLine();
            couriers.add(new Courier(new Geo(Double.parseDouble(s.split(" ")[0]), Double.parseDouble(s.split(" ")[1]))));
        }
        return couriers;
    }
}
