package co.ucentral.EPS.App_Citas.repositorios;

import co.ucentral.EPS.App_Citas.entidades.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioSede extends JpaRepository<Sede, Integer> {

    Sede findByNombre(String nombre);

}
