package com.dfigueroa.di.BillSpringBootDI.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
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
        System.out.println("Showing client values after created instance");
        System.out.println(client.getName().concat(" ").concat(client.getLastName()));
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Executing when destroying instance of Invoice bean");
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
