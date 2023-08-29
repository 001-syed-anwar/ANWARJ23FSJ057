package edu.disease.asn1;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.Test;

public class ExposureTest {

	@Test(expected = IllegalAccessError.class)
	public void testHashCodeException() {
		Exposure e = new Exposure(UUID.randomUUID());
		e.hashCode();
	}

	@Test
	public void testGetPatientId() {
		UUID id = UUID.randomUUID();
		Exposure e = new Exposure(id);
		assertEquals(id, e.getPatientId());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetExposureTypeException() {
		Exposure e = new Exposure(UUID.randomUUID());
		e.setExposureType("eueiueui");
	}
	
	@Test
	public void testSetExposureType() {
		Exposure e = new Exposure(UUID.randomUUID());
		e.setExposureType("D");
		assertEquals("D",e.getExposureType());
		e.setExposureType("I");
		assertEquals("I",e.getExposureType());
	}

	@Test
	public void testSetDateTime() {
		Exposure e = new Exposure(UUID.randomUUID());
		LocalDateTime curDtTm=LocalDateTime.now();
		e.setDateTime(curDtTm);
		assertEquals(curDtTm.toString(),e.getDateTime().toString());
		
	}
	
	@Test
	public void testEqualsObject() {
		Exposure e1 = new Exposure(UUID.randomUUID());
		e1.setDateTime(LocalDateTime.now());
		Exposure e2 = new Exposure(UUID.randomUUID());
		e2.setDateTime(LocalDateTime.now());
		assertEquals(false, e1.equals(e2));
	}

	@Test
	public void testEqualsObject2() {
		UUID id = UUID.randomUUID();
		LocalDateTime curDtTm = LocalDateTime.now();
		Exposure e1 = new Exposure(id);
		e1.setDateTime(curDtTm);
		Exposure e2 = new Exposure(id);
		e2.setDateTime(curDtTm);
		assertEquals(true, e1.equals(e2));
	}
	
	@Test
	public void testEqualsObject3() {
		UUID id = UUID.randomUUID();
		LocalDateTime curDtTm = LocalDateTime.now();
		Exposure e1 = new Exposure(null);
		e1.setDateTime(curDtTm);
		Exposure e2 = new Exposure(id);
		e2.setDateTime(curDtTm);
		assertEquals(false, e1.equals(e2));
	}
	
	@Test
	public void testEqualsObject4() {
		UUID id = UUID.randomUUID();
		LocalDateTime curDtTm = LocalDateTime.now();
		Exposure e1 = new Exposure(id);
		e1.setDateTime(curDtTm);
		Exposure e2 = new Exposure(null);
		e2.setDateTime(curDtTm);
		assertEquals(false, e1.equals(e2));
	}
	
	@Test
	public void testToString() {
		UUID patientId=UUID.randomUUID();
		LocalDateTime dateTime = LocalDateTime.now();
		String exposureType="D";
		String toStringMsg="Exposure [patientId=" + patientId + ", dateTime=" + dateTime + ", exposureType=" + exposureType + "]";
		
		Exposure exposure=new Exposure(patientId);
		exposure.setDateTime(dateTime);
		exposure.setExposureType(exposureType);
		
		assertEquals(toStringMsg,exposure.toString());
	}

}
