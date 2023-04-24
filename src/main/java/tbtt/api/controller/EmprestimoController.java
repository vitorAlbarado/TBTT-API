package tbtt.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tbtt.api.DTO.emprestimo.EmprestimoDados;
import tbtt.api.DTO.emprestimo.EmprestimoDetalhes;
import tbtt.api.model.emprestimo.RealizarEmprestimo;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {

    @Autowired
    private RealizarEmprestimo realizarEmprestimo;

    @PostMapping
    @Transactional
    public ResponseEntity emprestar(@RequestBody @Valid EmprestimoDados dados){

        realizarEmprestimo.emprestar(dados);
        return ResponseEntity.ok(new EmprestimoDetalhes(null, null, null, null));
    }
}
