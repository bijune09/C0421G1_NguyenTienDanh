package model.repository.employee;

import model.bean.employee.Employee;
import model.repository.BaseRepository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepoImpl implements IEmployeeRepo {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Employee> selectAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select id_nhan_vien,ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh," +
                            "so_CMTND,luong,sdt,email,dia_chi,ten_tai_khoan from nhan_vien");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployee_id(resultSet.getInt("id_nhan_vien"));
                employee.setEmployee_name(resultSet.getString("ho_ten"));
                employee.setEmployee_id_position(resultSet.getInt("id_vi_tri"));
                employee.setEmployee_id_education(resultSet.getInt("id_trinh_do"));
                employee.setEmployee_id_division(resultSet.getInt("id_bo_phan"));
                employee.setEmployee_birthday(resultSet.getString("ngay_sinh"));
                employee.setEmployee_id_card(resultSet.getString("so_CMTND"));
                employee.setEmployee_salary(resultSet.getDouble("luong"));
                employee.setEmployee_phone(resultSet.getString("sdt"));
                employee.setEmployee_email(resultSet.getString("email"));
                employee.setEmployee_address(resultSet.getString("dia_chi"));
                employee.setEmployee_user_name(resultSet.getString("ten_tai_khoan"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void createEmployee(Employee employee) throws SQLException {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("insert into nhan_vien(ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,so_CMTND,luong,sdt,email,dia_chi) \n" +
                            "VALUES (?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setString(2, employee.getEmployee_id_position() + "");
            preparedStatement.setString(3, employee.getEmployee_id_education() + "");
            preparedStatement.setString(4, employee.getEmployee_id_position() + "");
            preparedStatement.setString(5, employee.getEmployee_birthday() + "");
            preparedStatement.setString(6, employee.getEmployee_id_card());
            preparedStatement.setString(7, employee.getEmployee_salary() + "");
            preparedStatement.setString(8, employee.getEmployee_phone());
            preparedStatement.setString(9, employee.getEmployee_email());
            preparedStatement.setString(10, employee.getEmployee_address());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select id_nhan_vien,ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,so_CMTND,luong,sdt,email,dia_chi,ten_tai_khoan \n" +
                            "from nhan_vien\n" +
                            "where id_nhan_vien = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
//                employee.setEmployee_id(id);
//                employee.setEmployee_name(resultSet.getString("ho_ten"));
//                employee.setEmployee_id_position(resultSet.getInt("id_vi_tri"));
//                employee.setEmployee_id_education(resultSet.getInt("id_trinh_do"));
//                employee.setEmployee_id_division(resultSet.getInt("id_bo_phan"));
//                employee.setEmployee_birthday(resultSet.getString("ngay_sinh"));
//                employee.setEmployee_id_card(resultSet.getString("so_CMTND"));
//                employee.setEmployee_salary(resultSet.getDouble("luong"));
//                employee.setEmployee_phone(resultSet.getString("sdt"));
//                employee.setEmployee_email(resultSet.getString("email"));
//                employee.setEmployee_address(resultSet.getString("dia_chi"));
//                employee.setEmployee_user_name(resultSet.getString("ten_tai_khoan"));
                String name = resultSet.getString("ho_ten");
                int position = resultSet.getInt("id_vi_tri");
                int education = resultSet.getInt("id_vi_tri");
                int division = resultSet.getInt("id_vi_tri");
                String birthday = resultSet.getString("ngay_sinh");
                String idCard = resultSet.getString("so_CMTND");
                double salary = resultSet.getDouble("luong");
                String phone = resultSet.getString("sdt");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                String username = resultSet.getString("ten_tai_khoan");
                employee = new Employee(id,name,position,education,division,birthday,idCard,salary,phone,email,address
                ,username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean deleteEmployee(int id) {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("delete from nhan_vien\n" +
                            "where id_nhan_vien = ?");
            preparedStatement.setString(1, id + "");
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean editEmployee(Employee employee) {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("update nhan_vien\n" +
                            "set ho_ten = ?, id_vi_tri = ?, id_trinh_do = ?, id_bo_phan = ?, ngay_sinh = ?,\n" +
                            "so_CMTND = ?, luong = ?, sdt = ?, email = ?, dia_chi = ?\n" +
                            "where id_nhan_vien = ?");
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setInt(2, employee.getEmployee_id_position());
            preparedStatement.setInt(3, employee.getEmployee_id_education());
            preparedStatement.setInt(4, employee.getEmployee_id_position());
            preparedStatement.setDate(5, Date.valueOf(employee.getEmployee_birthday()));
            preparedStatement.setString(6, employee.getEmployee_id_card());
            preparedStatement.setDouble(7, employee.getEmployee_salary());
            preparedStatement.setString(8, employee.getEmployee_phone());
            preparedStatement.setString(9, employee.getEmployee_email());
            preparedStatement.setString(10, employee.getEmployee_address());
            preparedStatement.setInt(11, employee.getEmployee_id());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }
}
