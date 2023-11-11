package edu.disease.asn4;

import java.io.Serializable;

/**
 * This class inherits the abstract class Disease
 * 
 * @author Syed Anwar
 *
 */
public class InfectiousDisease extends Disease implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5294852647863725219L;

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
