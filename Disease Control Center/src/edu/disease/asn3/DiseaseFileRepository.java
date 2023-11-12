package edu.disease.asn3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DiseaseFileRepository {
	private String folderPath = ".";

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

	public void setFolderPath(String folderPath) {
		File f=new File(folderPath);
		if(!f.isDirectory()) {
//			System.out.println("Invalid path");
//			return;
			if(!f.mkdirs()) {
				System.out.println("Invalid drive");
				return;
			}
		}
		this.folderPath = folderPath;
	}

	public void save(Disease[] diseases, Patient[] patients) {
		doSerialize(diseases, folderPath, "diseases.dat");
		doSerialize(patients, folderPath, "patients.dat");
	}

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
