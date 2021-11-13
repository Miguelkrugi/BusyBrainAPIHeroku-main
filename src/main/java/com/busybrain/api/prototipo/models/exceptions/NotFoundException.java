package com.busybrain.api.prototipo.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Esta é a excepção (uma das excepções). Irá definir o nome dessa excepção, o tipo de excepção ("extends RuntimeException" e onde atua "HttpStatus.NOT_FOUND" - O "NOT_FOUND" é indicado quando um resultado NÃO é encontrado)

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    

    private static final long serialVersionUID=5405519104069955535L;

    public NotFoundException(String username, String elemType, String idName) {
        super(elemType+" with "+idName+" "+username+" not found."); //Definida a mensagem de erro
    }  

    

}
