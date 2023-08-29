package edu.disease.asn2;

import java.time.LocalDateTime;
import java.util.UUID;

import com.google.common.hash.Hashing;

/**
 * This is Exposure class from edu.disease.asn1 package.
 * 
 * @author Syed Anwar
 *
 */
public class Exposure {
	private UUID patientId;
	private LocalDateTime dateTime;
	private String exposureType;

	/**
	 * This method returns the patientId
	 * 
	 * @return patientId as UUID
	 */
	public UUID getPatientId() {
		return patientId;
	}

	/**
	 * This method returns the dateTime
	 * 
	 * @return dateTime as LocalDateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * This method sets the dateTime
	 * 
	 * @param dateTime as LocalDateTime
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * This method returns the exposureType
	 * 
	 * @return exposureType as String
	 */
	public String getExposureType() {
		return exposureType;
	}

	/**
	 * This method sets the exposureTpe
	 * 
	 * @throws IllegalArgumentException
	 * @param exposureType as String
	 */
	public void setExposureType(String exposureType) {
		if (!exposureType.equals("D") && !exposureType.equals("I"))
			throw new IllegalArgumentException("The exposure type must be D or I");
		this.exposureType = exposureType;
	}

	/**
	 * This constructor accepts patientId as UUID
	 * 
	 * @param patientId as UUID
	 */
	public Exposure(UUID patientId) {
		this.patientId = patientId;
	}

	/**
	 * This method generates the hash code based on PatientId and dateTime
	 * 
	 * @throws IllegalAccessError
	 */
	@Override
	public int hashCode() {
		if (dateTime == null)
			throw new IllegalAccessError("Please set the \"dateTime\" Property");
		String input = patientId.hashCode() + dateTime.toString();
		int hash = Hashing.murmur3_32().hashBytes(input.getBytes()).asInt();
		return hash;
	}

	/**
	 * This method compares the objects based on their PatientId and dateTime
	 */
	@Override
	public boolean equals(Object obj) {
		Exposure e = (Exposure) obj;
		if (patientId != null && e.patientId != null)
			return this.hashCode() == e.hashCode();
		return false;
	}

	/**
	 * This method returns all the properties of Disease class as string message.
	 */
	@Override
	public String toString() {
		return "Exposure [patientId=" + patientId + ", dateTime=" + dateTime + ", exposureType=" + exposureType + "]";
	}

}
