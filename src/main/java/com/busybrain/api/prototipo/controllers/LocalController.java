package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.Local;
import com.busybrain.api.prototipo.models.repositories.LocalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/locals")
public class LocalController {

    private Logger logger = LoggerFactory.getLogger(LocalController.class);

    @Autowired
    private LocalRepository localRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Local> findAllLocals(){

        logger.info("Sending All Locals");

        return localRepository.findAll();
    }

    @GetMapping(path = "/{localFilter}")
    public Local localByFilter(@PathVariable("localFilter") String local){

        logger.info("Sending Local with: "+local);

        return localRepository.findLocalByLocal_nameContaining(local);
    }


}
