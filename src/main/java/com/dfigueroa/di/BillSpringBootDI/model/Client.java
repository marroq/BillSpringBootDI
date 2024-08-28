package com.dfigueroa.di.BillSpringBootDI.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Client {

    @Value("${config.client.name}")
    private String name;
    @Value("${config.client.lastName}")
    private String lastName;

    public Client() {}

    public Client(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
