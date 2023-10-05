package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ValidadorHorarioFuncionamento {
    public void validar(DadosAgendamentoConsulta dados) {
        LocalDateTime dataConulta = dados.data();
        Boolean domingo = dataConulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        Boolean aberturaClinica = dataConulta.getHour() < 7;
        Boolean encerramentoClinica = dataConulta.getHour() > 18;

        if(domingo || aberturaClinica || encerramentoClinica){
            throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica!");
        }
    }
}
