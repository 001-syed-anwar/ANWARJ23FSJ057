package edu.disease.asn6;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class DiseaseFileRepositoryTest {
	private DiseaseFileRepository dr;
	private List<Disease> diseases = new ArrayList<>();
	private List<Patient> patients = new ArrayList<>();

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
		diseases.add(d1);
		diseases.add(d2);
		Patient p1 = new Patient();
		p1.addDiseaseId(d1Id);
		p1.setFirstName("syed");
		p1.setLastName("anwar");
		Patient p2 = new Patient();
		p2.addDiseaseId(d2Id);
		p2.setFirstName("rahman");
		p2.setLastName("khan");
		patients.add(p1);
		patients.add(p2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setFolderPathTest_1() {
		dr.setFolderPath("z:test");
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
