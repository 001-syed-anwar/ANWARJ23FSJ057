package edu.disease.asn3;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class DiseaseFileRepositoryTest {
	private DiseaseFileRepository dr;
	private Disease[] diseases = new Disease[2];
	private Patient[] patients = new Patient[2];

	@Before
	public void init() {
		dr = new DiseaseFileRepository();
		UUID d1Id = UUID.randomUUID();
		UUID d2Id = UUID.randomUUID();
		Disease d1 = new InfectiousDisease();
		d1.setName("corona");
		d1.setDiseaseId(d1Id);
		Disease d2 = new InfectiousDisease();
		d2.setName("tb");
		d2.setDiseaseId(d2Id);
		diseases[0] = d1;
		diseases[1] = d2;
		Patient p1 = new Patient(2, 3);
		p1.addDiseaseId(d1Id);
		p1.setFirstName("syed");
		p1.setLastName("anwar");
		Patient p2 = new Patient(1, 1);
		p2.addDiseaseId(d2Id);
		p2.setFirstName("rahman");
		p2.setLastName("khan");
		patients[0] = p1;
		patients[1] = p2;
	}

	@Test(expected = IllegalArgumentException.class)
	public void setFolderPathTest_1() {
		dr.setFolderPath("Z:test");
	}

	@Test
	public void setFolderPathTest_2() {
		dr.setFolderPath("test");
		assertNotNull(dr.getFolderPath());
	}

	@Test
	public void getFolderPathTest_1() {
		assertNotNull(dr.getFolderPath());
	}

	@Test
	public void saveTest() {
		dr.save(diseases, patients);
		File temp = new File(dr.getFolderPath() + "\\diseases.dat");
		assertTrue(temp.isFile());
		temp = new File(dr.getFolderPath() + "\\patients.dat");
		assertTrue(temp.isFile());
	}

	@Test
	public void initTest() {
		DiseaseAndPatient init = dr.init(dr.getFolderPath());
		assertNotNull(init);
	}
}
