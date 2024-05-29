package co.ucentral.EPS.App_Citas.crud;

import co.ucentral.EPS.App_Citas.dto.AfiliadoDto;

public interface CrudAfiliado {

    public AfiliadoDto crear(AfiliadoDto afiliadoDto);
    public AfiliadoDto AutenticarCedulayContraseniaa(String cedula, String contrasenia);

    public AfiliadoDto AutenticarCorreoyContraseniaa(String correo, String contrasenia);
    public AfiliadoDto buscarPorPk(int pkEntidad);
}
