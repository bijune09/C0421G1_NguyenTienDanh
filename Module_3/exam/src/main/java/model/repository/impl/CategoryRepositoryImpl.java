package model.repository.impl;

import model.bean.Category;
import model.repository.BaseRepository;
import model.repository.ICategoryRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements ICategoryRepository {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Category> selectAll() {
        List<Category> categoryList = new ArrayList<>();
        Category category = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("SELECT category_id, category_name\n" +
                            " FROM exam.category_product;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                category = new Category();
                category.setCategoryId(resultSet.getInt("category_id"));
                category.setCategoryName(resultSet.getString("category_name"));
                categoryList.add(category);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return categoryList;
    }
}
