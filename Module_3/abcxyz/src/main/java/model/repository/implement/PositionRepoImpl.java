package model.repository.implement;

import model.bean.Position;
import model.repository.BaseRepository;
import model.repository.ITagRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepoImpl implements ITagRepo<Position> {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Position> selectAll() {
        List<Position> positionList = new ArrayList<>();
        Position position = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from vi_tri");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                position = new Position();
                position.setPositionId(resultSet.getInt("id_vi_tri"));
                position.setPositionName(resultSet.getString("ten_vi_tri"));
                positionList.add(position);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return positionList;
    }
}
