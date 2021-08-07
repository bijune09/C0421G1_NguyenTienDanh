package model.service;

import model.bean.User;
import model.repository.IUserRepository;
import model.repository.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService{
    private IUserRepository userRepository = new UserRepositoryImpl();
    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void createUser(User user) throws SQLException {
        this.userRepository.createUser(user);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return this.userRepository.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return this.userRepository.deleteUser(id);
    }
}
