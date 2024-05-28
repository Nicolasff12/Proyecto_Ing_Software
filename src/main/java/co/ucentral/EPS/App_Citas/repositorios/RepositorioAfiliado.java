package co.ucentral.EPS.App_Citas.repositorios;


import co.ucentral.EPS.App_Citas.entidades.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositorioAfiliado extends JpaRepository<Afiliado, Integer> {


    @Query(value = "SELECT * FROM AFILIADO where af_correo = ?1 and af_contrasenia = ?2 ", nativeQuery = true)
    Afiliado buscarCorreolayContrasenia(String correo, String contrasenia);

    @Query(value = "SELECT * FROM AFILIADO where af_cedula = ?1 and af_contrasenia = ?2 ", nativeQuery = true)
    Afiliado buscarrCedulayContrasenia(String cedula, String contrasenia);

}
