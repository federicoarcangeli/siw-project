package it.uniroma3.generalTest;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
	public void test() throws IOException {
		InputStream input = PropertiesTest.class.getResourceAsStream("/accountProperties.prop");
		this.senderAccountProp.load(input);
		assertNotNull(senderAccountProp.getProperty("mail"));
	}

}
