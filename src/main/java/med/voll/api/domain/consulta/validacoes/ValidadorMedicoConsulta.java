package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorMedicoConsulta {
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        boolean medicoPossuiConsulta = repository.existsByMedicoIdData(dados.idMedico(), dados.data());
        if(medicoPossuiConsulta){
            throw new ValidacaoException("Medico já possui consulta agendada nesse mesmo horario");
        }
    }
}
