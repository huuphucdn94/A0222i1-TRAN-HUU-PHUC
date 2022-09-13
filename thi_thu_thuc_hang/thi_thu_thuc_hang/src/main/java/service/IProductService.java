package service;

import modle.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> findAll();                    // phuong thuc hien thi toan bo san pham
    Map<String,String> add(Product product);    // phuong thuc them san pham moi
    boolean delete(int id);                     // phuong thuc xoa san pham theo id
    boolean edit(Product product);              // phuong thuc chinh sua soan pham
}
