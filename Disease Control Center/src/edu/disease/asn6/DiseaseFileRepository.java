package edu.disease.asn6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

@SuppressWarnings("unchecked")
public class DiseaseFileRepository {
	private String folderPath = ".";

	public String getFolderPath() {
		File file = new java.io.File(folderPath);
		String path=null;;
		try {
			path = file.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}

	public void save(List<Disease> diseases, List<Patient> patients) {
		doSerialize(diseases,folderPath,"diseases.dat");
		doSerialize(patients,folderPath,"patients.dat");
	}

	public DiseaseAndPatient init(String folderPath) {
		List<Disease> diseases=(List<Disease>)doDeserialize(folderPath,"diseases.dat");
		List<Patient> patients=(List<Patient>)doDeserialize(folderPath,"patients.dat");
		DiseaseAndPatient obj=new DiseaseAndPatient();
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
		Object readObject=null;
		try(FileInputStream fis=new FileInputStream(folderPath+"\\"+fileName);
				ObjectInputStream deserialize=new ObjectInputStream(fis);){
			readObject = deserialize.readObject();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return readObject;
	}
	
	public static void main(String[] args) {
//		UUID d1Id=UUID.randomUUID();
//		UUID d2Id=UUID.randomUUID();
//		Disease d1=new InfectiousDisease();
//		d1.setName("corona");
//		d1.setDiseaseId(d1Id);
//		Disease d2=new InfectiousDisease();
//		d2.setName("tb");
//		d2.setDiseaseId(d2Id);
//		Disease[] diseases= {d1,d2};
//		
//		Patient p1=new Patient(2,3);
//		p1.addDiseaseId(d1Id);
//		p1.setFirstName("syed");
//		p1.setLastName("anwar");
//		Patient p2=new Patient(1,1);
//		p2.addDiseaseId(d2Id);
//		p2.setFirstName("rahman");
//		p2.setLastName("khan");
//		Patient[] patients= {p1,p2};
//		
//		DiseaseFileRepository rep=new DiseaseFileRepository();
//		rep.save(diseases, patients);
//		DiseaseAndPatient init = rep.init(".");
//		diseases=init.getDiseases();
//		for(Disease d:diseases) {
//			System.out.println(d.getName());
//		}
//		patients=init.getPatients();
//		for(Patient p:patients) {
//			System.out.println(p);
//		}
	}
}
