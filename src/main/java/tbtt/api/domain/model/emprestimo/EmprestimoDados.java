package tbtt.api.domain.model.emprestimo;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record EmprestimoDados(
        @NotNull
        Long idAluno,
        @NotNull
        Long idLivro,
        @NotNull
        LocalDateTime data,
        int prazo
) {
        public EmprestimoDados(Emprestimo dados){
                this(dados.getAluno().getId(),dados.getLivro().getId(),dados.getData(), dados.getPrazo());
        }
}
