package entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Usuario {

	//--------------Atributos de clase--------------

	@Id
	private int dni;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String apellido;

	@ManyToOne
	@JoinColumn
	private Lugar lugar;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn
	Set<Tematica>temas;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "evaluador_trabajo",
			joinColumns = { @JoinColumn(name = "evaluador_id") },
			inverseJoinColumns = { @JoinColumn(name = "trabajo_id") }
			)
	private Set<Trabajo> trabajosEvaluacion;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "evaluador_trabajoPendiente",
			joinColumns = { @JoinColumn(name = "evaluador_id") },
			inverseJoinColumns = { @JoinColumn(name = "trabajoPendiente_id") }
			)
	private Set<Trabajo> trabajosPendientes;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn
	private Set<Evaluacion> evaluaciones;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "autor_trabajo",
			joinColumns = { @JoinColumn(name = "autor_id") },
			inverseJoinColumns = { @JoinColumn(name = "trabajo_id") }
			)
	private Set<Trabajo> trabajosInvestigacion;

	//--------------Constructor--------------

	public Usuario(int dni, String nombre, String apellido, Lugar lugar) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.lugar = lugar;
		this.temas = new HashSet<Tematica>();
		this.trabajosInvestigacion = new HashSet<Trabajo>();
		this.trabajosPendientes = new HashSet<Trabajo>();
		this.trabajosEvaluacion = new HashSet<Trabajo>();
	}

	public Usuario() {
		this.temas = new HashSet<Tematica>();
		this.trabajosInvestigacion = new HashSet<Trabajo>();
		this.trabajosPendientes = new HashSet<Trabajo>();
		this.trabajosEvaluacion = new HashSet<Trabajo>();
	}

	//--------------toString--------------

	@Override
	public String toString() {
		String tr = "";
		if (!this.trabajosInvestigacion.isEmpty()) {
			tr += ", trabajos de investigacion = ";
			for (Trabajo trabajo : this.trabajosInvestigacion) {
				tr += trabajo.getNombre() + ", ";
				tr += trabajo.getTipo().getNombre() + ".  ";
			}	
		}

		String te = "";
		if (!this.temas.isEmpty()) {
			te += ", temas = ";
			for (Tematica tematica : this.temas) {
				te += tematica.getNombre() + ".  ";
			}	
		}
		String retorno = "Usuario [dni = " + this.dni + ", nombre = " + this.nombre + ", apellido = " + this.apellido + ", lugar = " 
				+ this.lugar.getNombre() + te + tr + "]"; 
		return retorno;
	}

	//--------------Getters y setters--------------

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public void setTrabajosInvestigacion(Set<Trabajo> trabajosInvestigacion) {
		this.trabajosInvestigacion.addAll(trabajosInvestigacion);
	}

	public Set<Trabajo> getTrabajosInvestigacion() {
		return this.trabajosInvestigacion;
	}

	public void setTrabajoInvestigacion(Trabajo trabajo) {
		this.trabajosInvestigacion.add(trabajo);
	}

	public Set<Trabajo> getTrabajosEvaluacion() {
		return this.trabajosEvaluacion;
	}

	public void setTrabajoEvaluacion(Trabajo trabajo) {
		this.trabajosEvaluacion.add(trabajo);
	}

	public Set<Trabajo> getTrabajosPendientes() {
		return this.trabajosPendientes;
	}

	public void setTrabajoPendiente(Trabajo trabajo) {
		this.trabajosPendientes.add(trabajo);
	}

	//--------------Controles y metodos de clase--------------

}
