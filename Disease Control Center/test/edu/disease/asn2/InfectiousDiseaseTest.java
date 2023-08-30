package edu.disease.asn2;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfectiousDiseaseTest {

	@Test
	public void testGetExamples() {
		String[] nonInfectiousDisease = { "Flu", "TB", "Malaria", "COVID-19 " };
		assertArrayEquals(nonInfectiousDisease, new InfectiousDisease().getExamples());
	}

}
