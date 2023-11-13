package edu.disease.asn4;

/**
 * This class has useful method to do Contact Tracing 
 * @author Syed Anwar
 */
public class ContactTrace {
	private DiseaseControlManager diseaseControlManager;

	/**
	 * 
	 * @param diseaseControlManager
	 */
	public ContactTrace(DiseaseControlManager diseaseControlManager) {
		this.diseaseControlManager = diseaseControlManager;
	}

	/**
	 * Finds the earliest exposed patient of a patient.
	 * @param patient
	 * @return
	 */
	public PatientZero findPatientZero(Patient patient) {
		/*
		 * The default answer of patient who doesn't have any direct exposures is the
		 * current patient himself without any date and time and exposed attribute as
		 * 'false'.
		 */
		PatientZero patientZero = new PatientZero();
		patientZero.setPatient(patient);

		// Iterating though the patient exposures array
		for (Exposure exposure : patient.getExposures()) {

			/*
			 * further computations take place only when the current exposure is a direct
			 * exposure
			 */
			if (exposure.getExposureType().equalsIgnoreCase("D")) {

				// retrieving the patient with it's ID from the current exposure.
				Patient exposedPatient = diseaseControlManager.getPatient(exposure.getPatientId());

				// updating the patientZero by comparing the current exposed patient
				if (!patientZero.isExposed()
						|| patientZero.getExposureDateTime().compareTo(exposure.getDateTime()) > 0) {
					patientZero.setExposed(true);
					patientZero.setExposureDateTime(exposure.getDateTime());
					patientZero.setPatient(exposedPatient);
				}

				PatientZero foundExposedPatient = findPatientZero(exposedPatient);

				/*
				 * updating the patientZero by comparing the current exposed patient's earliest
				 * exposed patient.
				 */
				if (foundExposedPatient.isExposed()
						&& patientZero.getExposureDateTime().compareTo(foundExposedPatient.getExposureDateTime()) > 0) {
					patientZero.setExposed(true);
					patientZero.setExposureDateTime(foundExposedPatient.getExposureDateTime());
					patientZero.setPatient(foundExposedPatient.getPatient());
				}

			}
		}
		return patientZero;
	}
}
