package edu.disease.asn6;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class implements the DeviceControlManager interface.
 * 
 * @author Syed Anwar
 *
 */
public class DiseaseControlManagerImpl implements DiseaseControlManager {
	private List<Disease> diseases = new ArrayList<>();
	private List<Patient> patients= new ArrayList<>();

	@Override
	public Disease addDisease(String name, boolean infectious) {
		Disease obj;
		if (infectious)
			obj = new InfectiousDisease();
		else
			obj = new NonInfectiousDisease();
		obj.setName(name);
		diseases.add(obj);
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
	public Patient addPatient(String firstName, String lastName) {
		Patient patient = new Patient();
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patients.add(patient);
		return patient;
	}

	//map
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

	//map
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

	@Override
	public List<Disease> getDiseases() {
		return diseases;
	}

	@Override
	public List<Patient> getPatients() {
		return patients;
	}
}
