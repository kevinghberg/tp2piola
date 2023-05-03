package dto;

import java.time.LocalDate;

/*Generar un reporte de las carreras, que para cada carrera incluya información de los
 * inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
 los años de manera cronológica.*/

public class ReporteDTO {

	private String nombre;

	private Long cantidadEgresados;

	private Long cantidadInscriptos;

	private LocalDate fecha;

	public ReporteDTO(String nombre, LocalDate fecha, Long cantidadInscriptos) {
		super();
		this.nombre = nombre;
		this.cantidadInscriptos = cantidadInscriptos;
		this.fecha = fecha;
	}

	public ReporteDTO() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCantidadEgresados() {
		return cantidadEgresados;
	}

	public void setCantidadEgresados(long cantidadEgresados) {
		this.cantidadEgresados = cantidadEgresados;
	}

	public long getCantidadInscriptos() {
		return cantidadInscriptos;
	}

	public void setCantidadInscriptos(long cantidadInscriptos) {
		this.cantidadInscriptos = cantidadInscriptos;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
