package edu.disease.asn2;

/**
 * This class inherits the abstract class Disease
 * 
 * @author Syed Anwar
 *
 */
public class InfectiousDisease extends Disease {

	/**
	 * This method returns few examples of infectious diseases
	 * 
	 * @return infectiousDisease as String[]
	 */
	@Override
	public String[] getExamples() {
		String[] infectiousDisease = { "Flu", "TB", "Malaria", "COVID-19 " };
		return infectiousDisease;
	}

}
