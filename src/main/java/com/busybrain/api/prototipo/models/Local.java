package com.busybrain.api.prototipo.models;


import javax.persistence.*;

@Entity
@Table(name = "Local")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "place_id")
    private int local_id;

    @Column(name = "place_name")
    private String local_name;

    @Column(name = "place_endereco")
    private String local_endereco;

    @Column(name = "place_distancia")
    private int local_distancia;


    public Local(){


    }

    public int getLocal_id() {
        return local_id;
    }

    public void setLocal_id(int local_id) {
        this.local_id = local_id;
    }

    public String getLocal_name() {
        return local_name;
    }

    public void setLocal_name(String local_name) {
        this.local_name = local_name;
    }

    public String getLocal_endereco() {
        return local_endereco;
    }

    public void setLocal_endereco(String local_endereco) {
        this.local_endereco = local_endereco;
    }

    public int getLocal_distancia() {
        return local_distancia;
    }

    public void setLocal_distancia(int local_distancia) {
        this.local_distancia = local_distancia;
    }
}
