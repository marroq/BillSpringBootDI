package com.dfigueroa.di.BillSpringBootDI.model;

import java.util.List;

public class Invoice {

    private Client client;
    private List<Item> items;
    private String description;

    public Invoice(Client client, String description, List<Item> items) {
        this.client = client;
        this.description = description;
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Client getClient(){ return this.client; }

}
