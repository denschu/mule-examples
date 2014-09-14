package de.codecentric.mule;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.mule.tck.junit4.FunctionalTestCase;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.SAXException;

public class MuleTest extends FunctionalTestCase {
	
	@Override
	protected String getConfigResources() {
		return "src/main/resources/mule-config.xml";
	}

	@Override
	protected int getTimeoutSystemProperty() {
		return 60 * 60; // 1 hour
	}
	
	@Test
	@Ignore
	public void testRestApi() throws IOException, SAXException {
		
		// Given
		RestTemplate restTemplate = new RestTemplate();
        	
		// When
		String response = restTemplate.getForObject("http://localhost:8081/echo",String.class);
		
		// Then
		assertEquals("/echo",response);	
	}
	
}