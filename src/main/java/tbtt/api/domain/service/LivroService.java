package tbtt.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tbtt.api.domain.Repository.LivroRepository;
import tbtt.api.domain.model.livro.Livro;
import tbtt.api.domain.model.livro.LivrosDados;
import tbtt.api.domain.model.livro.LivrosDadosAtualizados;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    @Transactional
    public void save(Livro livro){
        repository.save(livro);
    }

    @Transactional(readOnly = true)
    public Page<Livro> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Livro findById(Long id) {

        return repository.getReferenceById(id);
    }

    @Transactional
    public Livro atualizar(LivrosDadosAtualizados dados) {
        var livro = repository.getReferenceById(dados.id());
        livro.atualizarDados(dados);
        return livro;
    }
}
