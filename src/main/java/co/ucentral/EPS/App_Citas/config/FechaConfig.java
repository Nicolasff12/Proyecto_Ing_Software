package co.ucentral.EPS.App_Citas.config;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class FechaConfig {

    public static String convertirFecha(LocalDateTime fecha) {
        if (fecha == null){
            return "";
        }else{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
            return simpleDateFormat.format(Date.from(fecha.atZone(ZoneId.systemDefault()).toInstant()));
        }
    }
}
