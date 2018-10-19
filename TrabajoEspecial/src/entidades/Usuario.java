package entidades;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Usuario {

	@Id
	private int dni;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String apellido;

	@ManyToOne
	@JoinColumn
	private Lugar lugar;

	@ManyToMany
	@JoinColumn
	List<Tematica>temas;

	@ManyToMany
	@JoinTable(
			name = "evaluador_trabajo",
			joinColumns = { @JoinColumn(name = "evaluador_id") },
			inverseJoinColumns = { @JoinColumn(name = "trabajo_id") }
			)
	Set<Trabajo> trabajos;

	public Usuario(int dni, String nombre, String apellido, Lugar lugar) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.lugar = lugar;
		this.trabajos = new HashSet<Trabajo>();
	}

	public int getDni() {return dni;}

	public void setDni(int dni) {this.dni = dni;}

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public String getApellido() {return apellido;}

	public void setApellido(String apellido) {this.apellido = apellido;}

	public Lugar getLugar() {return lugar;}

	public void setLugar(Lugar lugar) {this.lugar = lugar;}
	
	public Set<Trabajo> getTrabajos() {return this.trabajos;}
	
	public void setTrabajos(Set<Trabajo> trabajos) {this.trabajos = trabajos;}
	
	public void addTrabajo(Trabajo trabajo) {this.trabajos.add(trabajo);}

}
