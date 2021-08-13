package model.repository.contract;

import model.bean.contract.AttachService;

import java.util.List;

public interface IAttachServiceRepo {
    List<AttachService> selectAll();
}
