package co.ucentral.EPS.App_Citas;

import co.ucentral.EPS.App_Citas.entidades.*;
import co.ucentral.EPS.App_Citas.repositorios.*;
import co.ucentral.EPS.App_Citas.servicios.ServiciosMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class AppCitasApplication implements CommandLineRunner {


	RepositorioMedico repositorioMedico;
	RepositorioAfiliado repositorioAfiliado;
	RepositorioConsultorio repositorioConsultorio;
	RepositorioEspecialidad repositorioEspecialidad;
	RepositorioSede repositorioSede;

	public AppCitasApplication(RepositorioMedico repositorioMedico, RepositorioAfiliado repositorioAfiliado, RepositorioConsultorio
							   repositorioConsultorio, RepositorioEspecialidad repositorioEspecialidad, RepositorioSede repositorioSede){

		this.repositorioMedico = repositorioMedico;
		this.repositorioAfiliado = repositorioAfiliado;
		this.repositorioConsultorio = repositorioConsultorio;
		this.repositorioEspecialidad = repositorioEspecialidad;
		this.repositorioSede = repositorioSede;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppCitasApplication.class, args);
		System.out.println("Carga Informacion");
	}

	@Override
	public void run(String... args) throws Exception {



		Sede sede1 = new Sede(0,"Centro","Carrera 10 #19-45, Bogotá, Cundinamarca",4);
		repositorioSede.save(sede1);
		Sede sede2 = new Sede(0,"Sur","Carrera 10 #19-45, Bogotá, Cundinamarca",4);
		repositorioSede.save(sede2);
		Sede sede3 = new Sede(0,"Norte","Carrera 10 #19-45, Bogotá, Cundinamarca",4);
		repositorioSede.save(sede3);
		Sede sede4 = new Sede(0,"Oriente","Carrera 10 #19-45, Bogotá, Cundinamarca",4);
		repositorioSede.save(sede4);
		Sede sede5 = new Sede(0,"Occidente","Carrera 10 #19-45, Bogotá, Cundinamarca",4);
		repositorioSede.save(sede5);


		Especialidad especialidad1 = new Especialidad();
		especialidad1.setNombre("Medigo General");
		repositorioEspecialidad.save(especialidad1);

		Especialidad especialidad2 = new Especialidad();
		especialidad2.setNombre("Odontologia");
		repositorioEspecialidad.save(especialidad2);

		Especialidad especialidad3 = new Especialidad();
		especialidad3.setNombre("Ginecologia");
		repositorioEspecialidad.save(especialidad3);

		Especialidad especialidad4 = new Especialidad();
		especialidad4.setNombre("Pediatria");
		repositorioEspecialidad.save(especialidad4);

		Especialidad especialidad5 = new Especialidad();
		especialidad5.setNombre("Otorrino");
		repositorioEspecialidad.save(especialidad5);

		Consultorio consultorio1 = new Consultorio(1,"Medigo General",sede1);
		repositorioConsultorio.save(consultorio1);
		Consultorio consultorio2 = new Consultorio(2,"Odontologia",sede2);
		repositorioConsultorio.save(consultorio2);
		Consultorio consultorio3 = new Consultorio(3,"Ginecologia",sede3);
		repositorioConsultorio.save(consultorio3);
		Consultorio consultorio4 = new Consultorio(4,"Pediatria",sede4);
		repositorioConsultorio.save(consultorio4);
		Consultorio consultorio5 = new Consultorio(5,"Otorrino",sede5);
		repositorioConsultorio.save(consultorio5);

		String estadoLibre = "Libre";
		String estadoOcupado = "ocupado";

		repositorioMedico.save(new Medico(0,"Nicolas Fonseca",23,estadoLibre,"101001562","123",sede3,especialidad3));
		repositorioMedico.save(new Medico(0,"juan",28,estadoOcupado,"101001563","123",sede5,especialidad2));

		String estadoAfiliado = "Libre";
		repositorioAfiliado.save(new Afiliado(0,"Paula Cespedes","paula@gmail.com",25,"1000494100",estadoAfiliado,"123"));
		repositorioAfiliado.save(new Afiliado(0,"Jorge","jorge@gmail.com",32,"1002564851",estadoAfiliado,"123"));





	}
}
