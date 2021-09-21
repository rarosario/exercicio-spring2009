package com.exerciciospring2009.controller;

import com.exerciciospring2009.dto.AlunoDto;
import com.exerciciospring2009.model.Aluno;
import com.exerciciospring2009.model.Diploma;
import com.exerciciospring2009.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/cadastra")
    public ResponseEntity<AlunoDto> cadastraAluno(@RequestBody AlunoDto alunoDto, UriComponentsBuilder uriBuilder) {
        Aluno aluno = alunoDto.converteParaAluno();
        Aluno alunoCadastrado = alunoService.cadastra(aluno);

        URI uri = uriBuilder.path("/aluno/busca_id/{id}").buildAndExpand(alunoCadastrado.getId()).toUri();
        return ResponseEntity.created(uri).body(AlunoDto.converteParaAlunoDto(alunoCadastrado));
    }

    @GetMapping("/busca_id/{id}")
    public Aluno getAlunobyId(@PathVariable("id") Integer id) {
        Aluno aluno = alunoService.getAluno(id);
        return aluno;
    }

    @GetMapping("/lista")
    public List<Aluno> listaAluno(){
        return alunoService.listar();
    }

    @GetMapping("/{nome}")
    public Aluno obtemAluno(@PathVariable String nome){
        return alunoService.buscarAluno(nome);
    }

    @DeleteMapping(value ="/deleta/{id}")
    public String remover(@PathVariable("id") Integer id) {
        alunoService.remove(id);
        return "deletado";
    }

    @PutMapping(value = "/atualiza")
    public Aluno atualizar(@RequestBody Aluno aluno) {
        return alunoService.atualizar(aluno);
    }

    @GetMapping("/diploma/{nome}")
    public Diploma diplomaAluno(@PathVariable String nome){
        return alunoService.diplomaAluno(nome);
    }
}






