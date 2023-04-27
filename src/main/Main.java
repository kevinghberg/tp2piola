package main;

import factory.FactoryEntityManager;
import repository.CarreraRepository;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import entidades.*;

public class Main {

	public static void main(String[] args) {
		
		FactoryEntityManager fem = new FactoryEntityManager();

		CarreraRepository cr = fem.getCarreraRepository();

		Carrera carr1 = new Carrera("TUDAI");

		/*Estudiante e1 = new Estudiante("Nicolas", "Angiolini", 27, 'M', 3900000, "Necochea", 123456);*/

		cr.agregarCarrera(carr1);
			
		/*Carrera_Estudiante ce = new Carrera_Estudiante(carr1,e1,true,LocalDate.now());*/
		
		System.out.println(cr.obtenerCarrera(1));
		
	}

}
