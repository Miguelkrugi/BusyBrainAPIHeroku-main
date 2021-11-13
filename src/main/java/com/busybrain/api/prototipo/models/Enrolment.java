package com.busybrain.api.prototipo.models;


import javax.persistence.*;

@Entity
@Table(name = "utilizador_tarefa")
public class Enrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "user_tarefa_id")
    private int user_task_id;

    @ManyToOne
    @Column(name = "utilizador")
    private Utilizador utilizador;

    @ManyToOne
    @Column(name = "tarefa")
    private Tarefa tarefa;


    public Enrolment() {

    }

    public int getUser_task_id() {
        return user_task_id;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setUser_task_id(int user_task_id) {
        this.user_task_id = user_task_id;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
}
