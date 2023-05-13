package tbtt.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tbtt.api.domain.model.livro.LivrosDados;
import tbtt.api.domain.Repository.LivroRepository;
import tbtt.api.domain.model.livro.Livro;
import tbtt.api.domain.model.livro.LivrosDadosAtualizados;
import tbtt.api.domain.service.LivroService;

@RestController
@RequestMapping("livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid LivrosDados dados, UriComponentsBuilder uriBuilder){
        var livro = new Livro(dados);
        livroService.save(livro);
        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(new LivrosDados(livro));
    }
    @GetMapping
    public ResponseEntity<Page<Livro>> listar(@PageableDefault(sort = "titulo") Pageable pageable ){
        return ResponseEntity.ok(livroService.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LivrosDados> detalhaLivro(@PathVariable Long id){
        var livro = livroService.findById(id);
        return ResponseEntity.ok(new LivrosDados(livro));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid LivrosDadosAtualizados dados){
        var livro = livroService.atualizar(dados);
        return ResponseEntity.ok(new LivrosDados(livro));
    }
}
