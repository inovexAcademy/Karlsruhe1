package de.inovex.academy.csd.framemaker;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class FrameMaker {

	private static final char BORDER_CHAR = '*';
	private static final int LINE_FRAME_WIDTH = 2;

	public List<String> makeFrame(List<String> textList) {
		List<String> frame = new ArrayList<>();
		
		String borderLine = generateBorderLine(textList);
		frame.add(borderLine);
		frame.addAll(generateBody(textList));
		frame.add(borderLine);
		
		return frame;
	}

	private List<String> generateBody(List<String> textList) {
		List<String> body = new ArrayList<>();
		for(String line : textList) {
			body.add(BORDER_CHAR + line + BORDER_CHAR);
		}
		return body;
	}

	private String generateBorderLine(List<String> textList) {
		return StringUtils.repeat(BORDER_CHAR, textList.get(0).length() + LINE_FRAME_WIDTH);
	}

}
