package com.exerciciospring2009.dto;

import com.exerciciospring2009.model.Aluno;
import com.exerciciospring2009.model.Disciplina;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class AlunoDto implements Serializable {

    private String nome;
    private String endereco;
    private Integer idade;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public AlunoDto(String nome, String endereco, Integer idade, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.disciplinas = disciplinas;
    }

    public Aluno converteParaAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(this.nome);
        aluno.setEndereco(this.endereco);
        aluno.setIdade(this.idade);
        aluno.setDisciplinas(this.disciplinas);
        return aluno;
    }

    public static AlunoDto converteParaAlunoDto(Aluno aluno) {
        AlunoDto alunoDto = new AlunoDto(aluno.getNome(), aluno.getEndereco(),aluno.getIdade(),aluno.getDisciplinas());
        return alunoDto;
    }
}