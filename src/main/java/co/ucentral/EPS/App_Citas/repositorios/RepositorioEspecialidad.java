package co.ucentral.EPS.App_Citas.repositorios;


import co.ucentral.EPS.App_Citas.entidades.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RepositorioEspecialidad extends JpaRepository<Especialidad, Integer> {
    Especialidad findByNombre(String nombre);


}
