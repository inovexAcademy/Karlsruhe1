package de.inovex.academy.csd.framemaker;

import static java.util.Arrays.asList;

import java.util.List;

import org.apache.commons.lang3.StringUtils;



public class FrameMaker {

	private static final String BORDER_CHAR = "*";

	public List<String> makeFrame(List<String> textList) {
		// TODO Auto-generated method stub
		String line = StringUtils.repeat(BORDER_CHAR, textList.get(0).length() + 2);
		return asList(line, BORDER_CHAR+ textList.get(0) +BORDER_CHAR, line);
	}



}
