package com.busybrain.api.prototipo.controllers;


import com.busybrain.api.prototipo.models.repositories.EnrollmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/enrol")
public class EnrolmentControler {

    private Logger logger = LoggerFactory.getLogger(EnrolmentControler.class);

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    //@GetMapping(path = "/")

}
