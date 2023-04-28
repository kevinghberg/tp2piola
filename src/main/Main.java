package main;

import factory.FactoryEntityManager;
import repository.CarreraRepository;
import repository.EstudianteRepository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import entidades.*;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {

		FactoryEntityManager fem = new FactoryEntityManager();

		CarreraRepository cr = fem.getCarreraRepository();
		EstudianteRepository er = fem.getEstudianteRepository();

		er.agregarEstudiante("Nicolas", "Angiolini", 27, 'M', 39000000, "Necochea", 100);
		er.agregarEstudiante("Cecilia", "Barenbaum", 28, 'F', 18472306, "Mar Del Plata", 101);
		er.agregarEstudiante("Kevin", "Garces", 25, 'M', 39500000, "Necochea", 102);

		cr.agregarCarrera("TUDAI");
		cr.agregarCarrera("TUPAR");

		Carrera ct = cr.obtenerCarreraPorId(1);

		List<Carrera> lc = cr.findAll();

		for (Carrera c : lc) {
			System.out.println(c.getNombre());
		}

		List<Estudiante> le = er.findAll();

		for (Estudiante e : le) {
			System.out.println(e.getNombres() + e.getApellido());
		}

		er.borrarEstudiante(2);

		le = er.findAll();

		for (Estudiante e : le) {
			System.out.println(e.getNombres() + e.getApellido());
		}

		/*
		 * Carrera_Estudiante ce = new Carrera_Estudiante(ct,e1,true,LocalDate.now());
		 * 
		 * cr.agregarEstudianteACarrera(1,1);
		 */

		cr.cerrarRepository();

	}

}
