package dajbi;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.dajbi.Interpreter;
import cz.cvut.fit.dajbi.internal.ClassFile;
import cz.cvut.fit.dajbi.internal.VMSettings;
import cz.cvut.fit.dajbi.methodarea.ClassResolver;

public class InterpreterTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@BeforeClass
	public static void once() {
		Tests.init();
		Logger.getRootLogger().setLevel(Level.DEBUG);
	}

	@Test
	public void test() {
		
		ClassFile mainclass = ClassResolver.resolveClass(VMSettings.TEST_CLASSES+"SampleClass02.class");		
		Interpreter inter = new Interpreter();		
		inter.run(mainclass);	
	}

}
