package edu.disease.asn5;

import java.util.UUID;

/**
 * This interface provides abstract methods that will be useful for managing the
 * application.
 * 
 * @author Syed Anwar
 *
 */
public interface DiseaseControlManager {

	/**
	 * Adds a new disease to the Application
	 * 
	 * @param name
	 * @param infectious
	 * @return
	 */
	Disease addDisease(String name, boolean infectious);

	/**
	 * Returns the disease or null if it is not found.
	 * 
	 * @param diseaseId
	 * @return
	 */
	Disease getDisease(UUID diseaseId);

	/**
	 * Adds a new patient to the application.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param maxDiseases
	 * @param maxExposures
	 * @return
	 */
	Patient addPatient(String firstName, String lastName, int maxDiseases, int maxExposures);

	/**
	 * Returns the patient or null if it is not found.
	 * 
	 * @param patientId
	 * @return
	 */
	Patient getPatient(UUID patientId);

	/**
	 * Adds a disease to a patient
	 * 
	 * @param patientId
	 * @param diseaseId
	 */
	void addDiseaseToPatient(UUID patientId, UUID diseaseId);

	/**
	 * Adds an exposure instance to a patient
	 * 
	 * @param patientId
	 * @param exposure
	 */
	void addExposureToPatient(UUID patientId, Exposure exposure);
	
	/**
	 * 
	 */
	Disease[] getDiseases();
	
	/**
	 * 
	 */
	Patient[] getPatients();
}
