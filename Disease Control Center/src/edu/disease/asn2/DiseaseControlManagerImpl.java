package edu.disease.asn2;

import java.util.UUID;

/**
 * This class implements the DeviceControlManager interface.
 * 
 * @author Syed Anwar
 *
 */
public class DiseaseControlManagerImpl implements DiseaseControlManager {
	private Disease[] diseases = new Disease[10];
	private Patient[] patients = new Patient[5];
	private int disPointer, patPointer;

	public void addDiseaseInArray(Disease d) {
		diseases[disPointer++] = d;
	}

	public void addPatientInArray(Patient p) {
		patients[patPointer++] = p;
	}

	@Override
	public Disease addDisease(String name, boolean infectious) {
		Disease obj;
		if (infectious)
			obj = new InfectiousDisease();
		else
			obj = new NonInfectiousDisease();
		obj.setName(name);
		return obj;
	}

	@Override
	public void addDiseaseToPatient(UUID patientId, UUID diseaseId) {
		Patient patient = getPatient(patientId);
		if (patient == null)
			throw new IllegalArgumentException();

		Disease disease = getDisease(diseaseId);
		if (disease == null)
			throw new IllegalArgumentException();

		patient.addDiseaseId(diseaseId);
	}

	@Override
	public void addExposureToPatient(UUID patientId, Exposure exposure) {
		Patient patient = getPatient(patientId);
		if (patient == null)
			throw new IllegalArgumentException();

		patient.addExposure(exposure);
	}

	@Override
	public Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures) {
		Patient patient = new Patient(maxDiseases, maxExposures);
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		return patient;
	}

	@Override
	public Disease getDisease(UUID diseaseId) {
		Disease disease = null;
		for (Disease d : diseases)
			if (d == null || d.getDiseaseId().equals(diseaseId)) {
				disease = d;
				break;
			}
		return disease;
	}

	@Override
	public Patient getPatient(UUID patientId) {
		Patient patient = null;
		for (Patient p : patients)
			if (p == null || p.getPatientId().equals(patientId)) {
				patient = p;
				break;
			}
		return patient;
	}
}
