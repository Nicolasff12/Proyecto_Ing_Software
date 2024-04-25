package co.ucentral.EPS.App_Citas.servicios;



import co.ucentral.EPS.App_Citas.dto.UsuarioDto;
import co.ucentral.EPS.App_Citas.entidades.Usuario;
import co.ucentral.EPS.App_Citas.repositorios.RepositorioUsuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioUsuario implements Serializable {

    private ModelMapper modelMapper;

    private final RepositorioUsuario repoUsuario;

    public UsuarioDto registrar(UsuarioDto usuarioDto) {

        Usuario elUsuario = repoUsuario.save(modelMapper.map(usuarioDto, Usuario.class));
        return modelMapper.map(elUsuario, UsuarioDto.class);
    }
    public List<UsuarioDto> obtenerUsuario() {
        TypeToken<List<UsuarioDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoUsuario.findAll(), typeToken.getType());

    }
    public UsuarioDto obtenerPersona(long serial) {
        Usuario usuario = repoUsuario.findById(serial).orElseThrow();
        return modelMapper.map(usuario, UsuarioDto.class);
    }

    public UsuarioDto actualizar(UsuarioDto usuarioDto) {
        repoUsuario.save(modelMapper.map(usuarioDto, Usuario.class));
        return usuarioDto;
    }

    public void eliminar(long serial) {
        repoUsuario.deleteById(serial);
    }


}
