package model.repository.customer;

import model.bean.customer.TypeCustomer;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepoImpl implements ICustomerTypeRepo {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<TypeCustomer> selectAll() {
        List<TypeCustomer> typeCustomerList = new ArrayList<>();
        TypeCustomer typeCustomer = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select *" +
                            "from loai_khach");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                typeCustomer = new TypeCustomer();
                typeCustomer.setIdTypeCustomer(resultSet.getInt("id_loai_khach"));
                typeCustomer.setTypeCustomer(resultSet.getString("ten_loai_khach"));
                typeCustomerList.add(typeCustomer);
            }
        } catch (SQLException e ){
            e.printStackTrace();
        }
        return typeCustomerList;
    }
}
