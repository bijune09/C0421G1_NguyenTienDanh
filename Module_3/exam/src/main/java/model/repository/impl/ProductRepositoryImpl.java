package model.repository.impl;

import model.bean.Product;
import model.repository.BaseRepository;
import model.repository.IProductRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Product> selectAll() {
        List<Product> productList = new ArrayList<>();
        Product product = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("SELECT id_product, product_name, product_price, quantity, color, category_id \n" +
                            "FROM exam.product;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product = new Product();
                product.setProductId(resultSet.getInt("id_product"));
                product.setProductName(resultSet.getString("product_name"));
                product.setProductPrice(resultSet.getDouble("product_price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setColor(resultSet.getString("color"));
                product.setCategoryId(resultSet.getInt("category_id"));
                productList.add(product);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("SELECT product_name, product_price, quantity, color, category_id \n" +
                            "FROM exam.product\n" +
                            "where id_product = ?;");
            preparedStatement.setString(1,id+"");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product = new Product();
                product.setProductId(id);
                product.setProductName(resultSet.getString("product_name"));
                product.setProductPrice(resultSet.getDouble("product_price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setColor(resultSet.getString("color"));
                product.setCategoryId(resultSet.getInt("category_id"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void editProduct(Product product) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("update product\n" +
                            "set product_name = ?,product_price = ?,quantity = ?,\n" +
                            "color = ?, category_id = ?\n" +
                            "where id_product = ?;");
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setString(2,product.getProductPrice()+"");
            preparedStatement.setString(3,product.getQuantity()+"");
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getCategoryId()+"");
            preparedStatement.setString(6,product.getProductId()+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeProduct(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("delete from product\n" +
                            "where id_product = ?;");
            preparedStatement.setString(1,id+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void createProduct(Product product) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("insert into product(product_name,product_price,quantity,color,category_id)\n" +
                            "values (?,?,?,?,?);");
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setString(2,product.getProductPrice()+"");
            preparedStatement.setString(3,product.getQuantity()+"");
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getCategoryId()+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
       Product product = null;
       try {
           CallableStatement callableStatement = this.baseRepository.getConnection().
                   prepareCall("CALL find_by_char(?)");
           callableStatement.setString(1,name);
           ResultSet resultSet = callableStatement.executeQuery();
           while (resultSet.next()){
               product = new Product();
               product.setProductId(resultSet.getInt("id_product"));
               product.setProductName(resultSet.getString("product_name"));
               product.setProductPrice(resultSet.getDouble("product_price"));
               product.setQuantity(resultSet.getInt("quantity"));
               product.setColor(resultSet.getString("color"));
               product.setCategoryId(resultSet.getInt("category_id"));
               productList.add(product);
           }
       } catch (SQLException e){
           e.printStackTrace();
       }
        return productList;
    }
}
