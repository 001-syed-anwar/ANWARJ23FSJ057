package edu.disease.asn2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.UUID;

import org.junit.Test;

public class PatientTest {
	
	@Test
	public void sortTest() {
		Patient p1 = new Patient(1, 1);
		Patient p2 = new Patient(1, 1);
		Patient p3 = new Patient(2, 1);

		p1.setFirstName("Syed");
		p1.setLastName("Anwar");

		p2.setFirstName("Anwar");
		p2.setLastName("Syed");

		p3.setFirstName("syed");
		p3.setLastName("anwar");

		Patient[] patients = { p1, p2, p3 };
		
		assertArrayEquals(new Patient[] { p1, p3, p2 }, Patient.sort(patients));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void addExposureException() {
		Patient p = new Patient(1, 1);
		p.setPatientId(UUID.randomUUID());

		p.addExposure(new Exposure(p.getPatientId()));
		p.addExposure(new Exposure(p.getPatientId()));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void addDiseaseIdTest() {
		Patient p = new Patient(1, 1);
		p.setPatientId(UUID.randomUUID());

		p.addDiseaseId(UUID.randomUUID());
		p.addDiseaseId(UUID.randomUUID());
	}

	
	@Test
	public void testGetPatientId() {
		UUID id = UUID.randomUUID();
		Patient p = new Patient(1, 1);
		p.setPatientId(id);
		assertEquals(id, p.getPatientId());
	}

	@Test
	public void testGetFirstName() {
		String firstName = "Syed";
		Patient p = new Patient(1, 1);
		p.setFirstName(firstName);
		assertEquals(firstName, p.getFirstName());
	}

	@Test
	public void testGetLastName() {
		String lastName = "Syed";
		Patient p = new Patient(1, 1);
		p.setLastName(lastName);
		assertEquals(lastName, p.getLastName());
	}

	@Test
	public void testEqualsObject() {
		Patient p1 = new Patient(1, 1);
		p1.setPatientId(UUID.randomUUID());
		Patient p2 = new Patient(2, 2);
		p2.setPatientId(UUID.randomUUID());
		assertEquals(false, p1.equals(p2));
	}
	
	@Test
	public void testEqualsObject2() {
		UUID id=UUID.randomUUID();
		Patient p1 = new Patient(1, 1);
		p1.setPatientId(id);
		Patient p2 = new Patient(2, 2);
		p2.setPatientId(id);
		assertEquals(true, p1.equals(p2));
	}

	@Test
	public void testEqualsObject3() {
		UUID id=UUID.randomUUID();
		Patient p1 = new Patient(1, 1);
		p1.setPatientId(id);
		Patient p2 = new Patient(2, 2);
		assertEquals(false, p1.equals(p2));
	}
	
	@Test
	public void testEqualsObject4() {
		UUID id=UUID.randomUUID();
		Patient p1 = new Patient(1, 1);
		Patient p2 = new Patient(2, 2);
		p2.setPatientId(id);
		assertEquals(false, p1.equals(p2));
	}
	
	@Test
	public void testToString() {
		UUID patientId=UUID.randomUUID(),diseaseIds[]=new UUID[1];
		String firstName="Christiano",lastName="Ronaldo";
		Exposure[] exposures=new Exposure[1];
		
		String toStringMsg="Patient [patientId=" + patientId + ", diseaseIds=" + Arrays.toString(diseaseIds) + ", firstName="
				+ firstName + ", lastName=" + lastName + ", exposures=" + Arrays.toString(exposures) 
				+ "]";
		
		Patient patient=new Patient(1,1);
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setPatientId(patientId);
		
		assertEquals(toStringMsg,patient.toString());
	}
	
}
