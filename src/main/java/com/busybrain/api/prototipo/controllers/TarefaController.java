package com.busybrain.api.prototipo.controllers;

import java.util.Optional;

import javax.print.attribute.standard.Media;

import com.busybrain.api.prototipo.models.Tarefa;
import com.busybrain.api.prototipo.models.exceptions.NotFoundException2;
import com.busybrain.api.prototipo.models.repositories.TarefaRepository;

import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/tasks")
public class TarefaController {
    
    private Logger logger = LoggerFactory.getLogger(TarefaController.class); 
    @Autowired
    private TarefaRepository tarefaRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tarefa> getTasks() {
        logger.info("A Exibir todas as tarefas criadas na app");
        return tarefaRepository.findAll();
    }

    @PostMapping(path = "/createtask", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tarefa saveTarefa(@RequestBody Tarefa tarefa){

       Tarefa savedTarefa = tarefaRepository.save(tarefa);
       logger.info("Saving tarefa...");
       return savedTarefa;

    }

    @GetMapping(path = "/getinfo/{task_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tarefa getInfoTarefa(@PathVariable(value = "task_id") int id){

         logger.info("Getting info from the task with id: " + id);

         //Optional<Tarefa> _utilizador = utilizadorRepository.findById(id);

         Optional<Tarefa> _tarefa = tarefaRepository.findById(id);
         if(!_tarefa.isPresent()) throw 
           new NotFoundException2("" + id, "Tarefa", "ID");
        else return _tarefa.get(); 

    }

    @GetMapping(path = "/filtertype/{task_type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tarefa> getTasksByType(@PathVariable(value = "task_type") String type){

        logger.info("Sending tasks with type: " + type);
        return tarefaRepository.findByType(type);

    }

    @GetMapping(path = "/searchtitle/{task_title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tarefa> getTaskByTitleContaining(@PathVariable(value = "task_title") String title){
    
         logger.info("Sending tasks with title containing: " + title);
         return tarefaRepository.findByTitleContaining(title);
    
    } 

    @DeleteMapping(path = "/deletetask/{task_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTarefa(@PathVariable("task_id") int id){

         logger.info("Deleting task with id: " + id);

         tarefaRepository.deleteById(id);

    }
 
       /*@DeleteMapping(path = "{number}",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public Response deleteStudent(@PathVariable("number") int number) {
        logger.info("deleting student with number "+number);
        if (StudentRepository.deleteStudent(number))
          return new Response(number+" was deleted.",null);
        else return new Response(number+" not found.",null);
    }*/

}
