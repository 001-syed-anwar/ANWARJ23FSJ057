package edu.disease.asn6;

import java.time.LocalDateTime;

public class PatientZero {
	private Patient patient;
	private LocalDateTime exposureDateTime;
	private boolean exposed;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public LocalDateTime getExposureDateTime() {
		return exposureDateTime;
	}

	public void setExposureDateTime(LocalDateTime exposureDateTime) {
		this.exposureDateTime = exposureDateTime;
	}

	public boolean isExposed() {
		return exposed;
	}

	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}
}
