package entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Lugar {
	
	@Id
	private int id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String ciudad;
	
	@OneToMany
	@JoinColumn
	Set<Usuario>trabajadores;

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

	public void setTrabajadores(HashSet<Usuario> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public Set<Usuario> getTrabajadores() {
		return this.trabajadores;
	}

}
