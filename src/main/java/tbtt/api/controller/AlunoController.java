package tbtt.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tbtt.api.domain.model.aluno.AlunoDados;
import tbtt.api.domain.Repository.AlunoRepository;
import tbtt.api.domain.model.aluno.Aluno;
import tbtt.api.domain.model.aluno.AlunoDadosAtualizados;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid AlunoDados dados, UriComponentsBuilder uriBuilder){
        var aluno = new Aluno(dados);
        repository.save(aluno);
        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDados(aluno));
    }

   @GetMapping
    public ResponseEntity<Page<Aluno>> listar(Pageable pageable){

        return ResponseEntity.ok(repository.findAll(pageable));
   }
   @GetMapping("/{id}")
   public ResponseEntity detalhaAluno (@PathVariable Long id){
        var aluno = repository.getReferenceById(id);
        return ResponseEntity.ok(new AlunoDados(aluno));

   }
   @PutMapping
   @Transactional
   public ResponseEntity atualizar(@RequestBody @Valid AlunoDadosAtualizados dados){
    var aluno = repository.getReferenceById(dados.id());
    aluno.atualizarDados(dados);
    return ResponseEntity.ok(new AlunoDados(aluno));
   }

}
