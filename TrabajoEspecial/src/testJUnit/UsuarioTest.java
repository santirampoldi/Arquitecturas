package testJUnit;

import entidades.Usuario;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entidades.Lugar;

public class UsuarioTest {
	
	private static Usuario usuario;
	private static Lugar uncpba;
	
	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		System.out.println("Usuario -> setupBeforeClass");
//	}

//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	System.out.println("Usuario -> tearDownAfterClass");
//	}
//
//	@Before
//	public void setUp() throws Exception {
//		System.out.println("Usuario -> Usuario");
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	System.out.println("Usuario -> TearDownUsuario");
//	}
	/**
	 *  
	 */
	@Test
	public void testUsuario() {
	System.out.println("Usuario -> TestUsuario");
	}

	@BeforeClass
	public static void testCreateUsuario() {
		System.out.println("Usuario -> testCreateUsuario");
		uncpba = new Lugar("uncpba", "Tandil");
		assertNotNull(uncpba);
		usuario = new Usuario(36626800, "Agustin", "Meliendrez", uncpba);
		assertNotNull(usuario);
	}

	@Test
	public void testGetDni() {
		int dni = this.usuario.getDni();
		System.out.println("Usuario -> testGetDni -> "+ dni);	
		assertEquals(36626800, dni);
	}
	
	@Test
	public void testGetNombreCompleto() {
		String apellido = this.usuario.getApellido();
		String nombre = this.usuario.getNombre();
		System.out.println("Usuario -> testGetNombreCompleto -> " + apellido + ", " + nombre);		
	}
	
//	@Test
//	public void testGetLugar() {
//		Lugar lugar = this.usuario.getLugar();
//		String nombreLugar = lugar.getNombre();
//		System.out.println("Usuario -> testGetLugar -> " + nombreLugar);		
//	}
//
//	@Test
//	public void testSetInicio() {
//		System.out.println("Usuario -> SetInicio");
//	}
//
//	@Test
//	public void testGetFin() {
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetFin() {
//		//fail("Not yet implemented");
//	}
	
	
}
