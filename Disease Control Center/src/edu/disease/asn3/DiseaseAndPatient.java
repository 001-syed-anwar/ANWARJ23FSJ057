package edu.disease.asn3;

/**
 * This class Stores Disease and Patient
 */
public class DiseaseAndPatient {
	private Disease[] diseases;
	private Patient[] patients;

	
	/**
	 * getter method of diseases
	 * @return
	 */
	public Disease[] getDiseases() {
		return diseases;
	}

	/**
	 * setter method of diseases
	 * @param diseases
	 */
	public void setDiseases(Disease[] diseases) {
		this.diseases = diseases;
	}

	/**
	 * getter method of patients
	 * @return
	 */
	public Patient[] getPatients() {
		return patients;
	}

	/**
	 * setter method of patients
	 * @param patients
	 */
	public void setPatients(Patient[] patients) {
		this.patients = patients;
	}

}
