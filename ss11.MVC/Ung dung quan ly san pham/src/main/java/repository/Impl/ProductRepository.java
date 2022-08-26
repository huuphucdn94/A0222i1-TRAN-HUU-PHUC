package repository.Impl;

import modle.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1, "Honda","honda@gmail.com","Nhat Ban"));
        productList.add(new Product(2, "Yamaha","yamaha@gmail.com","Nhat Ban"));
        productList.add(new Product(3, "Toyota","toyota@gmail.com","Nhat Ban"));
        productList.add(new Product(4, "Mazdaz","mazdaz@gmail.com","Han Quoc"));
        productList.add(new Product(5, "Mercedes","mercedes@gmail.com","USA"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findBy(int id) {
        return null;
    }

    @Override
    public boolean add(Product product) {
        return productList.add(product);
    }
}
