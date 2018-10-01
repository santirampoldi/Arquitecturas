package entidades;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Trabajo {
	
	@Id
	private int id;
	@Column
	private TipoTrabajo tipo;
	@ManyToMany
	@JoinColumn(nullable = false)
	ArrayList<Usuario>autores;
	@ManyToMany
	@JoinColumn(nullable = false)
	ArrayList<Tematica>temas;
	
	

}
