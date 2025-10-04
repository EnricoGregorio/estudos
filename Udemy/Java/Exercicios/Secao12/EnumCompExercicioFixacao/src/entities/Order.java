package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    LocalDateTime moment = LocalDateTime.now();
    OrderStatus status;
    List<OrderItem> items = new ArrayList<>();
    Client client;

    public Order(){}

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        Double sum = 0.0;
        for (OrderItem i : items) {
            sum += i.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Order moment: "
                + getMoment().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                + "\nOrder status: "
                + getStatus()
                + getClient()
                + "\nOrder items:\n"
                + items
                + "\nTotal price: $"
                + String.format("%.2f%n", total());
    }
}
