package model.repository.service.tag;

import model.bean.service.RentType;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepoImpl implements IRentTypeRepo {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<RentType> selectAll() {
        List<RentType> rentTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select id_kieu_thue, ten_kieu_thue\n" +
                            "from kieu_thue;");
            ResultSet resultSet = preparedStatement.executeQuery();
            RentType rentType =null;
            while (resultSet.next()){
                rentType = new RentType();
                rentType.setIdRentType(resultSet.getInt("id_kieu_thue"));
                rentType.setRentType(resultSet.getString("ten_kieu_thue"));
                rentTypeList.add(rentType);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rentTypeList;
    }
}
