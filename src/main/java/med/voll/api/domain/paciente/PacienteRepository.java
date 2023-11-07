package med.voll.api.domain.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("""
            SELECT p FROM Paciente p WHERE p.id = :id AND p.ativo = true
            """)
    Boolean findAtivoById(Long id);
}
