package co.ucentral.EPS.App_Citas.repositorios;

import co.ucentral.EPS.App_Citas.entidades.Cita;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioCita extends CrudRepository<Cita, Long> {
}
