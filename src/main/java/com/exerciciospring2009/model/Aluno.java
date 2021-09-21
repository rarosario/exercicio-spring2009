package com.exerciciospring2009.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Aluno {
    private Integer id;
    private String nome;
    private String endereco;
    private Integer idade;
    private List<Disciplina> disciplinas = new ArrayList<>();


    public Aluno(){

    }

    public Aluno (String nome, String endereco, Integer idade) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
    }
}
