package co.ucentral.EPS.App_Citas.repositorios;

import co.ucentral.EPS.App_Citas.dto.CitaDto;
import co.ucentral.EPS.App_Citas.entidades.Afiliado;
import co.ucentral.EPS.App_Citas.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RepositorioCita extends JpaRepository<Cita, Integer> {


    public List<Cita> findAllByAfiliado(Afiliado afiliado);

    public List<Cita> findAllByFecha(LocalDateTime fecha);

    @Query(value = "SELECT * FROM cita WHERE cita_fecha = :fecha AND sede_id = :idSede AND af_id = :idAfiliado AND cita_estado = :estado", nativeQuery = true)
    public Cita findCitaByFechaBySedeByAfiliadoAndEstado(@Param("fecha") LocalDateTime fecha, @Param("idSede") int idSede, @Param("idAfiliado") int idAfiliado, @Param("estado") String estado);

    @Query(value = "SELECT cita_fecha FROM cita WHERE es_id = :idEspecialidad AND sede_id = :idSede AND cita_fecha = :fecha", nativeQuery = true)
    public List<String> findFechasByEspecialidadBySedeAndFecha(@Param("idEspecialidad") int idEspecialidad, @Param("idSede") int idSede, @Param("fecha") LocalDateTime fecha);




}
