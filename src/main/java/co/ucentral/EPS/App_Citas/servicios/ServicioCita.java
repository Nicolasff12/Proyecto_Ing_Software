package co.ucentral.EPS.App_Citas.servicios;

import co.ucentral.EPS.App_Citas.dto.CitaDto;
import co.ucentral.EPS.App_Citas.entidades.Cita;
import co.ucentral.EPS.App_Citas.repositorios.RepositorioCita;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
@AllArgsConstructor
@Service
public class ServicioCita implements Serializable {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private final RepositorioCita repositorioCita;

    public CitaDto registrar(CitaDto citaDto) {
        Cita laCita = repositorioCita.save(modelMapper.map(citaDto, Cita.class));
        return modelMapper.map(laCita, CitaDto.class);
    }

    public List<CitaDto> obtenerCita() {
        TypeToken<List<CitaDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioCita.findAll(), typeToken.getType());
    }

    public CitaDto obtenerCita(long serial) {
        Cita cita = repositorioCita.findById(serial).orElseThrow(null);
        return modelMapper.map(cita, CitaDto.class);
    }

    public CitaDto actualizar(CitaDto citaDto) {
        repositorioCita.save(modelMapper.map(citaDto, Cita.class));
        return citaDto;
    }

    public void eliminar(long serial) {
        repositorioCita.deleteById(serial);
    }

}
