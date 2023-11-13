package edu.disease.asn6;

import java.util.List;

/**
 * This class Stores Disease and Patient
 */
public class DiseaseAndPatient {
	private List<Disease> diseases;
	private List<Patient> patients;

	
	/**
	 * getter method of diseases
	 * @return
	 */
	public List<Disease> getDiseases() {
		return diseases;
	}

	/**
	 * setter method of diseases
	 * @param diseases
	 */
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	/**
	 * getter method of patients
	 * @return
	 */
	public List<Patient> getPatients() {
		return patients;
	}

	/**
	 * setter method of patients
	 * @param patients
	 */
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
