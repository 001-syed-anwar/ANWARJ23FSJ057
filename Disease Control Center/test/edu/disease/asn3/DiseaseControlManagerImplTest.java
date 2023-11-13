package edu.disease.asn3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		p1 = obj.addPatient("Christiano", "Ronaldo", 1, 1);
		p1.setPatientId(patientId);
		obj.addPatientInArray(p1);

		d1 = obj.addDisease("Malaria", false);
		d1.setDiseaseId(disease1Id);
		d2 = obj.addDisease("Covid-19", true);
		d2.setDiseaseId(disease2Id);
		obj.addDiseaseInArray(d1);
		obj.addDiseaseInArray(d2);
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
		Disease[] diseases=obj.getDiseases();
		assertEquals(d1,diseases[0]);
		assertEquals(d2,diseases[1]);
	}

	@Test
	public void testGetPatient() {
		Patient[] patients=obj.getPatients();
		assertEquals(p1,patients[0]);
	}
}
