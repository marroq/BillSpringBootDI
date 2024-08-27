package com.dfigueroa.di.BillSpringBootDI.repository;

import com.dfigueroa.di.BillSpringBootDI.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> productsList();

    Product getProduct(String name);

}
