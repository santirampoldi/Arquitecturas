package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	@ManyToOne
	@JoinColumn(nullable = false)
	private TipoTrabajo tipo;
	@ManyToMany(mappedBy = "trabajos")
	@Column(nullable = false)
	List<Usuario>autores;
	@ManyToMany
	@JoinColumn(nullable = false)
	List<Tematica>temas;

	public Trabajo(int id, TipoTrabajo tipo, List<Usuario> autores, List<Tematica> temas) {
		this.id = id;
		this.tipo = tipo;
		this.autores = autores;
		this.temas = temas;
	}

	public TipoTrabajo getTipo() {
		return tipo;
	}

	public void setTipo(TipoTrabajo tipo) {
		this.tipo = tipo;
	}

	public List<Usuario> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Usuario> autores) {
		this.autores = autores;
	}

	public List<Tematica> getTemas() {
		return temas;
	}

	public void setTemas(ArrayList<Tematica> temas) {
		this.temas = temas;
	}

	public int getId() {
		return id;
	}

}
