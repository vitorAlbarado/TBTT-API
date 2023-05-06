package tbtt.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbtt.api.domain.model.emprestimo.EmprestimoDados;
import tbtt.api.domain.Repository.EmprestimoRepository;
import tbtt.api.domain.model.emprestimo.EmprestimoDetalhes;
import tbtt.api.domain.model.emprestimo.RealizarEmprestimo;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository repository;
    @Autowired
    private RealizarEmprestimo realizarEmprestimo;

    @PostMapping
    @Transactional
    public ResponseEntity emprestar(@RequestBody @Valid EmprestimoDados dados){
        realizarEmprestimo.emprestar(dados);
        return ResponseEntity.ok("Emprestimo realizado");
    }
    @GetMapping
    public ResponseEntity<Page<EmprestimoDetalhes>> listar (Pageable pageable){
        var emprestimos = repository.findAll(pageable).map(EmprestimoDetalhes::new);
        return ResponseEntity.ok(emprestimos);
    }



}
