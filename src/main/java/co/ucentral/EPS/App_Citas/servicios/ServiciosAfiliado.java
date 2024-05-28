package co.ucentral.EPS.App_Citas.servicios;

import co.ucentral.EPS.App_Citas.crud.CrudAfiliado;
import co.ucentral.EPS.App_Citas.dto.AfiliadoDto;
import co.ucentral.EPS.App_Citas.entidades.Afiliado;
import co.ucentral.EPS.App_Citas.repositorios.RepositorioAfiliado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ServiciosAfiliado implements CrudAfiliado {

    private final ModelMapper modelMapper = new ModelMapper();

    RepositorioAfiliado repositorioAfiliado;

    public ServiciosAfiliado(RepositorioAfiliado repositorioAfiliado){
        this.repositorioAfiliado = repositorioAfiliado;
    }

    @Override
    public AfiliadoDto crear(AfiliadoDto afiliadoDto){

        if(afiliadoDto != null){
            Afiliado afiliado = repositorioAfiliado.save(modelMapper.map(afiliadoDto, Afiliado.class));
            return modelMapper.map(afiliado, AfiliadoDto.class);
        }else {
            return null;
        }
    }

    @Override
    public AfiliadoDto AutenticarCedulayContraseniaa(String cedula, String contrasenia){
        Afiliado afiliado =repositorioAfiliado.buscarrCedulayContrasenia(cedula, contrasenia);

        if(afiliado != null){
            return modelMapper.map(afiliado, AfiliadoDto.class);
        }else{
            return  null;
        }
    }


    @Override
    public AfiliadoDto AutenticarCorreoyContraseniaa(String correo, String contrasenia){
        Afiliado afiliado =repositorioAfiliado.buscarCorreolayContrasenia(correo, contrasenia);

        if(afiliado != null){
            return modelMapper.map(afiliado, AfiliadoDto.class);
        }else{
            return  null;
        }
    }

    @Override
    public AfiliadoDto buscarPorPk(int pkEntidad) {
        return modelMapper.map(repositorioAfiliado.findById(pkEntidad).orElse(null), AfiliadoDto.class);
    }




}
