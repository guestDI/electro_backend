package com.electro.backend.controller;

import com.electro.backend.model.Application;
import com.electro.backend.repository.ApplicationRepository;
import com.electro.backend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/applications")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/addApplication", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addApplication(@RequestBody Application application){
        applicationService.saveApplication(application);
    }

    @RequestMapping(value = "/getAllApplications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Application> findAll() {
        return applicationService.getAll();
    }

    @RequestMapping(value = "/updateApplicationStatus/{id}/{status}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer updateApplicationStatus(@PathVariable("id") Long id, @PathVariable("status") boolean status) {
        return applicationService.updateApplicationStatus(id, status);
    }
}
