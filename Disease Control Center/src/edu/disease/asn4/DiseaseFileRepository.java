package edu.disease.asn4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class Serializes and Deserializes Diseases and Patients.
 * 
 * @author Syed Anwar
 */
public class DiseaseFileRepository {
	private String folderPath = ".";

	/**
	 * Getter method of folderPath
	 * 
	 * @return
	 */
	public String getFolderPath() {
		File file = new File(folderPath);
		String path = null;
		try {
			path = file.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	/**
	 * Setter method of folderPath
	 * 
	 * @param folderPath
	 */
	public void setFolderPath(String folderPath) {
		File f = new File(folderPath);
		// If directories does not exists, then creates and sets the folderPath.
		if (!f.isDirectory() && !f.mkdirs())
			throw new IllegalArgumentException("Invalid drive");
		this.folderPath = folderPath;
	}

	/**
	 * Save method serializes diseases and patients
	 * 
	 * @param diseases
	 * @param patients
	 */
	public void save(Disease[] diseases, Patient[] patients) {
		doSerialize(diseases, folderPath, "diseases.dat");
		doSerialize(patients, folderPath, "patients.dat");
	}

	/**
	 * Init method deserializes the diseases and patients.
	 * 
	 * @param folderPath
	 * @return
	 */
	public DiseaseAndPatient init(String folderPath) {
		Disease[] diseases = (Disease[]) doDeserialize(folderPath, "diseases.dat");
		Patient[] patients = (Patient[]) doDeserialize(folderPath, "patients.dat");
		DiseaseAndPatient obj = new DiseaseAndPatient();
		obj.setDiseases(diseases);
		obj.setPatients(patients);
		return obj;
	}

	private void doSerialize(Object obj, String folderPath, String fileName) {
		try (FileOutputStream fos = new FileOutputStream(folderPath + "\\" + fileName);
				ObjectOutputStream serialize = new ObjectOutputStream(fos);) {
			serialize.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object doDeserialize(String folderPath, String fileName) {
		Object readObject = null;
		try (FileInputStream fis = new FileInputStream(folderPath + "\\" + fileName);
				ObjectInputStream deserialize = new ObjectInputStream(fis);) {
			readObject = deserialize.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return readObject;
	}
}
