package com.busybrain.api.prototipo.controllers;


import com.busybrain.api.prototipo.models.Categoria;
import com.busybrain.api.prototipo.models.Local;
import com.busybrain.api.prototipo.models.repositories.CategoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categorys")
public class CategoriaController {

    private Logger logger  = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public Iterable<Categoria> findAllCategorys(){

        logger.info("Sending All Categorys");

        return categoriaRepository.findAll();
    }

    @GetMapping("/{category}")
    public Categoria CategoryFilter(@PathVariable("category") String name){

        logger.info("Sending Category with :"+name);

        return categoriaRepository.findCategoriaByCategoria_nomeContaining(name);
    }
}
