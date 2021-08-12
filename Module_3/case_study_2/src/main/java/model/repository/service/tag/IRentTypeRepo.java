package model.repository.service.tag;

import model.bean.service.RentType;

import java.util.List;

public interface IRentTypeRepo {
    List<RentType> selectAll();
}
