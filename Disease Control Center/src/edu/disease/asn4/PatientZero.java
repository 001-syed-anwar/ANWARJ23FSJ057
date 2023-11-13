package edu.disease.asn4;

import java.time.LocalDateTime;

/**
 * This Class stores patient and their exposure details
 * @author Syed Anwar
 */
public class PatientZero {
	private Patient patient;
	private LocalDateTime exposureDateTime;
	private boolean exposed;

	/**
	 * getter method of patient 
	 * @return
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * setter method of patient
	 * @param patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * get method of exposure date time
	 * @return
	 */
	public LocalDateTime getExposureDateTime() {
		return exposureDateTime;
	}

	/**
	 * setter method of exposure date time
	 * @param exposureDateTime
	 */
	public void setExposureDateTime(LocalDateTime exposureDateTime) {
		this.exposureDateTime = exposureDateTime;
	}

	/**
	 * getter method of exposed
	 * @return
	 */
	public boolean isExposed() {
		return exposed;
	}

	/**
	 * setter method of exposed
	 * @param exposed
	 */
	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}
}
