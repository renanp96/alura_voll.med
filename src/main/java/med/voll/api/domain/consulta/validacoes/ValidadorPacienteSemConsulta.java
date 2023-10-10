package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class ValidadorPacienteSemConsulta implements ValidadorAgendamentoConsultas {
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        LocalDateTime primeiroHorario = dados.data().withHour(7);
        LocalDateTime ultimoHorario = dados.data().withHour(18);
        boolean possuiOutraConsultaDia = repository.existsByPacienteIdData(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if(possuiOutraConsultaDia){
            throw new ValidacaoException("Paciente já possui uma consulta agendada neste dia.");
        }
    }
}
