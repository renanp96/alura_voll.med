package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        boolean pacienteAtivo = repository.findByPacienteAtivo(dados.idPaciente());
        if(!pacienteAtivo){
            throw new ValidacaoException("Consulta não pode ser efetuada com um paciente inativo.");
        }
    }
}
