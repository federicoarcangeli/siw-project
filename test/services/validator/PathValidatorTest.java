package services.validator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.project.services.validator.PathValidator;

public class PathValidatorTest {
	private PathValidator Pathvalidator;
	private final static String SOURCE = "C:\\Users\\Federico\\testFileUtils\\tmp1\\test.txt";
	private final static String DESTINATION = "C:\\Users\\Federico\\testFileUtils\\tmp2";
	

	@Before
	public void setUp() throws Exception {
		this.Pathvalidator = new PathValidator();
	}

	@Test
	public void testCopyToDir() {
		this.Pathvalidator.copyFileToDir(SOURCE, DESTINATION);
		
	}
	
	@Test
	public void testCopyToDir2() {
		this.Pathvalidator.copyFileToDir("C:\\Users\\Federico\\testFileUtils\\tmp1\\copiami.bmp", DESTINATION);
	}

}
