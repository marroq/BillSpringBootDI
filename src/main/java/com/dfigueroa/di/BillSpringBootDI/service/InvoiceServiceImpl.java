package com.dfigueroa.di.BillSpringBootDI.service;

import com.dfigueroa.di.BillSpringBootDI.model.Invoice;
import com.dfigueroa.di.BillSpringBootDI.model.Item;
import com.dfigueroa.di.BillSpringBootDI.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductRepository products;

    @Value("${config.invoice.description}")
    private String description;

    @Override
    public List<Invoice> getInvoices() {
        return getAllInvoices();
    }

    @Override
    public Invoice getInvoiceByName(String name) {
        return getAllInvoices().stream().filter(invoice -> invoice.getClient().getName().equals(name)).findFirst().orElse(null);
    }

    @PostConstruct
    private void init() {
        System.out.println("Showing client values after created instance");
        System.out.println(clientService.getAllClients().stream().map(client ->
                client.getName().concat(client.getLastName()))
        );
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Executing when destroying instance of Invoice bean");
    }

    private List<Invoice> getAllInvoices() {
        return clientService.getAllClients()
                .stream().map(client -> new Invoice(client, description, createItem()))
                .collect(Collectors.toList());
    }

    private List<Item> createItem() {
        int randomElement = randomElement();
        int quantity = randomElement + 1;

        return Collections.singletonList(new Item(products.getProduct(randomElement), quantity));
    }

    private int getTotalElements() {
        return products.productsList().size();
    }

    private int randomElement() {
        Random random = new Random();
        return random.nextInt(getTotalElements());
    }
}
