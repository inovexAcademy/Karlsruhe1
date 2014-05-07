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
	
	@Test
	public void testTemplateEngineWithOnePlaceholder() {
		TemplateEngine template = new TemplateEngine("Hallo ${name}");
		
		HashMap<String, String> values = new HashMap<String, String>();
		values.put("name", "Klaus");
		
		assertThat(template.render(values), is("Hallo Klaus"));
	}
	
	@Test
	public void testTemplateEngineWithTwoPlaceholders() {
		TemplateEngine template = new TemplateEngine("Hallo ${name} ${lastname}");
		
		HashMap<String, String> values = new HashMap<String, String>();
		values.put("name", "Klaus");
		values.put("lastname", "Beimer");
		
		assertThat(template.render(values), is("Hallo Klaus Beimer"));
	}
	
//	@Test(expected = IllegalArgumentException.class)
//	public void testTemplateEngineWithPlaceholderAndNoMatchingValue() {
//		TemplateEngine template = new TemplateEngine("Hallo ${name}");
//		template.render(new HashMap<String, String>());
//	}
	
}
