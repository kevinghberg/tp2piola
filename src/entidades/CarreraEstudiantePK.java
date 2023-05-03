package entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@SuppressWarnings("serial")
@Embeddable
public class CarreraEstudiantePK implements Serializable{

	private int idEstudiante;
	
	private int idCarrera;
	
	public CarreraEstudiantePK(int idEstudiante, int idCarrera) {
		super();
		this.idEstudiante = idEstudiante;
		this.idCarrera = idCarrera;
	}
	
	public CarreraEstudiantePK() {};

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCarrera, idEstudiante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarreraEstudiantePK other = (CarreraEstudiantePK) obj;
		return idCarrera == other.idCarrera && idEstudiante == other.idEstudiante;
	}


}
