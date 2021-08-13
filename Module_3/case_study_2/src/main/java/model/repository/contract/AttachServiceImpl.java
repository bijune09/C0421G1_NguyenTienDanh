package model.repository.contract;

import model.bean.contract.AttachService;
import model.bean.service.RentType;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceImpl implements IAttachServiceRepo {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<AttachService> selectAll() {
        List<AttachService> attachServiceList = new ArrayList<>();
        AttachService attachService = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("SELECT id_dich_vu_di_kem, ten_dich_vu_di_kem, gia, don_vi, trang_thai_kha_dung\n" +
                            " FROM dich_vu_di_kem;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                attachService = new AttachService();
                attachService.setAttachServiceId(resultSet.getInt("id_dich_vu_di_kem"));
                attachService.setAttachServiceName(resultSet.getString("ten_dich_vu_di_kem"));
                attachService.setAttachServiceCost(resultSet.getDouble("gia"));
                attachService.setUnit(resultSet.getString("don_vi"));
                attachService.setStatus(resultSet.getString("trang_thai_kha_dung"));
                attachServiceList.add(attachService);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return attachServiceList;
    }
}
