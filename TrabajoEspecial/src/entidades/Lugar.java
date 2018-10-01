package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lugar{
	@Id
	private int id;
	@Column(nullable = false)
	private String nombre;
	@Column (nullable = false)
	private String ciudad;

	public Lugar(int id, String nombre, String ciudad) {
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
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
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
