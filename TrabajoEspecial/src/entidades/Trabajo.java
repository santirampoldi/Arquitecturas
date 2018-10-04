package entidades;

import java.util.ArrayList;
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
	@Column(nullable = false)
	private TipoTrabajo tipo;
	@ManyToMany(mappedBy = "trabajos")
	@Column(nullable = false)
	ArrayList<Usuario>autores;
	@ManyToMany
	@JoinColumn(nullable = false)
	ArrayList<Tematica>temas;

	public Trabajo(int id, TipoTrabajo tipo, ArrayList<Usuario> autores, ArrayList<Tematica> temas) {
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

	public ArrayList<Usuario> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Usuario> autores) {
		this.autores = autores;
	}

	public ArrayList<Tematica> getTemas() {
		return temas;
	}

	public void setTemas(ArrayList<Tematica> temas) {
		this.temas = temas;
	}

	public int getId() {
		return id;
	}

}
