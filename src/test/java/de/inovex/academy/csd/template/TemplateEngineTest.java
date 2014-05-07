package de.inovex.academy.csd.template;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class TemplateEngineTest {

	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testTemplateEngineWithoutPlaceholder() {
		TemplateEngine template = new TemplateEngine("Hallo");
		assertThat(template.render(new HashMap<String, String>()), is("Hallo"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTemplateEngineWithoutMatchingPlaceholder() {
		TemplateEngine template = new TemplateEngine("Hallo");
		HashMap<String, String> values = new HashMap<String, String>();
		values.put("name", "Klaus");
		
		template.render(values);
	}
	
}
