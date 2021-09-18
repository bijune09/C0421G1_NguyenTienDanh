package com.codegym.model.service.contract;

import com.codegym.model.bean.contract.AttachService;
import com.codegym.model.repository.contract.IAttachServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceImpl implements IAttachServiceService {
    @Autowired
    private IAttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return this.attachServiceRepository.findAll();
    }
}
