package com.asodc.camel;

public class Order {
    private int id;
    private int amount;

    // implicit no-arg constructor

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
