package com.senai.escola.Service;
import com.senai.escola.Interface.AlunoRepository;
import com.senai.escola.model.Aluno;

import java.util.List;

public class AlunoService {

    private final AlunoRepository _repository;

    public AlunoService(AlunoRepository _repository) {
        this._repository = _repository;
    }
    public List<Aluno> listarTodos() {
        return _repository.findAll();
    }

    public Aluno salvar(Aluno aluno) {
        return _repository.save(aluno);
    }

    public void deletar(Long id) {
        _repository.deleteById(id);
    }

    public Aluno buscarPorId(Long id) {
        return _repository.findById(id).orElse(null);
    }


}
