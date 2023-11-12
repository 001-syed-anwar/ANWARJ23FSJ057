package edu.disease.asn5;

@SuppressWarnings("unchecked")
public class Container<T> {
	private Object[] arr;
	public Container(T... arr) {
		if(arr.length==0)
			throw new IllegalArgumentException();
		this.arr=new Object[arr.length];
		for(int i=0;i<arr.length;i++)
			this.arr[i]=arr[i];
	}
	
	public T get(int index) {
		if(index<0||index>arr.length)
			throw new IllegalArgumentException();
		return (T) arr[index];
	}
	
	public int size() {
		return arr.length;
	}
}
