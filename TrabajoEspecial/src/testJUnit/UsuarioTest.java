package testJUnit;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import entidades.Lugar;
import entidades.Usuario;
import entidades.Trabajo;

public class UsuarioTest {
	
	private static Usuario usuario;
	private static Lugar uncpba;
	private static Trabajo trabajo;
	
	@Test
	public void testUsuario() {
	System.out.println("Usuario -> TestUsuario");
	}
	
	@BeforeClass
	public static void testCreateLugarParaUsuario() {
		uncpba = new Lugar("UNCPBA", "Tandil");
		assertNotNull(uncpba);
	}
	
	@BeforeClass
	public static void testCreateTrabajoParaUsuario(){
		
	}

	@BeforeClass
	public static void testCreateUsuario() {
		usuario = new Usuario(36626800, "Agustin", "Meliendrez", uncpba);
		assertNotNull(usuario);
	}

	@Test
	public void testGetDni() {
		int dni = usuario.getDni();
		assertEquals(36626800, dni);
	}
	
	@Test
	public void testGetNombre() {
		String nombre = usuario.getNombre();
		assertEquals("Agustin", nombre);
	}
	
	@Test
	public void testGetApellido() {
		String apellido = usuario.getApellido();
		assertEquals("Meliendrez", apellido);
	}
	
	@Test
	public void testGetLugarDeTrabajo(){
		String lugar = usuario.getLugar().getNombre();
		assertEquals("UNCPBA", lugar);
	}
}
