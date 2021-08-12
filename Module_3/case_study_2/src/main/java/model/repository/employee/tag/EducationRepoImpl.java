package model.repository.employee.tag;

import model.bean.employee.Education;
import model.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationRepoImpl implements IEducationRepo {
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Education> selectAll() {
        List<Education> educationList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from trinh_do");
            ResultSet resultSet = preparedStatement.executeQuery();
            Education education;
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
