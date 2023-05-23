package tbtt.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tbtt.api.domain.Repository.EmprestimoRepository;
import tbtt.api.domain.model.emprestimo.*;
import tbtt.api.infra.exception.ValidacaoException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository repository;
    @Autowired
    private RealizarEmprestimo realizarEmprestimo;

    @Transactional
    public void emprestar(EmprestimoDados dados) {
        realizarEmprestimo.emprestar(dados);
    }

    @Transactional(readOnly = true)
    public Page<EmprestimoDetalhes> findAll(Pageable pageable) {

        var emprestimo = repository.findAll(pageable);
        var emprestimoDetalhado = emprestimo.getContent().stream().map(EmprestimoDetalhes::new).toList();
        int pageNumber = pageable.getPageNumber();
        int pageSize = 10;
        Long totalElements = repository.count();
        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize);
        Page<EmprestimoDetalhes> page = new PageImpl<>(emprestimoDetalhado,pageRequest,totalElements);


        return page;
    }
    @Transactional
    public Emprestimo atualizar(EmprestimoDadosAtualizados dados) {
        var emprestimo = repository.getReferenceById(dados.id());
        emprestimo.atualizar(dados);
        return emprestimo;
    }
    @Transactional
    public Emprestimo findByAluno(Long aluno){
        return repository.findByAluno(aluno);
    }
}
