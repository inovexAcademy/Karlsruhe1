package de.inovex.academy.csd.framemaker;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FrameMakerTest {

	private FrameMaker maker;
	
	@Before
	public void setUp() throws Exception {
		maker = new FrameMaker();
	}

	@Test
	public void testFrameMakerWithSingleLineAndSingleLetter() {
		assertThat(maker.makeFrame(asList("x")), equalTo(asList("***","*x*","***")));
		assertThat(maker.makeFrame(asList("y")), equalTo(asList("***","*y*","***")));
	}

	@Test
	public void testFrameMakerWithSingleLineAndSingleWord() {
		assertThat(maker.makeFrame(asList("hello")), equalTo(asList("*******","*hello*","*******")));
	}
	
	@Test
	public void testFrameMakerWithMultiLines() {
		assertThat(maker.makeFrame(asList("hello", "world")), equalTo(asList("*******","*hello*","*world*","*******")));
	}
	
	@Test
	public void testFrameMakerWithMultiLinesAndDifferentLength() {
		assertThat(maker.makeFrame(asList("hello", "world!!!")), equalTo(asList("**********","*hello   *","*world!!!*","**********")));
	}
}
