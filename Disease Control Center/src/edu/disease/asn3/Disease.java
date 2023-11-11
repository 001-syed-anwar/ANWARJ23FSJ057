package edu.disease.asn3;

import java.io.Serializable;
import java.util.UUID;

/**
 * This is Disease class from edu.disease.asn2 package.
 * 
 * @author Syed Anwar
 *
 */
public abstract class Disease implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6800869897342399386L;
	private UUID diseaseId;
	private String name;

	public abstract String[] getExamples();

	/**
	 * This method returns the diseaseId
	 * 
	 * @return diseaseId as UUID
	 */
	public UUID getDiseaseId() {
		return diseaseId;
	}

	/**
	 * This method sets the diseaseId
	 * 
	 * @param diseaseId as UUID
	 */
	public void setDiseaseId(UUID diseaseId) {
		this.diseaseId = diseaseId;
	}

	/**
	 * This method returns the name
	 * 
	 * @return name as String
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the name
	 * 
	 * @param name as String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method generates hash code based on the given diseaseId
	 * 
	 * @throws NullPointerException
	 */
	@Override
	public int hashCode() {
		return diseaseId.hashCode();
	}

	/**
	 * This method compares the objects based on their diseaseId
	 */
	@Override
	public boolean equals(Object obj) {
		Disease d = (Disease) obj;
		if (diseaseId != null && d.getDiseaseId() != null)
			return this.hashCode() == d.hashCode();
		return false;
	}

	/**
	 * This method returns all the properties of Disease class as string message.
	 */
	@Override
	public String toString() {
		return "Disease [diseaseId=" + diseaseId + ", name=" + name + "]";
	}

}
