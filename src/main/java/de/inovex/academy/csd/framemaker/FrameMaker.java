package de.inovex.academy.csd.framemaker;

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
		int maxLineLength = getMaxLineLength(textList);
		
		List<String> body = new ArrayList<>();
		for(String line : textList) {
			body.add(generateBodyLine(line, maxLineLength));
		}
		return body;
	}

	private String generateBodyLine(String line, int maxLineLength) {
		String rightPadLine = StringUtils.rightPad(line, maxLineLength);
		return BORDER_CHAR + rightPadLine + BORDER_CHAR;
	}

	private String generateBorderLine(List<String> textList) {
		return StringUtils.repeat(BORDER_CHAR, getMaxLineLength(textList) + LINE_FRAME_WIDTH);
	}

	private int getMaxLineLength(List<String> textList) {
		int maxLength = 0;
		for (String line : textList) {
			maxLength = Math.max(maxLength, line.length());
		}
		
		return maxLength;
	}

}
