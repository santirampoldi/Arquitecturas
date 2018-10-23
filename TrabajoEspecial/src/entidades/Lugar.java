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
		this.trabajadores = new HashSet<Usuario>();
	}

	@Override
	public String toString() {
		String nombres = "";
		if (!this.trabajadores.isEmpty()) {
			nombres += ", trabajadores = ";
			for (Usuario usuario : this.trabajadores) {
				nombres += usuario.getNombre() + ", ";
				nombres += usuario.getApellido() + ".  ";
			}
		}
		String retorno = "Lugar [id = " + this.id + ", nombre = " + this.nombre + ", ciudad = " + this.ciudad 
				+ nombres + "]";
		return retorno; 
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
