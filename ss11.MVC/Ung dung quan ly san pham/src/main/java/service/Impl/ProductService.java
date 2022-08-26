package service.Impl;

import modle.Product;
import repository.Impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findBy(int id) {
        return null;
    }

    @Override
    public boolean add(Product product) {
        return productRepository.add(product);
    }
}
