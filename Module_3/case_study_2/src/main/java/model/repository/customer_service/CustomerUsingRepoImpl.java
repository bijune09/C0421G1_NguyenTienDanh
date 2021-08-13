package model.repository.customer_service;

import model.bean.customer_using_contract.CustomerUsing;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsingRepoImpl implements ICustomerUsingRepo {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<CustomerUsing> selectAll() {
        List<CustomerUsing> customerUsingList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select kh.id_khach_hang,kh.ho_ten,kh.ma_khach_hang,hd.id_hop_dong,dvdk.ten_dich_vu_di_kem\n" +
                            "from khach_hang kh\n" +
                            "join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang\n" +
                            "join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong\n" +
                            "join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem;");
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerUsing customerUsing = null;
            while (resultSet.next()){
                customerUsing = new CustomerUsing();
                customerUsing.setNameCustomer(resultSet.getString("kh.ho_ten"));
                customerUsing.setCustomerCode(resultSet.getString("kh.ma_khach_hang"));
                customerUsing.setIdContract(resultSet.getInt("hd.id_hop_dong"));
                customerUsing.setAttachServiceName(resultSet.getString("dvdk.ten_dich_vu_di_kem"));
                customerUsing.setCustomerId(resultSet.getInt("kh.id_khach_hang"));
                customerUsingList.add(customerUsing);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return customerUsingList;
    }

    @Override
    public CustomerUsing findById(int id) {
        CustomerUsing customerUsing = new CustomerUsing();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select kh.ho_ten,kh.ma_khach_hang,hd.id_hop_dong,dvdk.ten_dich_vu_di_kem\n" +
                            "from khach_hang kh\n" +
                            "join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang\n" +
                            "join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong\n" +
                            "join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem\n" +
                            "where kh.id_khach_hang = ?;");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                customerUsing.setNameCustomer(resultSet.getString("kh.ho_ten"));
                customerUsing.setCustomerCode(resultSet.getString("kh.ma_khach_hang"));
                customerUsing.setIdContract(resultSet.getInt("hd.id_hop_dong"));
                customerUsing.setNameCustomer(resultSet.getString("dvdk.ten_dich_vu_di_kem"));
                customerUsing.setCustomerId(id);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return customerUsing;
    }

    @Override
    public void edit(CustomerUsing customerUsing) {

    }

    @Override
    public void remove(int id) {

    }
}
