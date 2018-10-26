package testJUnit;

import static org.junit.Assert.*;
import dao.LugarDAO;
import org.junit.BeforeClass;
import org.junit.Test;
import entidades.Lugar;

public class LugarTest {
	
	private static LugarDAO lugarDAO;
	private static Lugar lugar;
	
	
	@BeforeClass
	public static void setUpEnviroment(){
		lugarDAO = LugarDAO.getInstance();
	}

	@BeforeClass
	public static void testCreateLugar() {
		lugar = new Lugar("UNCPBA", "Tandil");
		assertNotNull(lugar);
		lugarDAO.persist(lugar);
		lugarDAO.findAll();
		
	}
	
	@Test
	public void testGetCiudad() {
		String ciudad = lugar.getCiudad();
		assertEquals("Tandil", ciudad);
	}
	
	@Test
	public void testGetLugar() {
		String institucion = lugar.getNombre();
		assertEquals("UNCPBA", institucion);
	}
	
}
