package tbtt.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbtt.api.domain.model.aluno.AlunoDados;
import tbtt.api.domain.Repository.AlunoRepository;
import tbtt.api.domain.model.aluno.Aluno;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid AlunoDados dados){
        var aluno = new Aluno(dados);
        repository.save(aluno);
        return ResponseEntity.ok("ALUNO CADASTRADO COM SUCESSO!");
    }

   @GetMapping
    public ResponseEntity<Page<Aluno>> listar(Pageable pageable){

        return ResponseEntity.ok(repository.findAll(pageable));
   }
}
