package model.repository.implement;

import model.bean.Employee;
import model.repository.BaseRepository;
import model.repository.IEmployeeRepository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImplement implements IEmployeeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Employee> selectAll() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from nhan_vien");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee = new Employee();
                employee.setId(resultSet.getInt("id_nhan_vien"));
                employee.setName(resultSet.getString("ho_ten"));
                employee.setBirthday(resultSet.getString("ngay_sinh"));
                employee.setIdCard(resultSet.getString("so_CMTND"));
                employee.setSalary(resultSet.getDouble("luong"));
                employee.setPhone(resultSet.getString("sdt"));
                employee.setEmail(resultSet.getString("email"));
                employee.setAddress(resultSet.getString("dia_chi"));
                employee.setPositionId(resultSet.getInt("id_vi_tri"));
                employee.setDivisionId(resultSet.getInt("id_bo_phan"));
                employee.setEducationId(resultSet.getInt("id_trinh_do"));
                employeeList.add(employee);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("Select * from nhan_vien where id_nhan_vien = ?");
            preparedStatement.setString(1,id+"");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                employee = new Employee();
                employee.setId(id);
                employee.setName(resultSet.getString("ho_ten"));
                employee.setBirthday(resultSet.getString("ngay_sinh"));
                employee.setIdCard(resultSet.getString("so_CMTND"));
                employee.setSalary(resultSet.getDouble("luong"));
                employee.setPhone(resultSet.getString("sdt"));
                employee.setEmail(resultSet.getString("email"));
                employee.setAddress(resultSet.getString("dia_chi"));
                employee.setPositionId(resultSet.getInt("id_vi_tri"));
                employee.setDivisionId(resultSet.getInt("id_bo_phan"));
                employee.setEducationId(resultSet.getInt("id_trinh_do"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("insert into nhan_vien(ho_ten,ngay_sinh,so_CMTND,luong,sdt,email,dia_chi,id_vi_tri,id_bo_phan,id_trinh_do)\n" +
                            "VALUES (?,?,?,?,?,?,?,?,?,?) ");
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getBirthday());
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setString(4,employee.getSalary()+"");
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setString(8,employee.getPositionId()+"");
            preparedStatement.setString(9,employee.getDivisionId()+"");
            preparedStatement.setString(10,employee.getEducationId()+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeEmployee(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("delete from nhan_vien where id_nhan_vien = ?");
            preparedStatement.setString(1,id+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void editEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("update nhan_vien\n" +
                            "set ho_ten = ?,ngay_sinh = ?,so_CMTND = ?,luong = ?,sdt = ?,email = ?,dia_chi = ?,id_vi_tri = ?,id_bo_phan = ?,id_trinh_do = ?\n" +
                            "where id_nhan_vien = ?");
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getBirthday());
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setString(4,employee.getSalary()+"");
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setString(8,employee.getPositionId()+"");
            preparedStatement.setString(9,employee.getDivisionId()+"");
            preparedStatement.setString(10,employee.getEducationId()+"");
            preparedStatement.setString(11,employee.getId()+"");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> findByChar(String character) {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = null;
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().
                    prepareCall("Call find_by_char(?)");
            callableStatement.setString(1,character);
            ResultSet resultSet =  callableStatement.executeQuery();
            while (resultSet.next()){
                employee = new Employee();
                employee.setId(resultSet.getInt("id_nhan_vien"));
                employee.setName(resultSet.getString("ho_ten"));
                employee.setBirthday(resultSet.getString("ngay_sinh"));
                employee.setIdCard(resultSet.getString("so_CMTND"));
                employee.setSalary(resultSet.getDouble("luong"));
                employee.setPhone(resultSet.getString("sdt"));
                employee.setEmail(resultSet.getString("email"));
                employee.setAddress(resultSet.getString("dia_chi"));
                employee.setPositionId(resultSet.getInt("id_vi_tri"));
                employee.setDivisionId(resultSet.getInt("id_bo_phan"));
                employee.setEducationId(resultSet.getInt("id_trinh_do"));
                employeeList.add(employee);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return employeeList;
    }
}
