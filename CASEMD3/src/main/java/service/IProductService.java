package service;


import model.Pageable;
import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(long id);
    void update(long id, Product product);
    void remove(long id);

    List<Product> findProducts(Pageable pageable);
    List<Product> findAction();
    List<Product> findLogic();
    List<Product> findRacing();
}
