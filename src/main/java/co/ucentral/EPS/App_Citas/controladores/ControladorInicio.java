package co.ucentral.EPS.App_Citas.controladores;


import co.ucentral.EPS.App_Citas.dto.PersonaDto;
import co.ucentral.EPS.App_Citas.dto.UsuarioDto;
import co.ucentral.EPS.App_Citas.servicios.ServicioPersona;
import co.ucentral.EPS.App_Citas.servicios.ServicioUsuario;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
public class ControladorInicio {

    private static final Logger logger = LogManager.getLogger(ControladorInicio.class);

    @Autowired
    ServicioUsuario ServicioUsuario;

    @GetMapping({ "/index"})
    public String Inicio(Model model){
        logger.info("Verificando ");
        model.addAttribute("index",ServicioUsuario.obtenerUsuario());
        return "index";
    }

    @GetMapping("/inicioAfiliado")
    public String accesoAfiliado(Model model){
        UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute("usuario", usuarioDto);
        return "inicioAfiliado";
    }

    @PostMapping("/index")
    public String registrarAfiliado(@ModelAttribute("usuario") UsuarioDto usuario){
        ServicioUsuario.registrar(usuario);
        return "redirect:/index";
    }



    @GetMapping({ "/inicioMedico"})
    public String accesoMedico(Model model){
        //logger.info("Verificando ");
        //model.addAttribute("index",servicioPersona.obtenerPersona());
        return "inicioMedico";
    }



}
