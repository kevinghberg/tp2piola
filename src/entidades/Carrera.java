package entidades;


import java.util.List;

import javax.persistence.*;

@Entity
public class Carrera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_carrera;

	private String nombre;
	
    @OneToMany(mappedBy = "carrera", cascade=CascadeType.ALL, orphanRemoval=true)
    List<Carrera_Estudiante> estudiantes;

	public Carrera() {
	}

	public Carrera(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public List<Carrera_Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Carrera_Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
}
