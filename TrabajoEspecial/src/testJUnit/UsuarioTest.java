package testJUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entidades.Lugar;
import entidades.Usuario;

public class UsuarioTest {
	
	Usuario usuario;
	Lugar uncpba;

	@BeforeClass
	public void createUsuario(){
		this.uncpba = new Lugar("uncpba", "Tandil");
		this.usuario = new Usuario(36626800, "Agustin", "Meliendrez", uncpba);
	}
	
	@Test
	public void comprobarNombreCompleto(){
		String nombre = this.usuario.getNombre();
		assertEquals(nombre, "Agustin");
		String apellido = this.usuario.getApellido();
		assertEquals(apellido, "Meliendrez");
	}
	
	@Test
	public void comprobarDNI(){
		int dni = this.usuario.getDni();
		assertEquals(dni, 36626800);
	}
	
}
