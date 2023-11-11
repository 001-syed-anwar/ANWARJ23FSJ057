package edu.disease.asn4;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/**
 * This is Patient class from edu.disease.asn2 package.
 * 
 * @author Syed Anwar
 *
 */
public class Patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4568340688183902786L;
	private UUID patientId, diseaseIds[];
	private String firstName, lastName;
	private Exposure[] exposures;
	private int disPointer, expPointer;

	/**
	 * This parameterized constructor accepts maxDiseases and maxExposures as
	 * arguments.
	 * 
	 * @throws IllegalArgumentException
	 * @param maxDiseases  as int
	 * @param maxExposures as int
	 */
	public Patient(int maxDiseases, int maxExposures) {
		if (maxDiseases <= 0 || maxExposures <= 0)
			throw new IllegalArgumentException("Cannot initialise with negative numbers or zero");
		diseaseIds = new UUID[maxDiseases];
		exposures = new Exposure[maxExposures];
	}

	/**
	 * This method adds n number of diseases mentioned in constructor, one at a
	 * time.
	 * 
	 * @throws IndexOutOfBoundsException
	 * @param diseaseId as UUID
	 */
	public void addDiseaseId(UUID diseaseId) {
		if (disPointer == diseaseIds.length)
			throw new IndexOutOfBoundsException();
		diseaseIds[disPointer++] = diseaseId;
	}

	/**
	 * This method adds n number of exposures mentioned in constructor, one at a
	 * time.
	 * 
	 * @throws IndexOutOfBoundsException
	 * @param exposure as Exposure
	 */
	public void addExposure(Exposure exposure) {
		if (expPointer == exposures.length)
			throw new IndexOutOfBoundsException();
		exposures[expPointer++] = exposure;
	}

	/**
	 * 
	 */
	public Exposure[] getExposures() {
		return exposures;
	}

	/**
	 * This method returns patientId
	 * 
	 * @return patientId as UUID
	 */
	public UUID getPatientId() {
		return patientId;
	}

	/**
	 * This method sets the patientId
	 * 
	 * @param patientId as UUID
	 */
	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	/**
	 * This method returns firstName
	 * 
	 * @return firstName as String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method sets firstName
	 * 
	 * @param firstName as String
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This method returns lastName
	 * 
	 * @return lastName as String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method sets lastName
	 * 
	 * @param lastName as String
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * This method generates hash code based on the given patientId
	 * 
	 * @throws NullPointerException
	 */
	@Override
	public int hashCode() {
		return patientId.hashCode();
	}

	/**
	 * This method compares the objects based on their patientId
	 */
	@Override
	public boolean equals(Object obj) {
		Patient p = (Patient) obj;
		if (patientId != null && p.patientId != null)
			return this.hashCode() == obj.hashCode();
		return false;
	}

	/**
	 * This method returns all the properties of Disease class as string message.
	 */
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", diseaseIds=" + Arrays.toString(diseaseIds) + ", firstName="
				+ firstName + ", lastName=" + lastName + ", exposures=" + Arrays.toString(exposures) + "]";
	}

	/**
	 * This method sorts the patients array in lexicographical order.
	 * 
	 * @param patients as Patients[]
	 * @return patients as Patient[]
	 */
	public static Patient[] sort(Patient... patients) {
		Comparator<Patient> customComparator = Comparator.comparing(Patient::getLastName, String.CASE_INSENSITIVE_ORDER)
				.thenComparing(Patient::getFirstName, String.CASE_INSENSITIVE_ORDER);
		Arrays.sort(patients, customComparator);
		return patients;
	}

}
