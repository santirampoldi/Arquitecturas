package entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Trabajo {

	@Id
	private int id;

	@Column(nullable = false)
	private String nombre;

	@ManyToOne
	@JoinColumn(nullable = false)
	private TipoTrabajo tipo;

	@ManyToMany(mappedBy = "trabajos")
	@Column(nullable = false)
	Set<Usuario>autores;

	@ManyToMany
	@JoinColumn(nullable = false)
	Set<Tematica>temas;

	public Trabajo(int id, String nombre, TipoTrabajo tipo, Set<Usuario> usuarios, Set<Tematica> tematicas) {
		this.nombre = nombre;
		this.id = id;
		this.tipo = tipo;
		this.autores = usuarios;
		this.temas = tematicas;
	}

	@Override
	public String toString() {
		String a = "";
		for (Usuario usuario : this.autores) {
			a += usuario.getNombre() + ", ";
			a += usuario.getApellido() + ".  ";
		}

		String t = "";
		for (Tematica tematica : this.temas) {
			a += tematica.getNombre() + ".  ";
		}

		String retorno = "Lugar [id = " + this.id + ", nombre = " + this.nombre + ", tipo = " + this.tipo.getNombre() + ", autores = " + a + ", tematicas = " + t + "]";
		return retorno; 
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoTrabajo getTipo() {
		return tipo;
	}

	public void setTipo(TipoTrabajo tipo) {
		this.tipo = tipo;
	}

	public Set<Usuario> getAutores() {
		return autores;
	}

	public void setAutores(HashSet<Usuario> autores) {
		this.autores = autores;
	}

	public Set<Tematica> getTemas() {
		return temas;
	}

	public void setTemas(HashSet<Tematica> temas) {
		this.temas = temas;
	}

	public int getId() {
		return id;
	}

}
