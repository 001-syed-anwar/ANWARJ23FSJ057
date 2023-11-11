package edu.disease.asn4;

import java.io.Serializable;

/**
 * This class inherits the abstract class Disease
 * 
 * @author Syed Anwar
 *
 */
public class NonInfectiousDisease extends Disease implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -262517088491057267L;

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
