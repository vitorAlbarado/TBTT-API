package tbtt.api.domain.model.emprestimo.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import tbtt.api.domain.model.emprestimo.EmprestimoDados;
import tbtt.api.domain.Repository.EmprestimoRepository;

public class validaLivroDisponivel {
    @Autowired
    private EmprestimoRepository repository;

    public void validar(EmprestimoDados dados){

    }
}
