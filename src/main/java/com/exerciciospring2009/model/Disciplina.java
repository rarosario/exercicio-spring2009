package com.exerciciospring2009.model;

import lombok.Data;

@Data
public class Disciplina {

    private String nome;
    private Double nota;

    public Disciplina(){
    }

    public Disciplina (String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
    }
}
