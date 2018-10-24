package entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoTrabajo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column (nullable = false)
	private String nombre;

	public TipoTrabajo(String nombre) {
		this.nombre = nombre;
	}
	
	public TipoTrabajo() {
	}
	
	@Override
	public String toString() {
		return "TipoTrabajo [id = " + id + ", nombre = " + nombre + "]";
	}

	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
