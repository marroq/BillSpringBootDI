package com.dfigueroa.di.BillSpringBootDI.repository;

import com.dfigueroa.di.BillSpringBootDI.model.Product;

import java.util.List;

public interface ProductRepository {

    public List<Product> productsList();

    public Product getProduct(String name);

    public Product getProduct(int index);

}
