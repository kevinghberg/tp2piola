package entidades;

import javax.persistence.*;

@Entity
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstudiante;

	private String nombres;

	private String apellido;

	private int edad;

	private char genero;

	private int numeroDoc;

	private String ciudadResidencia;

	private int numLibreta;

	public Estudiante() {
	}

	public Estudiante(String nombres, String apellido, int edad, char genero, int numeroDoc, String ciudadResidencia,
			int numLibreta) {
		super();
		this.nombres = nombres;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.numeroDoc = numeroDoc;
		this.ciudadResidencia = ciudadResidencia;
		this.numLibreta = numLibreta;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public int getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(int numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public int getNumLibreta() {
		return numLibreta;
	}

	public void setNumLibreta(int numLibreta) {
		this.numLibreta = numLibreta;
	}

	@Override
	public String toString() {
		return "Estudiante [idEstudiante=" + idEstudiante + ", nombres=" + nombres + ", apellido=" + apellido
				+ ", edad=" + edad + ", genero=" + genero + ", numeroDoc=" + numeroDoc + ", ciudadResidencia="
				+ ciudadResidencia + ", numLibreta=" + numLibreta + ", carreras=" + "]";
	}

}