package edu.disease.asn3;

import org.junit.Before;
import org.junit.Test;

public class DiseaseFileRepositoryTest {
	DiseaseFileRepository dr;
	
	@Before
	public void init() {
		dr=new DiseaseFileRepository();
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
//		DiseaseFileRepository obj=new DiseaseFileRepository();
//		obj.setFolderPath("k:\\avenger\\star\\wars");
//		System.out.println(obj.getFolderPath());
	}
	
	@Test
	public void setFolderPathTest_1() {
		
	}
	
	@Test
	public void getFolderPathTest_1() {
		
	}
	
	@Test
	public void saveTest() {
		
	}
	
	@Test
	public void initTest() {
		
	}
}
