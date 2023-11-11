package edu.disease.asn4;

public class DiseaseAndPatient {
	private Disease[] Diseases;
	private Patient[] patients;

	public Disease[] getDiseases() {
		return Diseases;
	}

	public void setDiseases(Disease[] diseases) {
		Diseases = diseases;
	}

	public Patient[] getPatients() {
		return patients;
	}

	public void setPatients(Patient[] patients) {
		this.patients = patients;
	}

}
