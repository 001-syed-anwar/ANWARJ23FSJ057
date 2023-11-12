package edu.disease.asn6;

import java.util.List;

public class DiseaseAndPatient {
	private List<Disease> diseases;
	private List<Patient> patients;

	public List<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases=diseases;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
