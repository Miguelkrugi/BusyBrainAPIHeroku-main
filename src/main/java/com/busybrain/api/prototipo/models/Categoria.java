package com.busybrain.api.prototipo.models;


import javax.persistence.*;

@Entity
@Table(name="categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "categoria_id")
    private int categoria_id;

    @Column(name="categoria_name")
    private String categoria_nome;


    public Categoria(){


    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public String getCategoria_nome() {
        return categoria_nome;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public void setCategoria_nome(String categoria_nome) {
        this.categoria_nome = categoria_nome;
    }
}
