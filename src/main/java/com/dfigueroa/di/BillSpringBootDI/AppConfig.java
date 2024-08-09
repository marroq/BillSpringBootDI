package com.dfigueroa.di.BillSpringBootDI;

import com.dfigueroa.di.BillSpringBootDI.model.Item;
import com.dfigueroa.di.BillSpringBootDI.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice() {
        Product product1 = new Product("Camera", 550.75);
        Product product2 = new Product("Laptop", 850);

        Item item1 = new Item(product1, 3);
        Item item2 = new Item(product2, 1);

        return Arrays.asList(item1, item2);
    }
}
