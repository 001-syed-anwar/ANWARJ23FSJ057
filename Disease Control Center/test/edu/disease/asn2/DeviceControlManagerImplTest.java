package edu.disease.asn2;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class DeviceControlManagerImplTest {
	DeviceControlManagerImpl obj;
	UUID patientId = UUID.randomUUID(),
		disease1Id = UUID.randomUUID(),
		disease2Id = UUID.randomUUID();

	@Before
	public void setup() {
		obj = new DeviceControlManagerImpl();
		Patient p1 = obj.addPatient("Christiano", "Ronaldo", 1, 1);
		p1.setPatientId(patientId);
		obj.addPatientInArray(p1);

		Disease d1 = obj.addDisease("Malaria", false);
		d1.setDiseaseId(disease1Id);
		Disease d2 = obj.addDisease("Covid-19", true);
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

	@Test(expected=IllegalArgumentException.class)
	public void testAddDiseaseToPatient1() {
		obj.addDiseaseToPatient(patientId, disease1Id);
		obj.addDiseaseToPatient(UUID.randomUUID(), disease1Id);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddDiseaseToPatient2() {
		obj.addDiseaseToPatient(patientId, UUID.randomUUID());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddExposureToPatient() {
		Exposure exposure=new Exposure(UUID.randomUUID()); 
		obj.addExposureToPatient(patientId, exposure);
		obj.addExposureToPatient(UUID.randomUUID(), exposure);
	}
}
