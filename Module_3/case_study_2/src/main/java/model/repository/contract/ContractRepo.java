package model.repository.contract;

import model.bean.contract.Contract;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepo implements IContractRepo {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Contract> selectAll() {
        List<Contract> contractList = new ArrayList<>();
        Contract contract = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("SELECT id_hop_dong, id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc\n" +
                            " FROM case_study.hop_dong;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                contract = new Contract();
                contract.setIdContract(resultSet.getInt("id_hop_dong"));
                contract.setIdEmployee(resultSet.getInt("id_nhan_vien"));
                contract.setIdCustomer(resultSet.getInt("id_khach_hang"));
                contract.setIdService(resultSet.getInt("id_dich_vu"));
                contract.setStartDate(resultSet.getString("ngay_lam_hop_dong"));
                contract.setEndDate(resultSet.getString("ngay_ket_thuc"));
                contract.setTotalMoney(resultSet.getDouble("tien_dat_coc"));
                contractList.add(contract);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public void createContract(Contract contract) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong," +
                            "ngay_ket_thuc,tien_dat_coc) values (?,?,?,?,?,?);");
            preparedStatement.setString(1,contract.getIdEmployee()+"");
            preparedStatement.setString(2,contract.getIdCustomer()+"");
            preparedStatement.setString(3,contract.getIdService()+"");
            preparedStatement.setString(4,contract.getStartDate());
            preparedStatement.setString(5,contract.getEndDate());
            preparedStatement.setString(6,contract.getTotalMoney()+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void editContract(Contract contract) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("update from hop_dong" +
                            "set id_nhan_vien = ?, id_khach_hang = ?, id_dich_vu = ?, ngay_lam_hop_dong = ?," +
                            "ngay_ket_thuc = ?, tien_dat_coc = ?" +
                            "where id_hop_dong = ?");
            preparedStatement.setString(1,contract.getIdEmployee()+"");
            preparedStatement.setString(2,contract.getIdCustomer()+"");
            preparedStatement.setString(3,contract.getIdService()+"");
            preparedStatement.setString(4,contract.getStartDate());
            preparedStatement.setString(5,contract.getEndDate());
            preparedStatement.setString(6,contract.getTotalMoney()+"");
            preparedStatement.setString(7,contract.getIdContract()+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContract(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("delete from hop_dong" +
                            "where id_hop_dong = ?");
            preparedStatement.setString(1,id+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Contract findById(int id) {
        Contract contract =null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select id_hop_dong,id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong," +
                            "ngay_ket_thuc,tien_dat_coc" +
                            "from hop_dong" +
                            "where id_hop_dong = ?");
            preparedStatement.setString(1,id+"");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                contract = new Contract();
                contract.setIdContract(resultSet.getInt("id_hop_dong"));
                contract.setIdCustomer(resultSet.getInt("id_nhan_vien"));
                contract.setIdCustomer(resultSet.getInt("id_khach_hang"));
                contract.setIdService(resultSet.getInt("id_dich_vu"));
                contract.setStartDate(resultSet.getString("ngay_lam_hop_dong"));
                contract.setEndDate(resultSet.getString("ngay_ket_thuc"));
                contract.setTotalMoney(resultSet.getDouble("tien_dat_coc"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return contract;
    }
}
