package model.repository;

import model.bean.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository{
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("SELECT id,`name`,email,country\n" +
                            " FROM demo.users;");
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        User findUser = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select id,`name`,email,country\n" +
                            "from users\n" +
                            "where id = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                findUser = new User();
                findUser.setId(id);
                findUser.setName(resultSet.getString("name"));
                findUser.setEmail(resultSet.getString("email"));
                findUser.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return findUser;
    }

    @Override
    public void createUser(User user) throws SQLException {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("insert into users (`name`,email,country)\n" +
                            "values (?,?,?);");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean status = false;
        try{
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("update users\n" +
                            "set `name` = ?, email = ?,country = ?\n" +
                            "where id = ?;");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            preparedStatement.setString(4,user.getId()+"");
            status = preparedStatement.executeUpdate() > 0;
        }  catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean status = false;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("delete from users\n" +
                            "where id = ?;");
            preparedStatement.setString(1,id+"");
            status = preparedStatement.executeUpdate()>0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
}
