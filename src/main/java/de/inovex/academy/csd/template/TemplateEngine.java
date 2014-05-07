package de.inovex.academy.csd.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class TemplateEngine {

	private String template;

	public TemplateEngine(String template) {
		this.template = template;
	}

	public String render(Map<String, String> values) {
		
		if (!CheckValues(values)) {
			throw new IllegalArgumentException();
		} 
		
		String result = template;
		for (String key : values.keySet()) {
			result = StringUtils.replace(result, buildPlaceholder(key), values.get(key));
		}
		return result;
	}

	private boolean CheckValues(Map<String, String> values) {
		List<String> keyList = new ArrayList<>(values.keySet());
		boolean check = true;
		for(String key : keyList) {
			check &= templateContainsPlaceholder(key);			
		}
		
		return check;
	}

	private String buildPlaceholder(String firstElement) {
		return "${" + firstElement + "}";
	}

	private boolean templateContainsPlaceholder(String placeholderName) {
		return template.contains(buildPlaceholder(placeholderName));
	}

	// private boolean doesMatchPlaceholders(Map<String, String> values) {
	// for (String key : values.keySet()) {
	// if(!template.contains("${"+key+"}")) {
	// return false;
	// }
	// }
	//
	//
	// return true;
	// }

}
