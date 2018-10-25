package testJUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	LugarTest.class,
	UsuarioTest.class,
	TematicaTest.class,
	TipoTrabajoTest.class,
	TrabajoTest.class,
})

public class TestSuite {

}