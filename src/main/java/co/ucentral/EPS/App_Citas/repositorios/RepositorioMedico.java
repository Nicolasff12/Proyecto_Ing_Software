package co.ucentral.EPS.App_Citas.repositorios;

import co.ucentral.EPS.App_Citas.entidades.Medico;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioMedico extends CrudRepository<Medico, Long> {
}
