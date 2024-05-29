/*package co.ucentral.EPS.App_Citas.controladores;


import co.ucentral.EPS.App_Citas.dto.CitaDto;
import co.ucentral.EPS.App_Citas.dto.UsuarioDto;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladorInicio {

    private static final Logger logger = LogManager.getLogger(ControladorInicio.class);

    @Autowired
    ServicioUsuario ServicioUsuario;

    @Autowired
    ServicioCita servicioCita;
    @Autowired
    ServicioMedico servicioMedico;

     //Index -> Donde inicia todo
    @GetMapping({ "/index"})
    public String Inicio(Model model){
        logger.info("Verificando ");
        model.addAttribute("index",ServicioUsuario.obtenerUsuario());
        return "index";
    }
    //MUESTRA EL LOGIN DEL AFILIADO
    @GetMapping("/inicioAfiliado")
    public String accesoAfiliado(Model model){
        UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute("usuario", usuarioDto);
        return "inicioAfiliado";
    }
    //MUESTRA EL LOGIN DEL MEDICO
    @GetMapping("/inicioMedico")
    public String accesoMedico(Model model){
        UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute("usuario", usuarioDto);
        return "inicioMedico";
    }
    //MUESTRA EL PORTAL DEL AFILIADO
    @GetMapping({"/portalAfiliado"})
    public String listarCita   ( Model model){
        logger.info("Verificando ");
        model.addAttribute("cita", servicioCita.obtenerCita());
        return "portalAfiliado";
    }
    //MUESTRA EL PORTAL DEL MEDICO
    @GetMapping({"/portalMedico"})
    public String listaMedico ( Model model){
        logger.info("Verificando ");
        model.addAttribute("cita", servicioCita.obtenerCita());
        return "portalMedico";
    }

    //CREA LA CITA
    @GetMapping("/crearCita")
    public String mostrarTablaLista(Model model){
        CitaDto citaDto = new CitaDto();
        model.addAttribute("Citacrear", citaDto);
        return "crearCita";
    }

    //REGISTRA LA CITA
    @PostMapping("/cita")
    public String registrarCita(@ModelAttribute("Citacrear") CitaDto cita) {
        servicioCita.registrar(cita);
        return "redirect:/portalAfiliado";
    }
    //MUESTRA PARA EDITAR LA CITA
    @GetMapping("/cita/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable int serial, Model model){
            model.addAttribute("Citacrear", servicioCita.obtenerCita(serial));
        return "editarCita";
    }
    //CONSULTA LAS CITAS PROGRAMADAS PARA LE MEDICO
    @GetMapping("/consulta/modificar/{serial}")
    public String mostrarFormularioEditarmedico(@PathVariable int serial, Model model){
        model.addAttribute("Consultacrear",servicioCita.obtenerCita(serial));
        return "editarConsulta";
    }
    //MODIFICA LA CITA  DEL AFILIADO
    @PostMapping("/citas/{serial}")
    public String modificarCita(@PathVariable long serial,@ModelAttribute( "cita") CitaDto citaDto, Model model){
        model.addAttribute("cita", servicioCita.actualizar(citaDto));
        return "redirect:/portalAfiliado";
    }
    //MODIFICA LAS OBSERVACIONES DEL MEDICO
    @PostMapping("/consultas/{serial}")
    public String modificarConsulta(@PathVariable long serial,@ModelAttribute( "cita") CitaDto citaDto, Model model){
        model.addAttribute("cita", servicioCita.actualizar(citaDto));
        return "redirect:/portalMedico";
    }

    //ELIMINA LAS CITAS CREADAS
    @GetMapping("/cita/{serial}")
    public String eliminarCita(@PathVariable int serial){
        servicioCita.eliminar(serial);
        return "redirect:/portalAfiliado";
    }






}
*/