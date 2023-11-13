package edu.disease.asn6;

/**
 * This class is a container of any type.
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class Container<T> {
	private Object[] arr;
	/**
	 * @throws IllegalArgumentException
	 * @param arr
	 */
	public Container(T... arr) {
		//Must pass at least one argument.
		if(arr.length==0)
			throw new IllegalArgumentException();
		this.arr=new Object[arr.length];
		for(int i=0;i<arr.length;i++)
			this.arr[i]=arr[i];
	}
	
	/**
	 * retrieve data
	 * @param index
	 * @return
	 */
	public T get(int index) {
		if(index<0||index>arr.length)
			throw new IllegalArgumentException();
		return (T) arr[index];
	}
	
	/**
	 * returns number of Elements
	 * @return
	 */
	public int size() {
		return arr.length;
	}
}
