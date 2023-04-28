package tbtt.api.controller.emprestimo;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbtt.api.domain.DTO.emprestimo.EmprestimoDados;
import tbtt.api.domain.Repository.EmprestimoRepository;
import tbtt.api.domain.model.emprestimo.RealizarEmprestimo;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {

    @Autowired
    private RealizarEmprestimo realizarEmprestimo;
    @Autowired
    private EmprestimoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity emprestar(@RequestBody @Valid EmprestimoDados dados){
        realizarEmprestimo.emprestar(dados);
        return ResponseEntity.ok("Emprestimo realizado");
    }
//    @GetMapping
//    public ResponseEntity<Page<EmprestimoDetalhes>> listar(@PageableDefault Pageable pageable){
//        var page = repository.findAll(pageable).stream().map(EmprestimoDetalhes::new);
//        System.out.println(pageable);
//        return ResponseEntity.ok(page);
//    }
}
