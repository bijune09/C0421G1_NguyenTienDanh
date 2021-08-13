package model.repository.contract;

import model.bean.contract.ContractDetail;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DetailContractRepoImpl implements IDetailContractRepo {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public void createContractDetail(ContractDetail contractDetail) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("INSERT INTO hop_dong_chi_tiet(id_hop_dong, id_dich_vu_di_kem, so_luong)\n" +
                            "VALUES (?,?,?);");
            preparedStatement.setString(1,contractDetail.getContractId()+"");
            preparedStatement.setString(2,contractDetail.getAttachServiceId()+"");
            preparedStatement.setString(3,contractDetail.getQuantity()+"");
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
