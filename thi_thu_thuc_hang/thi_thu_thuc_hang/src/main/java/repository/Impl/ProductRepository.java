package repository.Impl;

import modle.Product;
import repository.BaseRepository;
import repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String SELECT_ALL="select * from product;";
    private final String DELETE_BY_ID=" delete from product where id_product =?;";
    private final String ADD_NEW ="insert into product (`name`,price,quantity,color,`describe`,id_category) values (?,?,?,?,?,?);";
    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String describe = resultSet.getString(6);
                int categoryId = resultSet.getInt(7);
                Product product = new Product(id,name,price,quantity,color,describe,categoryId);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public void add(Product product) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescribe());
            preparedStatement.setInt(6,product.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public boolean delete(int id) {
        boolean deleteRow = false;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            deleteRow = preparedStatement.executeUpdate()>0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return deleteRow;
    }

    @Override
    public boolean edit(Product product) {

        return false;
    }
}
