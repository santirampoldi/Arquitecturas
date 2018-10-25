package testJUnit;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import entidades.Lugar;
import entidades.Tematica;
import entidades.TipoTrabajo;
import entidades.Trabajo;
import entidades.Usuario;

public class TrabajoTest {
	private static Lugar uncpbaFCE;
	private static Lugar uncpbaFCH;
	private static Usuario autor1;
	private static Usuario autor2;
	private static Set<Usuario> autores;
	private static Tematica tema1;
	private static Tematica tema2;
	private static Tematica tema3;
	private static Set<Tematica> tematicas;
	private static TipoTrabajo tipoTrabajo;
	private static Trabajo trabajo;
	
	
	@BeforeClass 
	public static void testCrearInstitucion(){
		uncpbaFCE = new Lugar("UNCPBA - Facultad de Ciencias Exactas", "Tandil");
		assertNotNull(uncpbaFCE);
		uncpbaFCH = new Lugar("UNCPBA - Facultad de Ciencias Humanas", "Tandil");
		assertNotNull(uncpbaFCH);
	}
	
	@BeforeClass 
	public static void testCrearAutores(){
		System.out.println("Se crean los autores: ");

		autor1 = new Usuario(36626800, "Agustin", "Meliendrez", uncpbaFCH);
		assertNotNull(autor1);
		autor2 = new Usuario(39778290, "Rampoldi", "Santiago", uncpbaFCE); // Poner documento de santi
		assertNotNull(autor2);
		autores = new HashSet<Usuario>();
		autores.add(autor1);
		autores.add(autor2);
		
		System.out.println("Autores: " + autores.size());
		assertNotNull(autores);
	}
	
	@BeforeClass
	public static void testCrearTematicas(){
		tema1 = new Tematica("Inteligencia Artifical", true);
		assertNotNull(tema1);
		tema2 = new Tematica("BigData", true);
		assertNotNull(tema2);
		tema3 = new Tematica("Machine Learning", true);
		assertNotNull(tema3);
		tematicas = new HashSet<Tematica>();
		tematicas.add(tema1);
		tematicas.add(tema2);
		tematicas.add(tema3);
		assertNotNull(tematicas);
	}
	
	@BeforeClass
	public static void testCrearTipoTrabajo(){
		tipoTrabajo = new TipoTrabajo("Articulo");
		assertNotNull(tipoTrabajo);
	}
	
	
	@BeforeClass
	public static void testCreateTrabajo() {		
		trabajo = new Trabajo("Desmitificando la IA", tipoTrabajo, autores, tematicas);
		assertNotNull(trabajo);
	}
	
	@Test
	public void testGetNombreTrabajo(){
		String nombreTrabajo = trabajo.getNombre();
		assertEquals("Desmitificando la IA", nombreTrabajo);
	}
	
	@Test
	public void getTipoTrabajo(){
		String tipo = trabajo.getTipo().getNombre();
		assertEquals("Articulo", tipo);
	}
	
	@Test
	public void testGetCantidadAutores(){
		int cantidadAutores = trabajo.getAutores().size();
		assertEquals(2, cantidadAutores);
	}
	
	@Test
	public void testGetCantidadTemas(){
		int cantidadTemas = trabajo.getTemas().size();
		assertEquals(3, cantidadTemas);
	}
}
