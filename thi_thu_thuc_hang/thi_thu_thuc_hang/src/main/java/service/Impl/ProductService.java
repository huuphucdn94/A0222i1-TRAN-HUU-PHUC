package service.Impl;

import modle.Product;
import repository.IProductRepository;
import repository.Impl.ProductRepository;
import service.IProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Map<String,String> add(Product product) {
        Map<String,String> map = new HashMap<>();
            productRepository.add(product);
        return map;
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean edit(Product product) {
        return false;
    }
}
