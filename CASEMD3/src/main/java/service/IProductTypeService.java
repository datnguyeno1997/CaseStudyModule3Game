package service;

import model.Product;
import model.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();
    ProductType findById(int id);
}
