package co.ucentral.EPS.App_Citas.controladores;

import co.ucentral.EPS.App_Citas.dto.*;
import co.ucentral.EPS.App_Citas.servicios.ServiciosMedico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ControladoresMedico {


    ServiciosMedico serviciosMedico;

    public ControladoresMedico(ServiciosMedico serviciosMedico){
        this.serviciosMedico = serviciosMedico;
    }


    @GetMapping({"/medico/autenticar"})
    public String VerAutenticar(@RequestParam(value = "error", required = false) String error, Model model){

        MedicoDto medicoDto = new MedicoDto();

        model.addAttribute("medico", medicoDto);

        if (error != null) {
            model.addAttribute("loginError", true);

        }

        return "inicioMedico";
    }

    @PostMapping("/medico")
    public String VerAutenticar(@ModelAttribute("medico") MedicoDto medicoDto, Model model, RedirectAttributes redirectAttributes){

        MedicoDto medicoDto1 = serviciosMedico.autenticarPorCedulayContrasenia(medicoDto.getCedula(), medicoDto.getContrasenia());

        if(medicoDto1 != null){
            model.addAttribute("medico", medicoDto1);
            return "medico";
        }else{

            redirectAttributes.addFlashAttribute("ERROR", true);
            return "redirect:/medico/autenticar";
        }
    }
}