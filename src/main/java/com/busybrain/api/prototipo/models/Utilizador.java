package com.busybrain.api.prototipo.models;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;

@Entity  
@Table(name = "utilizador")
public class Utilizador {
    
    @Id  //Obrigatório possuir ID
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "user_id") private int id;
    @Column(name = "user_name") private String username;
    @Column(name = "user_password") private String password;
    @Column(name = "user_email") private String email;


    public Utilizador(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
