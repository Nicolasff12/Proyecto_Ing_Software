package co.ucentral.EPS.App_Citas.repositorios;


import co.ucentral.EPS.App_Citas.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositorioMedico extends JpaRepository<Medico, Integer> {


    @Query(value = "SELECT * FROM MEDICO where med_cedula = ?1 and med_contrasenia = ?2", nativeQuery = true)
    Medico  buscarMedicoPorCedulayContrasenia(String cedula, String contrasenia);

}
