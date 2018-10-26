package testJUnit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.LugarDAO;
import dao.UsuarioDAO;
import dao.TematicaDAO;
import entidades.Lugar;
import entidades.Usuario;
import entidades.Tematica;


@FixMethodOrder(MethodSorters.JVM)
public class UsuarioTest {
	
	private static LugarDAO lugarDAO;
	private static Lugar uncpba;
	private static Lugar unlp;
	private static TematicaDAO tematicaDAO;
	private static UsuarioDAO usuarioDAO;
	private static Usuario usuario;
	private static Usuario usuarioBBDD;
	
	@BeforeClass
	public static void setUpEnviroment(){
		System.out.println("UsuarioTest-> Comienza el test");
		System.out.println("UsuarioTest-> Se prepara el ambiente");

		lugarDAO = LugarDAO.getInstance();
		tematicaDAO = TematicaDAO.getInstance();
		uncpba = new Lugar("UNCPBA", "Tandil");
		assertNotNull(uncpba);
		unlp = new Lugar("UNLP", "La Plata");
		assertNotNull(unlp);
		usuarioDAO = UsuarioDAO.getInstance();
		usuario = new Usuario(37994753, "Agustin", "Meliendrez", uncpba);
		assertNotNull(usuario);
		
		Tematica tema = new Tematica("Inteligencia Artificial", true);
		usuario.setTema(tema);
	
		
		tematicaDAO.persist(tema);
		lugarDAO.persist(uncpba);
		lugarDAO.persist(unlp);
		usuarioDAO.persist(usuario);
		usuarioBBDD = usuarioDAO.getFirst();
		assertNotNull(usuarioBBDD);
	}
	
	@Test
	public void testCrearNuevoUsuario(){
		System.out.println("UsuarioTest-> Se crea nuevo usuario");

		Usuario nuevoUsuario = new Usuario(19284673, "Rampoldi", "Santiago", uncpba);
		assertNotNull(nuevoUsuario);
		usuarioDAO.persist(nuevoUsuario);
		int cantidadUsuarios = usuarioDAO.getCantidadUsuarios();
		assertEquals(12, cantidadUsuarios);
	}

	@Test
	public void testCompararNombreUsuario() {
		System.out.println("UsuarioTest-> Se compara el nombre correcto del usuario");
		assertEquals("Santiago", usuarioBBDD.getNombre());
	}
	
	@Test
	public void testCompararNombreUsuarioErroneo() {
		System.out.println("UsuarioTest-> Se compara el nombre incorrecto del usuario");
		assertNotEquals("Jorge", usuarioBBDD.getNombre());
	}
	
	@Test
	public void testCompararApellidoUsuario() {
		System.out.println("UsuarioTest-> Se compara el apellido correcto del usuario");
		assertEquals("Rampoldi", usuarioBBDD.getApellido());
	}
	
	@Test
	public void testCompararApellidoErroneo() {
		System.out.println("UsuarioTest-> Se compara el apellido incorrecto del usuario");
		assertNotEquals("Rodriguez", usuarioBBDD.getApellido());
	}
	
	@Test
	public void testCompararDniUsuario() {
		System.out.println("UsuarioTest-> Se compara el DNI correcto del usuario");
		assertEquals(41313351, usuarioBBDD.getDni());
	}
	
	@Test
	public void testCompararDniUsuarioErroneo() {
		System.out.println("UsuarioTest-> Se compara el DNI incorrecto del usuario");
		assertNotEquals(11222333, usuarioBBDD.getDni());
	}
	
	@Test
	public void testCompararLugarUsuario() {
		System.out.println("UsuarioTest-> Se compara el lugar correcto del usuario");
		assertEquals("UNCPBA", usuarioBBDD.getLugar().getNombre());
	}
	
	@Test
	public void testCompararLugarUsuarioErroneo() {
		System.out.println("UsuarioTest-> Se compara el lugar incorrecto del usuario");
		assertNotEquals("UNLP", usuarioBBDD.getLugar().getNombre());
	}
	
	@Test
	public void esUsuarioExperto(){
		System.out.println("UsuarioTest-> Se comprueba si es un usuario experto");
		assertTrue(usuarioDAO.esExperto(37994753));
	}
	
	@Test
	public void esUsuarioEspertoErroneo(){
		System.out.println("UsuarioTest-> Se comprueba que no sea un usuario experto");

		assertFalse(!usuarioDAO.esExperto(37994753));
	}
	
	@Test
	public void testMostrarDatosDeUsuario(){
		System.out.println("UsuarioTest-> Se imprime los datos completos de un usuario");
		Usuario u = usuarioDAO.findById(37994753);
		System.out.println(u.toString());
	}
	
	@Test
	public void testCrearDiezUsuarios(){
		System.out.println("UsuarioTest-> Se crean diez usuarios");
		
		Usuario usuario1 = new Usuario(88477293, "Tim", "Berners-Lee", uncpba);
		assertNotNull(usuario1);
		Usuario usuario2 = new Usuario(43243242, "Vinton", "Cerf", unlp);
		assertNotNull(usuario2);
		Usuario usuario3 = new Usuario(31231235, "Albert", "Einsten", uncpba);
		assertNotNull(usuario3);
		Usuario usuario4 = new Usuario(65436564, "Steve", "Jobs", unlp);
		assertNotNull(usuario4);
		Usuario usuario5 = new Usuario(43243243, "Bill", "Gates", uncpba);
		assertNotNull(usuario5);
		Usuario usuario6 = new Usuario(32434232, "Mark", "Zuckerberg", unlp);
		assertNotNull(usuario6);
		Usuario usuario7 = new Usuario(4324322, "Stephen", "Hawking", unlp);
		assertNotNull(usuario7);
		Usuario usuario8 = new Usuario(1213234, "Alan", "Turing", uncpba);
		assertNotNull(usuario8);

		usuarioDAO.persist(usuario2);
		usuarioDAO.persist(usuario3);
		usuarioDAO.persist(usuario4);
		usuarioDAO.persist(usuario5);
		usuarioDAO.persist(usuario6);
		usuarioDAO.persist(usuario7);
		usuarioDAO.persist(usuario8);
		usuarioDAO.persist(usuario1);

		int cantidadUsuarios = usuarioDAO.getCantidadUsuarios();
		assertEquals(20, cantidadUsuarios);
	}
}
