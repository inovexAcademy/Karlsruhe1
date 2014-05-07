package de.inovex.academy.csd.template;

import java.util.HashMap;
import java.util.Map;

public class TemplateEngine {

	private String template;

	public TemplateEngine(String template) {
		this.template = template;
	}

	public String render(Map<String, String> values) {
		if(!values.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return template;
	}

}
