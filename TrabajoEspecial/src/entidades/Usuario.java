package entidades;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Usuario{

	@Id
	private int dni;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellido;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Lugar lugar;
	@ManyToMany
	@JoinColumn(nullable = false)
	ArrayList<Tematica>temas;
	@ManyToMany
	@JoinColumn(nullable = false)
	ArrayList<Trabajo>trabajos;

	public Usuario(int dni, String nombre, String apellido, Lugar lugar) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.lugar = lugar;
	}

	public int getDni() {return dni;}

	public void setDni(int dni) {this.dni = dni;}

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public String getApellido() {return apellido;}

	public void setApellido(String apellido) {this.apellido = apellido;}

	public Lugar getLugar() {return lugar;}

	public void setLugar(Lugar lugar) {this.lugar = lugar;}

}
