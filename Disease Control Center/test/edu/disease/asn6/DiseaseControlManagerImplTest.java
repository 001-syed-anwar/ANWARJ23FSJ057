package edu.disease.asn6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class DiseaseControlManagerImplTest {
	DiseaseControlManagerImpl obj;
	Disease d1, d2;
	Patient p1;
	UUID patientId = UUID.randomUUID(), disease1Id = UUID.randomUUID(), disease2Id = UUID.randomUUID();

	@Before
	public void setup() {
		obj = new DiseaseControlManagerImpl();
		p1 = obj.addPatient("Christiano", "Ronaldo");
		p1.setPatientId(patientId);

		d1 = obj.addDisease("Malaria", false);
		d1.setDiseaseId(disease1Id);
		d2 = obj.addDisease("Covid-19", true);
		d2.setDiseaseId(disease2Id);
	}

	@Test
	public void testAddDisease() {
		Disease disease = obj.addDisease("Malaria", false);
		assertTrue(disease instanceof NonInfectiousDisease);

		disease = obj.addDisease("Covid-19", true);
		assertTrue(disease instanceof InfectiousDisease);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddDiseaseToPatient1() {
		obj.addDiseaseToPatient(patientId, disease1Id);
		obj.addDiseaseToPatient(UUID.randomUUID(), disease1Id);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddDiseaseToPatient2() {
		obj.addDiseaseToPatient(patientId, UUID.randomUUID());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddExposureToPatient() {
		Exposure exposure = new Exposure(UUID.randomUUID());
		obj.addExposureToPatient(patientId, exposure);
		obj.addExposureToPatient(UUID.randomUUID(), exposure);
	}

	@Test
	public void testGetDisease() {
		List<Disease> diseases=obj.getDiseases();
		assertEquals(d1,diseases.get(0));
		assertEquals(d2,diseases.get(1));
	}

	@Test
	public void testGetPatient() {
		List<Patient> patients=obj.getPatients();
		assertEquals(p1,patients.get(0));
	}
}
