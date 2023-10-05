package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHorarioAntecedencia {
    public void validar(DadosAgendamentoConsulta dados){
        LocalDateTime dataConsulta = dados.data();
        LocalDateTime agora = LocalDateTime.now();
        long diffMin = Duration.between(agora, dataConsulta).toMinutes();

        if(diffMin < 30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedencia minima de 30 minutos.");
        }
    }
}
