package com.dfigueroa.di.BillSpringBootDI.repository;

import com.dfigueroa.di.BillSpringBootDI.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    List<Product> products;

    @Override
    public List<Product> productsList() {
        products = (Arrays.asList(
                new Product("TV", 26.51),
                new Product("Computer",57.26),
                new Product("Desk", 80.0),
                new Product("Backpack", 236.5)
        ));

        return  products;
    }

    @Override
    public Product getProduct(String name) {
        return products.stream().filter(product -> product.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Product getProduct(int index) {
        return products.get(index);
    }
}
