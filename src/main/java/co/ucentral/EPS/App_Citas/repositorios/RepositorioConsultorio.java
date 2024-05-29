package co.ucentral.EPS.App_Citas.repositorios;

import co.ucentral.EPS.App_Citas.dto.ConsultorioDto;
import co.ucentral.EPS.App_Citas.entidades.Consultorio;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioConsultorio extends CrudRepository<Consultorio, Integer> , JpaSpecificationExecutor<Consultorio> {

    Consultorio findByIdConsultorio(int idConsultorio);

}
