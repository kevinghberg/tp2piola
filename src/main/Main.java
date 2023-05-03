package main;

import factory.FactoryEntityManager;
import repository.CarreraRepository;
import repository.Carrera_Estudiante_Repository;
import repository.EstudianteRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.persistence.*;

import dto.CarreraInscriptosDTO;
import dto.ReporteDTO;
import entidades.*;

public class Main {

	public static void main(String[] args) {

		FactoryEntityManager fem = new FactoryEntityManager();

		CarreraRepository cr = fem.getCarreraRepository();
		EstudianteRepository er = fem.getEstudianteRepository();
		Carrera_Estudiante_Repository cer = fem.getCarreraEstudianteRepository();

		cr.agregarCarrera("TUDAI");
		cr.agregarCarrera("TUPAR");

		// a) dar de alta un estudiante
		er.agregarEstudiante("Nicolas", "Angiolini", 27, 'M', 39000000, "Necochea", 100);
		er.agregarEstudiante("Cecilia", "Barenbaum", 28, 'F', 18472306, "Mar Del Plata", 101);
		er.agregarEstudiante("Kevin", "Garces", 25, 'M', 39500000, "Necochea", 102);

		// b) matricular un estudiante en una carrera
		Estudiante e1 = er.obtenerEstudiantePorId(1);
		Estudiante e2 = er.obtenerEstudiantePorId(2);
		Estudiante e3 = er.obtenerEstudiantePorId(3);

		Carrera c1 = cr.obtenerCarreraPorId(1);
		Carrera c2 = cr.obtenerCarreraPorId(2);

		cer.agregarRelacionEstudianteCarrera(c1, e1, true, LocalDate.now().minus(Period.ofDays(1)));
		cer.agregarRelacionEstudianteCarrera(c1, e2, false, LocalDate.now().minus(Period.ofDays(2)));
		cer.agregarRelacionEstudianteCarrera(c1, e3, false, LocalDate.now().minus(Period.ofDays(1)));

		cer.agregarRelacionEstudianteCarrera(c2, e2, false, LocalDate.now().minus(Period.ofDays(1)));

		// c) recuperar todos los estudiantes, y especificar algún criterio de
		// ordenamiento simple.
		List<Estudiante> listaOrdenada = er.buscarTodosEstudiantesOrdenado("DESC");

		// d) recuperar un estudiante, en base a su número de libreta universitaria.
		Estudiante e4 = er.buscarPorNumeroLibreta(100);

		// e) recuperar todos los estudiantes, en base a su género.
		List<Estudiante> le = er.buscarEstudiantePorGenero('M');

		// f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad
		// de inscriptos.

		List<CarreraInscriptosDTO> lci = cr.buscarCarrerasConEstudiantesOrdenadoPorCantidad();

		cr.cerrarRepository();

	}

}
