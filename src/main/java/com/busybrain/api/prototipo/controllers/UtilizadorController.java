package com.busybrain.api.prototipo.controllers;

import java.util.Optional;
import java.util.OptionalInt;

import javax.print.attribute.standard.Media;

import com.busybrain.api.prototipo.models.Utilizador;
import com.busybrain.api.prototipo.models.exceptions.NotFoundException;
import com.busybrain.api.prototipo.models.exceptions.NotFoundException2;
import com.busybrain.api.prototipo.models.repositories.UtilizadorRepository;

import org.apache.catalina.startup.ListenerCreateRule.OptionalListener;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController //Indica que estamos a usar um controller
@RequestMapping(path = "/api/users") //URL "geral" do controller. Será a partir deste URL que poderemos aceder aos métodos deste controller
public class UtilizadorController { //Inicio do controller
    
    private Logger logger = LoggerFactory.getLogger(UtilizadorController.class); //Criação do logger. Será responsável por garantir que o método é executado, enviando uma mensagem para o log (não visivel, pois a aplicação está ligada a um repositorio no github, não precisando de ser executada, pois já se encontra online no Heroku)
    @Autowired

    private UtilizadorRepository utilizadorRepository; //Criação de um repositorio. O repositorio vai permitir definir funcoes para usar nos métodos (ex. findById - encontrar um elemento/objeto através do ID | ex. findByUsername - encontrar um elemento/objeto através do username)
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) //Método GET. Utilizado para "obter"/get informação da base de dados.
    public Iterable<Utilizador> getUsers() { //Irá retornar 1 ou mais elementos do objeto Utilizador (utilizadores) que se tenham registado na base de dados da app
        logger.info("A Exibir os utilizadores"); //Informação exibida no log, utilizando o logger criado na linha 33
        return utilizadorRepository.findAll(); //Vai retornar todos os utilizadores da app, utilizando a função findAll(). Esta função já está incluida no CRUDRepository (que foi "chamado" no ficheiro do UtilizadorRepository)
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) //Método GET. Será utilizado para pesquisar um utilizador pelo ID. O parâmetro de input é representado por entre {}.
     public Utilizador getUtilizador(@PathVariable("id") int id){ //Este método retornará somente 1 objeto (1 utilizador), pois cada user terá um ID diferente. Será então inserido o id no URL.
 
        logger.info("Sending user with id: " + id); //Mensagem mostrada no log definido na linha 33.
 
        Optional<Utilizador> _utilizador = utilizadorRepository.findById(id); //O "Optional" indica algo opcional. Ou seja, o que fazer quando o utilizador é encontrado e o que fazer quando o utilizador com o id inserido não é encontrado.
                                                                              //Após ser inserido um id, o objeto utilizador (se existir), será atribuido ao objeto "_utilizador"
        if(!_utilizador.isPresent()) throw  //Se o objeto do utilizador não estiver presente (não existir), irá ser lançada uma excepção (ver no fim do código o que é a excepção e no NotFoundException2.java)
           new NotFoundException2("" + id, "Utilizador", "ID"); //É lançada a excepção (mensagem de erro), quando o utilizador com o id inserido não é encontrado (porque não existe)
        else return _utilizador.get();   //Caso exista, devolve o utilizador com o ID inserido.
 
     }

     //Método GET. Funciona de forma igual ao método anterior (getUtilizador), no entanto, em vez de retornar um objeto inteiro pelo ID....(continua na linha 64)
     @GetMapping(path = "/getUsernameById/{id}", produces = MediaType.APPLICATION_JSON_VALUE) 
     public String getUsernameById(@PathVariable("id") int id){
 
        logger.info("Sending user with id: " + id);
 
        Optional<Utilizador> _utilizador = utilizadorRepository.findById(id);
        if(!_utilizador.isPresent()) throw 
           new NotFoundException2("" + id, "Utilizador", "ID");
        else return _utilizador.get().getUsername();   //....devolve o username do objeto!
 
     }

     //CHANGED
    /*@GetMapping(path = "/getusernames/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUsernameById(@PathVariable("id") int id, @RequestParam("username") String username){

       return "Username " + username;


    }*/

    //Método GET. Funciona de forma igual ao método da linha 42, no entanto, é inserido o username e não o ID.
    @GetMapping(path = "/userbyusername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Utilizador getUtilizadorUsername(@PathVariable(value = "username") String username){

         logger.info("Sending user with username: " + username);

         Optional<Utilizador> _utilizadorr = utilizadorRepository.findByUsername(username);
         if(!_utilizadorr.isPresent()) throw
           new NotFoundException("" + username, "Utilizador", "username");
           else return _utilizadorr.get();

    } 

    //Método GET (de teste). Método realizado para testar a base de dados em PgAdmin4. 

    @GetMapping(path = "/getpassword", produces = MediaType.APPLICATION_JSON_VALUE) //URL para aceder ao método ("/getpassword")
    public Iterable<Utilizador> getUtilizadorPasswordLike(){ //Vai devolver uma lista de utilizadores em que as suas passwords começam com a letra 'J'

        logger.info("Sending user with password like 'j'"); 
        return utilizadorRepository.findByPasswordLikeJ(); //Esta função "findByPasswordLikeJ" NÃO pertence ás CRUDRepository, irá ser explicada no ficheiro "UtilizadorRepository.java"

    }


    //Método POST. Este método é utilizado para o registo de um utilizador na app, pois faz o "POST" (envia e guarda), a informação relativa a um utilizador (Username, email e password)
    @PostMapping(path = "/createuser", produces = MediaType.APPLICATION_JSON_VALUE) //URL para aceder ao método ("/createuser")
    public Utilizador saveUtilizador(@RequestBody Utilizador utilizador){ //Devolverá um utilizador (pois só dá pra registar uma conta de cada vez)

        Utilizador savedUtilizador = utilizadorRepository.save(utilizador); //O utilizador irá ser guardado no repositório de utilizadores ("UtilizadorRepository.java")
        logger.info("Saving user..."); //Mensagem no log.
        return savedUtilizador;

    }

    //Excepção: Uma excepção é uma forma de enviar uma mensagem de erro na tela da API, quando resultado não é encontrado, etc.

}
