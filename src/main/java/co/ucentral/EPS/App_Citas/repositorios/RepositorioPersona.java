package co.ucentral.EPS.App_Citas.repositorios;

import co.ucentral.EPS.App_Citas.entidades.Persona;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioPersona extends CrudRepository<Persona, Long> {
}
