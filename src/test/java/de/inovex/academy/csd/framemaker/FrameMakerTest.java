package de.inovex.academy.csd.framemaker;

import static org.junit.Assert.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class FrameMakerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFrameMakerWithSingleLetter() {
		
		FrameMaker maker = new FrameMaker();
		
		assertThat(maker.makeFrame(asList("x")), equalTo(asList("***","*x*","***")));
		assertThat(maker.makeFrame(asList("y")), equalTo(asList("***","*y*","***")));
	}

	@Test
	public void testFrameMakerWithSingleWord() {
		FrameMaker maker = new FrameMaker();
		assertThat(maker.makeFrame(asList("hello")), equalTo(asList("*******","*hello*","*******")));
	}
	
	@Test
	public void testFrameMakerWithMultiLines() {
		FrameMaker maker = new FrameMaker();
		assertThat(maker.makeFrame(asList("hello", "world")), equalTo(asList("*******","*hello*","*world*","*******")));
	}
}
