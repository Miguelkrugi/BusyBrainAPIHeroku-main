package com.busybrain.api.prototipo.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity  
@Table(name = "tarefa")
public class Tarefa {
    
    @Id  //Obrigatório possuir ID
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "task_id") private int id;
    @Column(name = "task_title") private String title;
    @Column(name = "task_desc") private String description;
    @Column(name = "task_type") private String type;

    @OneToMany
    private ArrayList<Enrolment> enrolments = new ArrayList<>();

    public Tarefa(){

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
