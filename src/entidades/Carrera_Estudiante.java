package entidades;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Carrera_Estudiante {

	@EmbeddedId
	private CarreraEstudiantePK id = new CarreraEstudiantePK();;

	@ManyToOne
	@MapsId("idEstudiante")
	@JoinColumn(name = "id_estudiante")
	private Estudiante estudiante;

	@ManyToOne
	@MapsId("idCarrera")
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;

	public boolean graduado = false;

	public LocalDate fechaIngreso;

	public Carrera_Estudiante() {
	};

	public Carrera_Estudiante(Carrera carrera, Estudiante estudiante, boolean graduado, LocalDate localDate) {
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.graduado = graduado;
		this.fechaIngreso = localDate;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public boolean isGraduado() {
		return graduado;
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}

	public LocalDate getAntiguedad() {
		return fechaIngreso;
	}

	public void setAntiguedad(LocalDate antiguedad) {
		this.fechaIngreso = antiguedad;
	}

}
