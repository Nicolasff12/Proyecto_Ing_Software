package co.ucentral.EPS.App_Citas.controladores;

import co.ucentral.EPS.App_Citas.dto.AfiliadoDto;
import co.ucentral.EPS.App_Citas.dto.CitaDto;
import co.ucentral.EPS.App_Citas.servicios.ServiciosAfiliado;
import co.ucentral.EPS.App_Citas.servicios.ServiciosCita;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class ControladoresAfiliado {


    ServiciosAfiliado serviciosAfiliado;

    public ControladoresAfiliado(ServiciosAfiliado serviciosAfiliado){
        this.serviciosAfiliado = serviciosAfiliado;
    }

    @GetMapping({"/afiliado/autenticar"})
    public String VerAutenticar(@RequestParam(value = "error", required = false) String error, Model model){

        AfiliadoDto afiliadoDto = new AfiliadoDto();

        model.addAttribute("afiliado", afiliadoDto);

        if (error != null) {
            model.addAttribute("loginError", true);
        }

        return "inicioAfiliado";
    }

    @PostMapping("/afiliado")
    public String VerAutenticar(@ModelAttribute("afiliado") AfiliadoDto afiliadoDto, Model model, RedirectAttributes redirectAttributes){

        AfiliadoDto afiliadoDto1 = serviciosAfiliado.AutenticarCedulayContraseniaa(afiliadoDto.getCedula(), afiliadoDto.getContrasenia());


        if (afiliadoDto1 != null) {
            redirectAttributes.addAttribute("codigo",afiliadoDto1.getIdAfiliado());
            return "redirect:/principal/afiliado/{codigo}";
        }else{
            AfiliadoDto afiliadoDto2 = serviciosAfiliado.AutenticarCorreoyContraseniaa(afiliadoDto.getCorreo(), afiliadoDto.getContrasenia());

            if(afiliadoDto2 != null){
                redirectAttributes.addAttribute("codigo",afiliadoDto2.getIdAfiliado());
                return "redirect:/principal/afiliado/{codigo}";
            }else{
                redirectAttributes.addFlashAttribute("ERROR",true);
                return "redirect:/afiliado/autenticar";
            }
        }
    }
}