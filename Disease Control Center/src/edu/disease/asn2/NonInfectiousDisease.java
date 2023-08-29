package edu.disease.asn2;

/**
 * This class inherits the abstract class Disease
 * 
 * @author Syed Anwar
 *
 */
public class NonInfectiousDisease extends Disease {

	/**
	 * This method returns few examples of non infectious diseases
	 * 
	 * @return nonInfectiousDisease as String[]
	 */
	@Override
	public String[] getExamples() {
		String[] nonInfectiousDisease = { "Diabetes", "Hypertension", "Alzheimer's Disease", "Osteoarthritis" };
		return nonInfectiousDisease;
	}

}
