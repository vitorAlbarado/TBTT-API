package tbtt.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tbtt.api.domain.Repository.AlunoRepository;
import tbtt.api.domain.model.aluno.Aluno;
import tbtt.api.domain.model.aluno.AlunoDadosAtualizados;


@Service
public class AlunoService {
    @Autowired
    AlunoRepository repository;

    @Transactional
    public void save(Aluno aluno) {
        repository.save(aluno);
    }
    @Transactional(readOnly = true)
    public Aluno findByID(Long id) {
        return repository.getReferenceById(id);
    }
    @Transactional(readOnly = true)
    public Page<Aluno> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public Aluno atualizar(AlunoDadosAtualizados dados) {
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarDados(dados);
        return aluno;
    }
}
