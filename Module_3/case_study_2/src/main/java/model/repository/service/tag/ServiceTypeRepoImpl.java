package model.repository.service.tag;

import model.bean.service.ServiceType;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepoImpl implements IServiceTypeRepo {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<ServiceType> selectAll() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("SELECT id_loai_dich_vu, ten_loai_dich_vu\n" +
                            "FROM loai_dich_vu;");
            ResultSet resultSet = preparedStatement.executeQuery();
            ServiceType serviceType = null;
            while (resultSet.next()){
                serviceType = new ServiceType();
                serviceType.setIdServiceType(resultSet.getInt("id_loai_dich_vu"));
                serviceType.setServiceType(resultSet.getString("ten_loai_dich_vu"));
                serviceTypeList.add(serviceType);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return serviceTypeList;
    }
}
