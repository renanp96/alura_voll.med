package med.voll.api.domain.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("""
            SELECT p.ativo
            FROM Paciente
            WHERE p.id = :id
            """)
    boolean findByPacienteAtivo(Long id);
}
