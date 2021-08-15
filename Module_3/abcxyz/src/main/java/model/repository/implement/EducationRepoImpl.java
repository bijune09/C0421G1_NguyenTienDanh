package model.repository.implement;

import model.bean.Education;
import model.repository.BaseRepository;
import model.repository.ITagRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationRepoImpl implements ITagRepo<Education> {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Education> selectAll() {
        List<Education> educationList = new ArrayList<>();
        Education education = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("Select * from trinh_do");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                education = new Education();
                education.setEducationId(resultSet.getInt("id_trinh_do"));
                education.setEducationName(resultSet.getString("trinh_do"));
                educationList.add(education);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return educationList;
    }
}
