package med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByMedicoIdData(Long idMedico, LocalDateTime data);

    boolean existsByPacienteIdData(Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
