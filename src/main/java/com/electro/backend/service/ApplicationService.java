package com.electro.backend.service;

import com.electro.backend.model.Application;
import com.electro.backend.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    public void saveApplication(Application application){
        applicationRepository.save(application);
    }
}
