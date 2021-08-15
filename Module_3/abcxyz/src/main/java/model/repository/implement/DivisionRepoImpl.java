package model.repository.implement;

import model.bean.Division;
import model.repository.BaseRepository;
import model.repository.ITagRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepoImpl implements ITagRepo<Division> {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Division> selectAll() {
        List<Division> divisionList = new ArrayList<>();
        Division division = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from bo_phan");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                division = new Division();
                division.setDivisionId(resultSet.getInt("id_bo_phan"));
                division.setDivisionName(resultSet.getString("ten_bo_phan"));
                divisionList.add(division);
            }
        } catch (SQLException e ){
            e.printStackTrace();
        }
        return divisionList;
    }
}
