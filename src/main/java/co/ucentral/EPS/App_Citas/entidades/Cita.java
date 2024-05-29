package co.ucentral.EPS.App_Citas.entidades;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cita")
@ToString
@Builder

public class Cita  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CITA_REL")
    @SequenceGenerator(name = "SEQ_CITA_REL", sequenceName = "SEQ_CITA_REL", allocationSize = 1)

    @Column(name = "CITA_ID", nullable = false)
    private int idCita;

    @Column(name = "CITA_ESTADO", nullable = false)
    private String estado;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "CITA_FECHA", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "CITA_HORAINICIO", nullable = true)
    private LocalTime horaInicio;

    @ManyToOne
    @JoinColumn(name = "MED_ID")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "SEDE_ID")
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "ES_ID")
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "AF_ID")
    private Afiliado afiliado;



    public void setFecha(int anio, int mes, int dia, int hora, int minuto ) {
        this.fecha = LocalDateTime.of(anio,mes,dia, hora, minuto);
    }

    public void setHoraInicio(int hora, int minuto) {
        this.horaInicio = LocalTime.of(hora, minuto);
    }

}
