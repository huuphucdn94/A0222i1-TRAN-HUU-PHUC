package repository;

import modle.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findBy(int id);
    boolean add(Product product);
}
