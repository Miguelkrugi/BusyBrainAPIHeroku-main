package com.busybrain.api.prototipo.models.repositories;

import java.util.Optional;

import com.busybrain.api.prototipo.models.Tarefa;
import com.busybrain.api.prototipo.models.Utilizador;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UtilizadorRepository extends CrudRepository<Utilizador, Integer>{ //O repositório irá HERDAR todas as funções CRUD (findAll, findById, etc.)

    Optional<Utilizador> findByUsername(String username); //É uma query que permitirá ser inserido um username, e procurar por esse username ("findByUsername"). Utilizado no método da linha 78 do "UtilizadorController.java"
    
    //@Query
    //Iterable<Tarefa> findTaskbyUser(int id);


    //A @Query, indica que estamos a querer fazer uma query especifica, que aceda a algo especifico na nossa base de dados
    //Neste caso, esta query irá fazer um select de tudo na tabela "utilizador" quando (WHERE) a password de um utilizador começa com a letra 'J'
    //Podemos testar também a string do "value" no Query Editor do PgAdmin e ver o resultado.

    @Query(value = "select * from utilizador" +  " WHERE user_password LIKE 'j%'", nativeQuery = true)
    Iterable<Utilizador> findByPasswordLikeJ();

    //O @Query é OBRIGATÓRIO para queries mais especificas de acesso á base de dados (chamadas de Custom Queries).

}
