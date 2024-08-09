package com.dfigueroa.di.BillSpringBootDI.model;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Invoice {

    @Autowired
    private Client client;

    @Value("${config.invoice.description}")
    private String description;

    @Autowired
    private List<Item> items;

    @PostConstruct
    private void init() {
        client.setName(client.getName().concat(" EDITED"));
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public double getTotal() {
        return items.stream()
                .map(item -> item.getTotalProducts())
                .reduce(0.0, (sum, totalProducts) -> sum + totalProducts);
    }
}
