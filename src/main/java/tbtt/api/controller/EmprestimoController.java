package tbtt.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbtt.api.domain.model.emprestimo.*;
import tbtt.api.domain.Repository.EmprestimoRepository;
import tbtt.api.domain.service.EmprestimoService;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository repository;
    @Autowired
    private RealizarEmprestimo realizarEmprestimo;
    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    @Transactional
    public ResponseEntity<EmprestimoDados> emprestar(@RequestBody @Valid EmprestimoDados dados){
        emprestimoService.emprestar(dados);
        return ResponseEntity.ok(dados);
    }
    @GetMapping
    public ResponseEntity<Page<EmprestimoDetalhes>> listar ( @PageableDefault(size = 10,page = 0,sort = "data") Pageable pageable){
        var emprestimos = emprestimoService.findAll(pageable);
        return ResponseEntity.ok(emprestimos);
    }
    @GetMapping("/{idAluno}")
    public ResponseEntity<EmprestimoDetalhes>buscaPorAluno(@PathVariable Long idAluno){
        var emprestimo = emprestimoService.findByAluno(idAluno);
        return ResponseEntity.ok(new EmprestimoDetalhes(emprestimo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid EmprestimoDadosAtualizados dados){

        var emprestimo = emprestimoService.atualizar(dados);
        return ResponseEntity.ok(new EmprestimoDados(emprestimo));
    }



}
