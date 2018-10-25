package testJUnit;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import entidades.TipoTrabajo;

public class TipoTrabajoTest {
	
	private static TipoTrabajo tipo;

	@BeforeClass
	public static void testCreateTipoTrabajo() {
		tipo = new TipoTrabajo("poster");
		assertNotNull(tipo);
	}
	
	@Test
	public void testGetTipo() {
		String nombreTipo = tipo.getNombre();
		assertEquals("poster", nombreTipo);
	}

}
