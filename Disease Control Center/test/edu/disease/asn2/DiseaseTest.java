package edu.disease.asn2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class DiseaseTest {
	private Disease disease;
	private UUID diseaseId;
	private String name;

	@Before
	public void setup() {
		diseaseId = UUID.randomUUID();
		name = "Covid-19";
		disease = new InfectiousDisease();
		disease.setDiseaseId(diseaseId);
		disease.setName(name);
	}

	@Test
	public void testHashCode() {
		int expected = diseaseId.hashCode();
		assertEquals(expected, disease.hashCode());
	}

	@Test
	public void testGetDiseasesId() {
		assertEquals(diseaseId, disease.getDiseaseId());
	}

	@Test
	public void testGetName() {
		assertEquals(name, disease.getName());
	}

	@Test
	public void testSetDiseasesId() {
		UUID diseaseIDNew = UUID.randomUUID();
		disease.setDiseaseId(diseaseIDNew);
		assertEquals(diseaseIDNew, disease.getDiseaseId());
	}

	@Test
	public void testSetName() {
		String nameNew = "Malayria";
		disease.setName(nameNew);
		assertEquals(nameNew, disease.getName());
	}

	@Test
	public void testEqualsObject() {
		Disease disease2 = new InfectiousDisease();
		disease2.setDiseaseId(diseaseId);
		assertTrue(disease.equals(disease2));

		disease2.setDiseaseId(UUID.randomUUID());
		assertFalse(disease.equals(disease2));

		disease2.setDiseaseId(null);
		assertFalse(disease.equals(disease2));

		disease2.setDiseaseId(diseaseId);
		disease.setDiseaseId(null);
		assertFalse(disease.equals(disease2));
	}

	@Test
	public void testToString() {
		String toStrMsg = "Disease [diseaseId=" + diseaseId + ", name=" + name + "]";
		assertEquals(toStrMsg, disease.toString());
	}

}
