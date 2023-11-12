package edu.disease.asn6;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class ContactTraceTest {
	DiseaseControlManager d;
	ContactTrace ct;
	Patient p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
	Exposure e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15,e16;

	@Before
	public void init() {
		d = new DiseaseControlManagerImpl();

		p1 = d.addPatient("patient1", "1");
		p1.setPatientId(UUID.randomUUID());
		p2 = d.addPatient("patient2", "2");
		p2.setPatientId(UUID.randomUUID());
		p3 = d.addPatient("patient3", "3");
		p3.setPatientId(UUID.randomUUID());
		p4 = d.addPatient("patient4", "4");
		p4.setPatientId(UUID.randomUUID());
		p5 = d.addPatient("patient5", "5");
		p5.setPatientId(UUID.randomUUID());
		p6 = d.addPatient("patient6", "6");
		p6.setPatientId(UUID.randomUUID());
		p7 = d.addPatient("patient7", "7");
		p7.setPatientId(UUID.randomUUID());
		p8 = d.addPatient("patient8", "8");
		p8.setPatientId(UUID.randomUUID());
		p9 = d.addPatient("patient9", "9");
		p9.setPatientId(UUID.randomUUID());
		p10 = d.addPatient("patient10", "10");
		p10.setPatientId(UUID.randomUUID());

		e1 = new Exposure(p2.getPatientId());
		e1.setExposureType(Exposure.DIRECT_EXPOSURE);
		e1.setDateTime(LocalDateTime.of(2025, 10, 1, 12, 30));
		e2 = new Exposure(p3.getPatientId());
		e2.setExposureType(Exposure.DIRECT_EXPOSURE);
		e2.setDateTime(LocalDateTime.of(2027, 10, 1, 12, 30));
		e3 = new Exposure(p4.getPatientId());
		e3.setExposureType(Exposure.DIRECT_EXPOSURE);
		e3.setDateTime(LocalDateTime.of(2026, 10, 1, 12, 30));

		e4 = new Exposure(p5.getPatientId());
		e4.setExposureType(Exposure.DIRECT_EXPOSURE);
		e4.setDateTime(LocalDateTime.of(2024, 10, 1, 12, 30));
		e5 = new Exposure(p6.getPatientId());
		e5.setExposureType(Exposure.DIRECT_EXPOSURE);
		e5.setDateTime(LocalDateTime.of(2029, 1, 1, 12, 30));
		e6 = new Exposure(p7.getPatientId());
		e6.setExposureType(Exposure.DIRECT_EXPOSURE);
		e6.setDateTime(LocalDateTime.of(2028, 6, 1, 12, 30));

		e7 = new Exposure(p9.getPatientId());
		e7.setExposureType(Exposure.DIRECT_EXPOSURE);
		e7.setDateTime(LocalDateTime.of(2030, 5, 1, 12, 30));
		e8 = new Exposure(p10.getPatientId());
		e8.setExposureType(Exposure.DIRECT_EXPOSURE);
		e8.setDateTime(LocalDateTime.of(2022, 9, 1, 12, 30));

		e9 = new Exposure(p2.getPatientId());
		e9.setExposureType(Exposure.INDIRECT_EXPOSURE);
		e10 = new Exposure(p2.getPatientId());
		e10.setExposureType(Exposure.INDIRECT_EXPOSURE);
		e11 = new Exposure(p3.getPatientId());
		e11.setExposureType(Exposure.INDIRECT_EXPOSURE);
		e12 = new Exposure(p4.getPatientId());
		e12.setExposureType(Exposure.INDIRECT_EXPOSURE);
		e13 = new Exposure(p3.getPatientId());
		e13.setExposureType(Exposure.INDIRECT_EXPOSURE);
		e14 = new Exposure(p4.getPatientId());
		e14.setExposureType(Exposure.INDIRECT_EXPOSURE);
		e15 = new Exposure(p2.getPatientId());
		e15.setExposureType(Exposure.INDIRECT_EXPOSURE);
		e16 = new Exposure(p4.getPatientId());
		e16.setExposureType(Exposure.INDIRECT_EXPOSURE);

		// assigning direct exposures
		d.addExposureToPatient(p1.getPatientId(), e1);
		d.addExposureToPatient(p1.getPatientId(), e2);
		d.addExposureToPatient(p1.getPatientId(), e3);

		d.addExposureToPatient(p2.getPatientId(), e4);
		d.addExposureToPatient(p2.getPatientId(), e5);
		d.addExposureToPatient(p2.getPatientId(), e6);

		d.addExposureToPatient(p4.getPatientId(), e7);
		d.addExposureToPatient(p4.getPatientId(), e8);

		// some indirect exposures
		d.addExposureToPatient(p2.getPatientId(), e9);
		d.addExposureToPatient(p2.getPatientId(), e10);
		d.addExposureToPatient(p3.getPatientId(), e11);
		d.addExposureToPatient(p5.getPatientId(), e12);
		d.addExposureToPatient(p6.getPatientId(), e13);
		d.addExposureToPatient(p7.getPatientId(), e14);
		d.addExposureToPatient(p8.getPatientId(), e15);
		d.addExposureToPatient(p9.getPatientId(), e16);

	}


	@Test
	public void testFindPatientZero_1() {
		
		PatientZero patientZero = new ContactTrace(d).findPatientZero(p1);
		assertTrue(patientZero.isExposed());
		assertNotNull(patientZero.getPatient());
		assertNotNull(patientZero.getExposureDateTime());
	}
	
	@Test
	public void testFindPatientZero_2() {
		
		PatientZero patientZero = new ContactTrace(d).findPatientZero(p2);
		assertTrue(patientZero.isExposed());
		assertNotNull(patientZero.getPatient());
		assertNotNull(patientZero.getExposureDateTime());
	}
	
	@Test
	public void testFindPatientZero_3() {
		
		PatientZero patientZero = new ContactTrace(d).findPatientZero(p3);
		assertFalse(patientZero.isExposed());
		assertNotNull(patientZero.getPatient());
		assertNull(patientZero.getExposureDateTime());
	}
	
	@Test
	public void testFindPatientZero_4() {
		
		PatientZero patientZero = new ContactTrace(d).findPatientZero(p4);
		assertTrue(patientZero.isExposed());
		assertNotNull(patientZero.getPatient());
		assertNotNull(patientZero.getExposureDateTime());
	}
	
	@Test
	public void testFindPatientZero_5() {
		
		PatientZero patientZero = new ContactTrace(d).findPatientZero(p5);
		assertFalse(patientZero.isExposed());
		assertNotNull(patientZero.getPatient());
		assertNull(patientZero.getExposureDateTime());
	}
	
	@Test
	public void testFindPatientZero_6() {
		
		PatientZero patientZero = new ContactTrace(d).findPatientZero(p6);
		assertFalse(patientZero.isExposed());
		assertNotNull(patientZero.getPatient());
		assertNull(patientZero.getExposureDateTime());
	}
	
	@Test
	public void testFindPatientZero_7() {
		
		PatientZero patientZero = new ContactTrace(d).findPatientZero(p7);
		assertFalse(patientZero.isExposed());
		assertNotNull(patientZero.getPatient());
		assertNull(patientZero.getExposureDateTime());
	}
	
	@Test
	public void testFindPatientZero_8() {
		
		PatientZero patientZero = new ContactTrace(d).findPatientZero(p8);
		assertFalse(patientZero.isExposed());
		assertNotNull(patientZero.getPatient());
		assertNull(patientZero.getExposureDateTime());
	}
	
	@Test
	public void testFindPatientZero_9() {
		
		PatientZero patientZero = new ContactTrace(d).findPatientZero(p9);
		assertFalse(patientZero.isExposed());
		assertNotNull(patientZero.getPatient());
		assertNull(patientZero.getExposureDateTime());
	}
	
	@Test
	public void testFindPatientZero_10() {
		
		PatientZero patientZero = new ContactTrace(d).findPatientZero(p10);
		assertFalse(patientZero.isExposed());
		assertNotNull(patientZero.getPatient());
		assertNull(patientZero.getExposureDateTime());
	}
}
