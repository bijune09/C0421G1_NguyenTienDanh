package model.repository.service.tag;

import model.bean.service.ServiceType;

import java.util.List;

public interface IServiceTypeRepo {
    List<ServiceType> selectAll();
}
