package testJUnit;

import entidades.Lugar;
import entidades.Trabajo;
import entidades.Usuario;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TrabajoTest {
	private static Usuario usuario;
	private static Trabajo trabajo;
	private static Lugar uncpba;

	
	
	@BeforeClass
	public static void testCreateUsuario() {
		System.out.println("Usuario -> testCreateUsuario");
		uncpba = new Lugar("uncpba", "Tandil");
		assertNotNull(uncpba);
		usuario = new Usuario(36626800, "Agustin", "Meliendrez", uncpba);
		assertNotNull(usuario);
		trabajo = new Trabajo();
	}
	
	
}
