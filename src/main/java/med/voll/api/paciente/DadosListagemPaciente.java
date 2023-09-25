package med.voll.api.paciente;

import med.voll.api.endereco.Endereco;

public record DadosListagemPaciente(String nome, String email, String telefone, String cpf, Boolean ativo) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getAtivo());
    }
}
