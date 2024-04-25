package co.ucentral.EPS.App_Citas.repositorios;

import co.ucentral.EPS.App_Citas.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
}
