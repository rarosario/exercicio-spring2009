package com.exerciciospring2009.model;

import lombok.Data;

@Data
public class Diploma {
    private Double media;
    private String avaliacao;
    private Aluno aluno;

    public Diploma(Double media, String avaliacao, Aluno aluno) {
        this.media = media;
        this.avaliacao = avaliacao;
        this.aluno = aluno;
    }
}
