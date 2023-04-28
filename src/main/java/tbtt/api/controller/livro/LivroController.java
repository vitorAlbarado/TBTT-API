package tbtt.api.controller.livro;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbtt.api.domain.DTO.livro.ListagemLivro;
import tbtt.api.domain.DTO.livro.LivrosDados;
import tbtt.api.domain.Repository.LivroRepository;
import tbtt.api.domain.model.livro.Livro;

@RestController
@RequestMapping("livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid LivrosDados dados){
        var livro = new Livro(dados);
        repository.save(livro);
        return ResponseEntity.ok(livro);
    }

    @GetMapping
    public ResponseEntity<Page<ListagemLivro>> listar(Pageable pageable ){
        var page = repository.findAll(pageable).map(ListagemLivro::new);
        return ResponseEntity.ok(page);

    }
}
