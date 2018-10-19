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
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private TipoTrabajo tipo;
	
	@ManyToMany(mappedBy = "trabajos")
	@Column(nullable = false)
	Set<Usuario>autores;
	
	@ManyToMany
	@JoinColumn(nullable = false)
	Set<Tematica>temas;

	public Trabajo(int id, TipoTrabajo tipo, Set<Usuario> usuarios, Set<Tematica> tematicas) {
		this.id = id;
		this.tipo = tipo;
		this.autores = usuarios;
		this.temas = tematicas;
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
