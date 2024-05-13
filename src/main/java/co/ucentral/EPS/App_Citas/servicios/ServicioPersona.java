package co.ucentral.EPS.App_Citas.servicios;

import co.ucentral.EPS.App_Citas.dto.PersonaDto;
import co.ucentral.EPS.App_Citas.dto.UsuarioDto;
import co.ucentral.EPS.App_Citas.entidades.Persona;
import co.ucentral.EPS.App_Citas.repositorios.RepositorioPersona;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioPersona implements Serializable {

    private ModelMapper modelMapper;

    private final RepositorioPersona repoPersona;

    public PersonaDto registrar(PersonaDto personaDto) {

        Persona laPersona = repoPersona.save(modelMapper.map(repoPersona, Persona.class));
        return modelMapper.map(laPersona, PersonaDto.class);
    }

    public List<PersonaDto> obtenerPersona() {
        TypeToken<List<PersonaDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoPersona.findAll(), typeToken.getType());
    }

    public PersonaDto obtenerPersona(long serial) {
        Persona persona = repoPersona.findById(serial).orElseThrow();
        return modelMapper.map(persona, PersonaDto.class);
    }

    public PersonaDto actualizar(PersonaDto personaDto) {
        repoPersona.save(modelMapper.map(personaDto, Persona.class));
        return personaDto;
    }

    public void eliminar(long serial) {
        repoPersona.deleteById(serial);
    }

}
