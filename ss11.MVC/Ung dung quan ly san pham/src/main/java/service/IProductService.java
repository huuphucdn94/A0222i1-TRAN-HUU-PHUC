package service;

import modle.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findBy(int id);
    boolean add(Product product);
}
