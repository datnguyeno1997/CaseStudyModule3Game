package service;

import dao.DbContext;
import model.ProductType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeServiceMysql extends DbContext implements IProductTypeService {
    private static final String SELECT_ALL_PRODUCTS_TYPES = "SELECT * FROM product_type";
    private static final String FIND_BY_ID = "SELECT * FROM product_type where id = ?";


    @Override
    public List<ProductType> findAll() {
        List<ProductType> products = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS_TYPES);

            System.out.println("FindAll: " + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int idCate = rs.getInt("id");
                String name = rs.getString("name");
                ProductType pt = new ProductType(idCate, name);

                products.add(pt);

            }
        }catch (SQLException exception){
            printSQLException(exception);
        }
        return products;
    }


    @Override
    public ProductType findById(int id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);

            System.out.println("FindById: " + preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int idCate = rs.getInt("id");
                String nameCate = rs.getString("name");

                ProductType pt = new ProductType(idCate, nameCate);
                return pt;
            }
        }catch (SQLException exception){
            printSQLException(exception);
        }
        return null;
    }
}
