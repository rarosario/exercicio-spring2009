package com.exerciciospring2009.service;

import com.exerciciospring2009.model.Aluno;
import com.exerciciospring2009.model.Diploma;
import com.exerciciospring2009.model.Disciplina;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    List<Aluno> alunoList = new ArrayList<>();

    public Aluno cadastra(Aluno aluno) {
        alunoList.add(aluno);
        aluno.setId(alunoList.size());
        return aluno;
    }

    public List<Aluno> listar(){
        return alunoList;
    }

    public Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunoList) {
            if (aluno.getNome().equalsIgnoreCase(nome)){
                return aluno;
            }
        }
        return null;
    }

    public void remove(Integer id) {
        for (Aluno aluno : alunoList) {
            if (aluno.getId().equals(id)) {
                alunoList.remove(aluno);
            }
        }
    }

    public Aluno atualizar(Aluno aluno) {
        for (int i = 0; i< alunoList.size();i++){
            if (alunoList.get(i).getId().equals(aluno.getId())) {
                alunoList.set(i,aluno);
            }
        }
        return aluno;
    }

    public Aluno getAluno(Integer id) {
        for (Aluno aluno : alunoList) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        return null;
    }

    public Diploma diplomaAluno(String nome){
        double notas = 0, media = 0;
        for (Aluno aluno : alunoList) {
            if (aluno.getNome().equalsIgnoreCase(nome)){
                for (Disciplina disciplina : aluno.getDisciplinas()){
                    notas += disciplina.getNota();
                }
                media = notas/aluno.getDisciplinas().size();
                String retorno = "";
                if(media > 9d){
                    retorno = "Parabéns!!";
                }else if(media > 5d){
                    retorno = "Aprovado";
                }else{
                    retorno = "Reprovado";
                }
                Diploma diploma = new Diploma(media,retorno,aluno);
                return diploma;
            }
        }
        return null;
    }
}
