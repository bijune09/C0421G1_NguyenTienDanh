package model.repository.service;

import model.bean.service.Service;
import model.repository.BaseRepository;
import sun.applet.AppletResourceLoader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepoImpl implements IServiceRepo {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Service> selectAll() {
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("SELECT id_dich_vu, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, \n" +
                            "id_loai_dich_vu, trang_thai, tieu_chuan, dien_tich_ho_boi\n" +
                            "FROM dich_vu;");
            ResultSet resultSet = preparedStatement.executeQuery();
            Service service = null;
            while (resultSet.next()){
                service = new Service();
                service.setIdService(resultSet.getInt("id_dich_vu"));
                service.setNameService(resultSet.getString("ten_dich_vu"));
                service.setServiceArea(resultSet.getInt("dien_tich"));
                service.setFloor(resultSet.getInt("so_tang"));
                service.setCapacity(resultSet.getInt("so_nguoi_toi_da"));
                service.setRent_cost(resultSet.getDouble("chi_phi_thue"));
                service.setIdRentType(resultSet.getInt("id_kieu_thue"));
                service.setIdServiceType(resultSet.getInt("id_loai_dich_vu"));
                service.setDescription(resultSet.getString("trang_thai"));
                service.setStandard(resultSet.getString("tieu_chuan"));
                service.setPoolArea(resultSet.getDouble("dien_tich_ho_boi"));
                serviceList.add(service);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public Service findById(int id) {
        Service service = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("SELECT id_dich_vu, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, \n" +
                            "chi_phi_thue, id_kieu_thue, id_loai_dich_vu, trang_thai, tieu_chuan,\n" +
                            "dien_tich_ho_boi\n" +
                            "FROM dich_vu\n" +
                            "where id_dich_vu = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                service = new Service();
                service.setIdService(id);
                service.setNameService(resultSet.getString("ten_dich_vu"));
                service.setServiceArea(resultSet.getInt("dien_tich"));
                service.setFloor(resultSet.getInt("so_tang"));
                service.setCapacity(resultSet.getInt("so_nguoi_toi_da"));
                service.setRent_cost(resultSet.getDouble("chi_phi_thue"));
                service.setIdRentType(resultSet.getInt("id_kieu_thue"));
                service.setIdServiceType(resultSet.getInt("id_loai_dich_vu"));
                service.setDescription(resultSet.getString("trang_thai"));
                service.setStandard(resultSet.getString("tieu_chuan"));
                service.setPoolArea(resultSet.getDouble("dien_tich_ho_boi"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public void createService(Service service) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("insert into dich_vu\n" +
                            "(ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, id_kieu_thue,id_loai_dich_vu, trang_thai, tieu_chuan, dien_tich_ho_boi)\n" +
                            "values(?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1,service.getNameService());
            preparedStatement.setString(2,service.getServiceArea()+"");
            preparedStatement.setString(3,service.getFloor()+"");
            preparedStatement.setString(4,service.getCapacity()+"");
            preparedStatement.setString(5,service.getRent_cost()+"");
            preparedStatement.setString(6,service.getIdRentType()+"");
            preparedStatement.setString(7,service.getIdServiceType()+"");
            preparedStatement.setString(8,service.getDescription());
            preparedStatement.setString(9,service.getStandard());
            preparedStatement.setString(10,service.getPoolArea()+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void editService(Service service) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("update dich_vu\n" +
                            "set ten_dich_vu = ?, dien_tich = ? , so_tang = ? , so_nguoi_toi_da =? , chi_phi_thue = ?, \n" +
                            "id_kieu_thue =? , id_loai_dich_vu = ?, trang_thai = ?, tieu_chuan = ?, dien_tich_ho_boi = ?\n" +
                            "where id_dich_vu = ?");
            preparedStatement.setString(1,service.getNameService());
            preparedStatement.setString(2,service.getServiceArea()+"");
            preparedStatement.setString(3,service.getFloor()+"");
            preparedStatement.setString(4,service.getCapacity()+"");
            preparedStatement.setString(5,service.getRent_cost()+"");
            preparedStatement.setString(6,service.getIdRentType()+"");
            preparedStatement.setString(7,service.getIdServiceType()+"");
            preparedStatement.setString(8,service.getDescription());
            preparedStatement.setString(9,service.getStandard());
            preparedStatement.setString(10,service.getPoolArea()+"");
            preparedStatement.setString(11,service.getIdService()+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteService(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("delete from dich_vu\n" +
                            "where id_dich_vu = ?");
            preparedStatement.setString(1,id+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
