package com.senai.escola.controller;
import com.senai.escola.Service.AlunoService;
import com.senai.escola.model.Aluno;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alunos")


    public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService service) {
        this.alunoService = service;
    }

    @GetMapping
    public List<Aluno> listar() {
        return alunoService.listarTodos();
    }

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }

    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno novoAluno) {
        Aluno alunoExistente = alunoService.buscarPorId(id);
        if (alunoExistente == null) return null;

        alunoExistente.setNomeAluno(novoAluno.getNomeAluno());
        alunoExistente.setEmailAluno(novoAluno.getEmailAluno());
        alunoExistente.setTelefoneAluno(novoAluno.getTelefoneAluno());
        return alunoService.salvar(alunoExistente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        alunoService.deletar(id);
    }

}

