package dto;

public class CarreraInscriptosDTO {
	private String nombre;
	private Long cantidadInscriptos;

	public CarreraInscriptosDTO() {
	}

	public CarreraInscriptosDTO(String nombre, Long cantidadInscriptos) {
		this.nombre = nombre;
		this.cantidadInscriptos = cantidadInscriptos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCantidadInscriptos() {
		return cantidadInscriptos;
	}

	public void setCantidadInscriptos(Long cantidadInscriptos) {
		this.cantidadInscriptos = cantidadInscriptos;
	}

}
