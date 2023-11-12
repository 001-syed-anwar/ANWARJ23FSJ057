package edu.disease.asn6;

import java.time.LocalDateTime;
import java.util.UUID;

public class ContactTrace {
	private DiseaseControlManager diseaseControlManager;

	public ContactTrace(DiseaseControlManager diseaseControlManager) {
		this.diseaseControlManager = diseaseControlManager;
	}

	public PatientZero findPatientZero(Patient patient) {
		/*
		 * The default answer of patient who doesn't have any direct exposures is the
		 * current patient himself without any date and time and exposed attribute as
		 * 'false'.
		 */
		PatientZero patientZero = new PatientZero();
		patientZero.setPatient(patient);

		// Iterating though the patient exposures list
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

	public static void main(String[] args) {

		DiseaseControlManager d = new DiseaseControlManagerImpl();
		d.addDisease("corona", true);
		d.addDisease("tb", true);
		d.addDisease("flu", true);
		d.addDisease("Hypertension", false);
		d.addDisease("Diabetes", false);

		Patient p1 = d.addPatient("patient1", "1");
		p1.setPatientId(UUID.randomUUID());
		Patient p2 = d.addPatient("patient2", "2");
		p2.setPatientId(UUID.randomUUID());
		Patient p3 = d.addPatient("patient3", "3");
		p3.setPatientId(UUID.randomUUID());
		Patient p4 = d.addPatient("patient4", "4");
		p4.setPatientId(UUID.randomUUID());
		Patient p5 = d.addPatient("patient5", "5");
		p5.setPatientId(UUID.randomUUID());
		Patient p6 = d.addPatient("patient6", "6");
		p6.setPatientId(UUID.randomUUID());
		Patient p7 = d.addPatient("patient7", "7");
		p7.setPatientId(UUID.randomUUID());
		Patient p8 = d.addPatient("patient8", "8");
		p8.setPatientId(UUID.randomUUID());
		Patient p9 = d.addPatient("patient9", "9");
		p9.setPatientId(UUID.randomUUID());
		Patient p10 = d.addPatient("patient10", "10");
		p10.setPatientId(UUID.randomUUID());

		Exposure e1 = new Exposure(p2.getPatientId());
		e1.setExposureType(Exposure.DIRECT_EXPOSURE);
		e1.setDateTime(LocalDateTime.of(2025, 10, 1, 12, 30));
		Exposure e2 = new Exposure(p3.getPatientId());
		e2.setExposureType(Exposure.DIRECT_EXPOSURE);
		e2.setDateTime(LocalDateTime.of(2027, 10, 1, 12, 30));
		Exposure e3 = new Exposure(p4.getPatientId());
		e3.setExposureType(Exposure.DIRECT_EXPOSURE);
		e3.setDateTime(LocalDateTime.of(2026, 10, 1, 12, 30));

		Exposure e4 = new Exposure(p5.getPatientId());
		e4.setExposureType(Exposure.DIRECT_EXPOSURE);
		e4.setDateTime(LocalDateTime.of(2024, 10, 1, 12, 30));
		Exposure e5 = new Exposure(p6.getPatientId());
		e5.setExposureType(Exposure.DIRECT_EXPOSURE);
		e5.setDateTime(LocalDateTime.of(2029, 1, 1, 12, 30));
		Exposure e6 = new Exposure(p7.getPatientId());
		e6.setExposureType(Exposure.DIRECT_EXPOSURE);
		e6.setDateTime(LocalDateTime.of(2028, 6, 1, 12, 30));

		Exposure e7 = new Exposure(p9.getPatientId());
		e7.setExposureType(Exposure.DIRECT_EXPOSURE);
		e7.setDateTime(LocalDateTime.of(2030, 5, 1, 12, 30));
		Exposure e8 = new Exposure(p10.getPatientId());
		e8.setExposureType(Exposure.DIRECT_EXPOSURE);
		e8.setDateTime(LocalDateTime.of(2022, 9, 1, 12, 30));

		Exposure e9 = new Exposure(p2.getPatientId());
		e9.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e10 = new Exposure(p2.getPatientId());
		e10.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e11 = new Exposure(p3.getPatientId());
		e11.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e12 = new Exposure(p4.getPatientId());
		e12.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e13 = new Exposure(p3.getPatientId());
		e13.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e14 = new Exposure(p4.getPatientId());
		e14.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e15 = new Exposure(p2.getPatientId());
		e15.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e16 = new Exposure(p4.getPatientId());
		e16.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e17 = new Exposure(p6.getPatientId());
		e17.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e18 = new Exposure(p2.getPatientId());
		e18.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e19 = new Exposure(p4.getPatientId());
		e19.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e20 = new Exposure(p5.getPatientId());
		e20.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e21 = new Exposure(p7.getPatientId());
		e21.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e22 = new Exposure(p8.getPatientId());
		e22.setExposureType(Exposure.INDIRECT_EXPOSURE);
		Exposure e23 = new Exposure(p9.getPatientId());
		e23.setExposureType(Exposure.INDIRECT_EXPOSURE);

		d.addExposureToPatient(p1.getPatientId(), e1);
		d.addExposureToPatient(p1.getPatientId(), e2);
		d.addExposureToPatient(p1.getPatientId(), e3);

		d.addExposureToPatient(p2.getPatientId(), e4);
		d.addExposureToPatient(p2.getPatientId(), e5);
		d.addExposureToPatient(p2.getPatientId(), e6);

		d.addExposureToPatient(p4.getPatientId(), e7);
		d.addExposureToPatient(p4.getPatientId(), e8);

		// some indirect exposures
		d.addExposureToPatient(p2.getPatientId(), e23);
		d.addExposureToPatient(p2.getPatientId(), e22);
		d.addExposureToPatient(p3.getPatientId(), e20);
		d.addExposureToPatient(p5.getPatientId(), e20);
		d.addExposureToPatient(p6.getPatientId(), e11);
		d.addExposureToPatient(p7.getPatientId(), e9);
		d.addExposureToPatient(p8.getPatientId(), e15);
		d.addExposureToPatient(p9.getPatientId(), e19);
		d.addExposureToPatient(p10.getPatientId(), e13);

		ContactTrace ct = new ContactTrace(d);
		PatientZero findPatientZero = ct.findPatientZero(p1);
		System.out.println(findPatientZero.getExposureDateTime() + " patient name :"
				+ findPatientZero.getPatient().getFirstName());
	}
}
