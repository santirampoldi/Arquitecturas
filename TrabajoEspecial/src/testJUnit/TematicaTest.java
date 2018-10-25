package testJUnit;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import entidades.Tematica;

public class TematicaTest {
	
	private static Tematica tematica;

	@BeforeClass
	public static void testCreateTematica() {
		tematica = new Tematica("Inteligencia Artifical", true);
		assertNotNull(tematica);
	}
	
	@Test
	public void testGetTematica() {
		String nombreTematica = tematica.getNombre();
		assertEquals("Inteligencia Artifical", nombreTematica);
	}
	
	@Test
	public void testEsConocimientoExperto() {
		boolean esConocimientoExperto = tematica.getTipo();
		assertTrue(esConocimientoExperto);
	}
}
