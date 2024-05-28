package co.ucentral.EPS.App_Citas.controladores;
import co.ucentral.EPS.App_Citas.dto.AfiliadoDto;
import co.ucentral.EPS.App_Citas.dto.CitaDto;
import co.ucentral.EPS.App_Citas.entidades.Afiliado;
import co.ucentral.EPS.App_Citas.entidades.Cita;
import co.ucentral.EPS.App_Citas.entidades.Especialidad;
import co.ucentral.EPS.App_Citas.entidades.Sede;
import co.ucentral.EPS.App_Citas.servicios.ServiciosAfiliado;
import co.ucentral.EPS.App_Citas.servicios.ServiciosCita;
import co.ucentral.EPS.App_Citas.servicios.ServiciosEspecialidad;
import co.ucentral.EPS.App_Citas.servicios.ServiciosSede;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
public class ControladoresCita {


    private final ModelMapper modelMapper = new ModelMapper();

    ServiciosCita serviciosCita;
    ServiciosEspecialidad serviciosEspecialidad;
    ServiciosAfiliado serviciosAfiliado;
    ServiciosSede serviciosSede;

    public ControladoresCita(ServiciosCita serviciosCita, ServiciosEspecialidad serviciosEspecialidad, ServiciosAfiliado serviciosAfiliado,
                             ServiciosSede serviciosSede){
        this.serviciosCita = serviciosCita;
        this.serviciosEspecialidad = serviciosEspecialidad;
        this.serviciosAfiliado = serviciosAfiliado;
        this.serviciosSede = serviciosSede;

    }

    @GetMapping("/principal/afiliado/{codigo}")
    public String listarCitasAfiliado(@PathVariable int codigo, Model model){

        AfiliadoDto afiliadoDto = serviciosAfiliado.buscarPorPk(codigo);

        model.addAttribute("listaCitas", serviciosCita.buscarTodosPorAfiliado(afiliadoDto));
        model.addAttribute("afiliado", afiliadoDto);
        return "afiliado";
    }


    @GetMapping({"/crear/cita/{codigoAfiliado}"})
    public String mostrarFormularioEspecialidadySede(@PathVariable int codigoAfiliado, Model model) {

        CitaDto citaDto = new CitaDto();

        model.addAttribute("listaEspecialidad", serviciosEspecialidad.buscarTodos());
        model.addAttribute("listaSedes", serviciosSede.buscarTodos());
        model.addAttribute("cita", citaDto);
        model.addAttribute("codigoAfiliado", codigoAfiliado);

        return "crearCita";

    }

    @GetMapping("/asignarFecha/cita/{codigoAfiliado}")
    public String mostrarFormularioFecha(@PathVariable int codigoAfiliado, @ModelAttribute("cita") CitaDto citaDto, Model model) {
        Especialidad especialidad = modelMapper.map(serviciosEspecialidad.buscarPorNombre(citaDto.getEspecialidad().getNombre()), Especialidad.class);
        Sede sede = modelMapper.map(serviciosSede.buscarPorNombre(citaDto.getSede().getNombre()), Sede.class);

        LocalDateTime fechaActual = LocalDateTime.now().withHour(8).withMinute(0).withSecond(0).withNano(0);
        List<String> listaFechas = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (int i = 0; i < 30; i++) { // Próximos 30 días
            LocalDateTime inicioDia = fechaActual.plusDays(i).withHour(8);
            LocalDateTime finDia = fechaActual.plusDays(i).withHour(16);

            while (!inicioDia.isAfter(finDia)) {
                if (serviciosCita.buscarCitaPorFechaPorSedePorAfiliadoYEstado(inicioDia, sede.getId_sede(), codigoAfiliado, "Activa") == null) {
                    List<String> listadoFechas = serviciosCita.buscarFechasPorEspecialidadPorSedeYFecha(especialidad.getIdEspecialidad(), sede.getId_sede(), inicioDia);
                    if ((especialidad.getNombre().equalsIgnoreCase("Medicina general") && listadoFechas.size() < 3) ||
                            (!especialidad.getNombre().equalsIgnoreCase("Medicina general") && listadoFechas.size() < 2)) {
                        listaFechas.add(inicioDia.format(formato));
                    }
                }
                inicioDia = inicioDia.plusMinutes(30);
            }
        }

        model.addAttribute("cita", citaDto);
        model.addAttribute("listaFechas", listaFechas);
        model.addAttribute("codigoAfiliado", codigoAfiliado);
        model.addAttribute("especialidad", especialidad);
        model.addAttribute("sede", sede);

        return "asignarFecha";
    }


    @PostMapping({"/citaCreada/cita/{codigoAfiliado}"})
    public String crearCita(@PathVariable int codigoAfiliado, @ModelAttribute("cita") CitaDto citaDto, RedirectAttributes redirectAttributes){

        Especialidad especialidad = modelMapper.map(serviciosEspecialidad.buscarPorNombre(citaDto.getEspecialidad().getNombre()),Especialidad.class);
        Sede sede = modelMapper.map(serviciosSede.buscarPorNombre(citaDto.getSede().getNombre()),Sede.class);

        Afiliado afiliado = modelMapper.map(serviciosAfiliado.buscarPorPk(codigoAfiliado), Afiliado.class);

        citaDto.setEstado("Activa");
        citaDto.setAfiliado(afiliado);
        citaDto.setSede(sede);
        citaDto.setEspecialidad(especialidad);


        serviciosCita.crear(citaDto);

        redirectAttributes.addAttribute("codigo", afiliado.getIdAfiliado());
        return "redirect:/principal/afiliado/{codigo}";
    }

}