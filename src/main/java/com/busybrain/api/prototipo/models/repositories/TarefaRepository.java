package com.busybrain.api.prototipo.models.repositories;

import java.util.Optional;

import com.busybrain.api.prototipo.models.Tarefa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TarefaRepository extends CrudRepository<Tarefa, Integer>{

    //@Query(value = "select * from utilizador" +  " WHERE user_password LIKE 'j%'", nativeQuery = true)
    //Iterable<Utilizador> findByPasswordLikeJ();

    //@Query(value = "select * " + "from tarefa", nativeQuery = true)
    //Iterable<Tarefa> findAllTasks();

    Iterable<Tarefa> findByType(String type);

    Iterable<Tarefa> findByTitleContaining(String title);

}
