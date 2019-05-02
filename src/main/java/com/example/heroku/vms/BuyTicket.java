package com.example.heroku.vms;

public class BuyTicket{
    private long customerId;
    private long type;
    private long quantity;


    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BuyTicket{" +
                "customerId=" + customerId +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
