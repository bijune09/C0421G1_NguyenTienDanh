package model.repository.customer;

import model.bean.customer.Customer;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepoImpl implements ICustomerRepo {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Customer> selectAll() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer =null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select *" +
                            "from khach_hang");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customer = new Customer();
                customer.setIdCustomer(resultSet.getInt("id_khach_hang"));
                customer.setCustomerCode(resultSet.getString("ma_khach_hang"));
                customer.setTypeCustomer(resultSet.getInt("id_loai_khach"));
                customer.setCustomerName(resultSet.getString("ho_ten"));
                customer.setCustomerBirthday(resultSet.getString("ngay_sinh"));
                customer.setGender(resultSet.getBoolean("gioi_tinh"));
                customer.setCustomerIdCard(resultSet.getString("so_CMTND"));
                customer.setCustomerPhone(resultSet.getString("sdt"));
                customer.setCustomerEmail(resultSet.getString("email"));
                customer.setCustomerAddress(resultSet.getString("dia_chi"));
                customerList.add(customer);
            }
        } catch (SQLException e ){
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select ma_khach_hang,id_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_CMTND,sdt,email,dia_chi\n" +
                            "from khach_hang\n" +
                            "where id_khach_hang = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                customer = new Customer();
                customer.setIdCustomer(id);
                customer.setCustomerCode(resultSet.getString("ma_khach_hang"));
                customer.setTypeCustomer(resultSet.getInt("id_loai_khach"));
                customer.setCustomerName(resultSet.getString("ho_ten"));
                customer.setCustomerBirthday(resultSet.getString("ngay_sinh"));
                customer.setGender(resultSet.getBoolean("gioi_tinh"));
                customer.setCustomerIdCard(resultSet.getString("so_CMTND"));
                customer.setCustomerPhone(resultSet.getString("sdt"));
                customer.setCustomerEmail(resultSet.getString("email"));
                customer.setCustomerAddress(resultSet.getString("dia_chi"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void editCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("update khach_hang\n" +
                            "set id_loai_khach = ?,ho_ten =?, ngay_sinh =?, gioi_tinh=?,so_CMTND=?,sdt=?,\n" +
                            "email=?, ma_khach_hang =?,dia_chi=?\n" +
                            "where id_khach_hang = ? ");
            preparedStatement.setInt(1,customer.getTypeCustomer());
            preparedStatement.setString(2,customer.getCustomerName()+"");
            preparedStatement.setString(3,customer.getCustomerBirthday()+"");
            preparedStatement.setBoolean(4,customer.isGender());
            preparedStatement.setString(5,customer.getCustomerIdCard()+"");
            preparedStatement.setString(6,customer.getCustomerPhone()+"");
            preparedStatement.setString(7,customer.getCustomerEmail()+"");
            preparedStatement.setString(8,customer.getCustomerCode()+"");
            preparedStatement.setString(9,customer.getCustomerAddress()+"");
            preparedStatement.setInt(10,customer.getIdCustomer());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("delete from khach_hang\n" +
                            "where id_khach_hang = ? ");
            preparedStatement.setString(1,id+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void createCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("insert into khach_hang (id_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_CMTND," +
                            "sdt,email,dia_chi,ma_khach_hang) values (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,customer.getTypeCustomer());
            preparedStatement.setString(2,customer.getCustomerName());
            preparedStatement.setString(3,customer.getCustomerBirthday());
            preparedStatement.setBoolean(4,customer.isGender());
            preparedStatement.setString(5,customer.getCustomerIdCard());
            preparedStatement.setString(6,customer.getCustomerPhone());
            preparedStatement.setString(7,customer.getCustomerEmail());
            preparedStatement.setString(8,customer.getCustomerAddress());
            preparedStatement.setString(9,customer.getCustomerCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
