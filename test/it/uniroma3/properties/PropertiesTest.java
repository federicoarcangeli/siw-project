package it.uniroma3.properties;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class PropertiesTest {
	
	private Properties senderAccountProp;
	

	@Before
	public void setUp() throws Exception {
		this.senderAccountProp = new Properties();
	
	}

	@Test
	public void testFindPathAndMail() throws IOException {
		InputStream input = PropertiesTest.class.getResourceAsStream("/accountProperties.prop");
		this.senderAccountProp.load(input);
		assertNotNull(senderAccountProp.getProperty("mail"));
	}

}
