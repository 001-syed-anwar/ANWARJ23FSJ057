package edu.disease.asn2;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonInfectiousDiseaseTest {

	@Test
	public void testGetExamples() {
		String[] nonInfectiousDisease = { "Diabetes", "Hypertension", "Alzheimer's Disease", "Osteoarthritis" };
		assertArrayEquals(nonInfectiousDisease,new NonInfectiousDisease().getExamples());
	}

}
