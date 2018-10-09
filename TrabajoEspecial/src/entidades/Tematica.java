package entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tematica {
	
	@Id
	private int id;
	@Column (nullable = false)
	private String nombre;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn (nullable = false)
	private TipoConocimiento tipo;
	
	public Tematica(int id, String nombre, TipoConocimiento tipo) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public TipoConocimiento getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoConocimiento tipo) {
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}
	
}
