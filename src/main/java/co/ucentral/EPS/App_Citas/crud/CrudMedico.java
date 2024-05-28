package co.ucentral.EPS.App_Citas.crud;

import co.ucentral.EPS.App_Citas.dto.MedicoDto;

import java.util.List;

public interface CrudMedico {


    public MedicoDto crear(MedicoDto medicoDto);

    public MedicoDto autenticarPorCedulayContrasenia(String cedula, String contrasenia);
}
