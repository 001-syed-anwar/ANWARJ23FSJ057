package assignments3;

import java.util.Arrays;
import java.util.HashMap;

/**
 * This class can used as a dynamic integer array. Most of the basic array
 * operations can be done using methods of this class. We can perform basic
 * operations such as get, add, set, delete elements. We can get the array size,
 * find an element, find frequency of an element ,find minimum and maximum
 * element, calculation of sum, average, sorting, reversing and displaying the
 * array elements as a string can be done using methods of this class.
 * 
 * @author Syed Anwar
 * @category Array Operations
 */
public class DynamicArray {
	/*
	 * variable 'arr' is the actual int[] array being used behind the scenes.
	 * variable 'size' is the actual array size. variable 'length' is what user gets
	 * as array size. variable 'min' stores the minimum element of array and 'max'
	 * stores maximum element of array. variable 'sum' stores the sum of all
	 * elements. The 'frequency' variable stores the frequency of elements. The
	 * variable 'toStringMsg' is used for traversing array and displaying the
	 * elements as a string. The boolean variables are used for optimizations. I've
	 * tried my best to optimize the code quality and efficiency.
	 */
	private int[] arr;
	private int size = 10, length = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
	private boolean arrayUpdated = false, sorted = false, minUpdated = false, maxUpdated = false;
	private HashMap<Integer, Integer> frequency = new HashMap<>();
	private StringBuilder toStringMsg = new StringBuilder("[");

	/**
	 * Default constructor.
	 */
	public DynamicArray() {
		// initializes array with size 10
		this.arr = new int[this.size];
	}

	/**
	 * This function returns the size of the Dynamic Array.
	 * 
	 * @return int
	 */
	public int size() {
		/*
		 * Returning the array length that we have used up until now and not the actual
		 * array size.
		 */
		return this.length;
	}

	/**
	 * This function returns the element of array with the given index position.
	 * @throws IndexOutOfBoundsException
	 * @param index as int
	 * @return int
	 */
	public int get(int index) {
		/*
		 * Throws exception if user tries to input invalid parameter. Negative index
		 * will be handled by default but we should verify whether user's input index is
		 * less than this.length.
		 */
		if (index < 0 || index >= this.length)
			throw new IndexOutOfBoundsException(index);

		// otherwise return the element
		return this.arr[index];
	}

	/**
	 * This function add element into the array.
	 * 
	 * @param element as int
	 */
	public void add(int element) {
		/*
		 * Doubling the array size whenever it needs to be extended.
		 */
		if (this.length == this.size) {
			this.size = size * 2;
			/*
			 * System.arraycopy() would work but to use System.arraycopy we would need to
			 * create an array. Arrays.copyOf() might use an auxiliary array internally but
			 * using Arrays.copyOf() is easier.
			 */
			this.arr = Arrays.copyOf(this.arr, this.size);
		}

		// Inserting the element to the and post incrementing length
		this.arr[length++] = element;

		/*
		 * Storing the array elements in toStringMsg without actually traversing the
		 * whole array to save time and increase performance.
		 */
		this.toStringMsg.append(element);
		this.toStringMsg.append(", ");

		/*
		 * Updating the frequency of elements in map to avoid traversing through the
		 * elements and save time.
		 */
		this.frequency.put(element, this.frequency.getOrDefault(element, 0) + 1);

		// updating the sum of elements on the way we insert an element into the array.
		this.sum += element;

		// Updating min and max on the way we insert an element into the array.
		this.min = (element < this.min) ? element : this.min;
		this.max = (element > this.max) ? element : this.max;

		// Assuming that array is unsorted whenever we insert a new element
		this.sorted = false;
	}

	/**
	 * This function removes an element with the given index position.
	 * @throws IndexOutOfBoundsException
	 * @param index as int
	 */
	public void remove(int index) {
		/*
		 * Throws exception if user tries to input invalid parameter. Negative index
		 * will be handled by default but we should verify whether user's input index is
		 * less than this.length.
		 */
		if (index < 0 || index >= this.length)
			throw new IndexOutOfBoundsException(index);

		/*
		 * Storing the element into a variable for updating the status of boolean
		 * variables.
		 */
		int element = this.arr[index];

		// Shifting the elements from the index to be deleted by one index.
		DynamicArray.shiftElements(this.arr, this.length--, this.size, index);

		// Updating the arrayUpdated status to true
		this.arrayUpdated = true;

		// Updating the sorted status to false
		this.sorted = false;

		// Updating the frequency of the element
		this.frequency.put(element, this.frequency.get(element) - 1);

		// updating the sum
		this.sum -= element;

		// updating the min and max status if necessary
		this.minUpdated = (element == this.min) ? true : this.minUpdated;
		this.maxUpdated = (element == this.max) ? true : this.maxUpdated;
	}

	/**
	 * This function returns the frequency of an element.
	 * 
	 * @param element as int
	 * @return as int
	 */
	public int getFrequency(int element) {
		/*
		 * Making use of getOrDefault method to handle the case where the element is not
		 * present in the array
		 */
		return this.frequency.getOrDefault(element, 0);
	}

	/**
	 * This function returns the sum of all elements in the array.
	 * 
	 * @return int
	 */
	public int getSum() {
		/*
		 * returning the sum directly since we are updating the sum of elements whenever
		 * there is a change in array such us Insertion, deletion and updating elements.
		 * So now the calculation of sum is done is o(1) constant time.
		 */
		return this.sum;
	}

	/**
	 * This function returns the average among all elements in array.
	 * 
	 * @return double
	 */
	public double getAverage() {
		/*
		 * Since we are having the updated sum and updated length of array, the
		 * calculation of average also can be done in o(1) constant time.
		 */
		double n = this.length;
		double avg = sum / n;
		return avg;
	}

	/**
	 * This function returns the minimum element of the array.
	 * @throws IllegalAccessError
	 * @return int
	 */
	public int getMinimum() {
		/*
		 * Throwing exception when user tries to use this function without when the
		 * array is null
		 */
		if (this.length == 0)
			throw new IllegalAccessError("The Array is null!");

		/*
		 * If minimum element is not updated then we can directly return the 'min'
		 * variable.
		 */
		if (!minUpdated)
			return this.min;

		/*
		 * Otherwise calculate minimum again and set minimum element update status to
		 * false again.
		 */
		this.min = DynamicArray.updateMin(this.arr, this.length);
		this.minUpdated = false;

		// return the 'min' variable.
		return this.min;
	}

	/**
	 * This function returns the maximum element of the array.
	 * @throws IllegalAccessError
	 * @return int
	 */
	public int getMaximum() {
		/*
		 * Throwing exception when user tries to use this function without when the
		 * array is null
		 */
		if (this.length == 0)
			throw new IllegalAccessError("The Array is null!");

		/*
		 * If Maximum element is not updated then we can directly return the 'max'
		 * variable.
		 */
		if (!maxUpdated)
			return this.max;

		/*
		 * Otherwise calculate Maximum again and set Maximum element update status to
		 * false again.
		 */
		this.max = DynamicArray.updateMax(this.arr, this.length);
		this.maxUpdated = false;

		// return the 'max' variable.
		return this.max;
	}

	/**
	 * This function sets an element in specific index of the array.
	 * @throws IndexOutOfBoundsException
	 * @param element as int
	 * @param index   as int
	 */
	public void set(int element, int index) {
		/*
		 * Throws exception if user tries to input invalid parameter. Negative index
		 * will be handled by default but we should verify whether user's input index is
		 * less than this.length.
		 */
		if (index < 0 || index >= this.length)
			throw new IndexOutOfBoundsException(index);

		// Storing the previous element into a variable.
		int prevElement = this.arr[index];

		/*
		 * If the new element is same as previous element then we don't need to set it
		 * explicitly again and we can return simply.
		 */
		if (prevElement == element)
			return;

		/*
		 * If the new element is lesser than the minimum element of array then update
		 * the new element as the new minimum or if the previous element was the minimum
		 * element that means we have lost the minimum element so update the
		 * 'minUpdated' status to true.
		 */
		if (element < this.min)
			this.min = element;
		else if (prevElement == this.min)
			this.minUpdated = true;

		/*
		 * If the new element is greater than the maximum element of array then update
		 * the new element as the new maximum or if the previous element was the maximum
		 * element that means we have lost the maximum element so update the
		 * 'maxUpdated' status to true.
		 */
		if (element > this.max)
			this.max = element;
		else if (prevElement == this.max)
			this.maxUpdated = true;

		// update the frequency.
		this.frequency.put(element, frequency.getOrDefault(element, 0) + 1);
		this.frequency.put(prevElement, frequency.get(prevElement) - 1);

		// update the sum.
		this.sum += element;
		this.sum -= prevElement;

		// update the 'arrayUpdated' status to true.
		this.arrayUpdated = true;

		// update the 'sorted' status to true.
		this.sorted = false;

		// finally update the new element into the array.
		this.arr[index] = element;
	}

	/**
	 * This element finds an element and returns it's position.
	 * 
	 * @param element as int
	 * @return int
	 */
	public int find(int element) {
		// If length is 0 then it means array is null no return -1
		if (this.length == 0)
			return -1;

		// if array is sorted then search optimally using binarySearch.
		if (sorted)
			return binarySearch(this.arr, 0, this.length - 1, element);

		/*
		 * if array is not sorted then search by traversing through the array one by
		 * one.
		 */
		return search(this.arr, 0, this.length - 1, element);
	}

	/**
	 * This function finds an element starting from a specific index.
	 * 
	 * @param element as int
	 * @param from    as int
	 * @return int
	 */
	public int find(int element, int from) {
		/*
		 * If 'from' is exceeding the array size then there's nothing find from so
		 * simply return.
		 */
		if (from >= this.length)
			return -1;

		// if array is sorted then search optimally using binarySearch.
		if (sorted)
			return binarySearch(this.arr, from, this.length - 1, element);

		/*
		 * if array is not sorted then search by traversing through the array one by
		 * one.
		 */
		return search(this.arr, from, this.length - 1, element);
	}

	/**
	 * This function reverses the array elements.
	 */
	public void reverse() {
		/*
		 * As long as there are more than 1 elements only then reverse otherwise simply
		 * return.
		 */
		if (this.length > 1) {
			// reverse the array
			reverse(this.arr, 0, this.length - 1);

			// update the 'arrayUpdated' and 'sorted' statuses and return.
			this.arrayUpdated = true;
			this.sorted = false;
			return;
		}
	}

	/**
	 * This function traverse through the elements and returns the array elements as
	 * string.
	 * 
	 * @return String
	 */
	public String displayArray() {
		/*
		 * If array is updated then iteratively loop through the array and update the
		 * 'toStringMsg' and update the arrayUpdated status to false again.
		 */
		if (arrayUpdated) {
			this.toStringMsg = DynamicArray.updateToStringMsg(this.arr, this.length, this.toStringMsg);
			this.arrayUpdated = false;
		}

		/*
		 * Create a new StringBuilder object and delete the comma and space if there are
		 * elements.
		 */
		int length = toStringMsg.length();
		StringBuilder toReturn = new StringBuilder(this.toStringMsg);

		if (this.length > 0)
			toReturn.delete(length - 2, length);

		toReturn.append("]");

		/*
		 * Then return the String version of the StringBuilder. The reason behind not
		 * using String directly is because to avoid new objects getting created every
		 * time we perform concatenation.
		 */
		return toReturn.toString();
	}

	/**
	 * This functions sorts the array in ascending order.
	 */
	public void sort() {
		// Since array elements are less than 2 we can directly return.
		if (this.length <= 1)
			return;

		// Sort the array using merge sort.
		DynamicArray.mergeSort(arr, 0, length - 1, new int[length]);

		// Update the 'arrayUpdated' and 'sorted' statuses to true.
		this.arrayUpdated = true;
		this.sorted = true;
	}

	/**
	 * The toString method also returns the array elements in a String.
	 */
	@Override
	public String toString() {
		// returns the array elements as a String.
		return displayArray();
	}

	/**
	 * @hidden
	 * @param arr    as int[]
	 * @param length as int
	 * @param size   as int
	 * @param delete as int
	 */
	private static void shiftElements(int[] arr, int length, int size, int delete) {
		/*
		 * Iteratively shift the element
		 */
		for (int i = delete; i < length; i++) {
			// handling the case when i+1 is not possible.
			if (i == size - 1)
				continue;
			arr[i] = arr[i + 1];
		}
	}

	/**
	 * @hidden
	 * @param arr         as int[]
	 * @param length      as int
	 * @param toStringMsg as StringBuilder
	 * @return as StringBuilder
	 */
	private static StringBuilder updateToStringMsg(int[] arr, int length, StringBuilder toStringMsg) {
		/*
		 * Iteratively generating new 'toStringMsg'
		 */
		toStringMsg = new StringBuilder("[");
		for (int i = 0; i < length; i++) {
			toStringMsg.append(arr[i]);
			toStringMsg.append(", ");
		}
		return toStringMsg;
	}

	/**
	 * @hidden
	 * @param arr    as int
	 * @param length as int
	 * @return as int
	 */
	private static int updateMin(int[] arr, int length) {
		/*
		 * Iteratively update new 'min'
		 */
		int min = arr[0];
		for (int i = 1; i < length; i++)
			if (arr[i] < min)
				min = arr[i];
		return min;
	}

	/**
	 * @hidden
	 * @param arr    as int[]
	 * @param length as int
	 * @return as int
	 */
	private static int updateMax(int[] arr, int length) {
		/*
		 * Iteratively update new 'max'
		 */
		int max = arr[0];
		for (int i = 1; i < length; i++)
			if (arr[i] > max)
				max = arr[i];
		return max;
	}

	/**
	 * @hidden
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void reverse(int[] arr, int i, int j) {
		/*
		 * Recursively swap the i and j
		 */
		if (i < j) {

			/*
			 * Initially, arr[i] = arr[i] ^ arr[j] then, arr[j] = arr[j] ^ arr[i] ^ arr[j]
			 * because arr[i] is updated in the first statement to arr[i] ^ arr[j]. So, the
			 * same element that occurred twice will be removed and that's how we'r
			 * utilizing the The Xor operator property to perform swap operation.
			 */
			arr[i] ^= arr[j];
			arr[j] ^= arr[i];
			arr[i] ^= arr[j];

			reverse(arr, i + 1, j - 1);
		}
	}

	/**
	 * @hidden
	 * @param arr   as int[]
	 * @param left  as int
	 * @param right as int
	 * @param temp  as int[]
	 */
	private static void mergeSort(int[] arr, int left, int right, int[] temp) {
		/*
		 * Dividing the array by two parts, for every i and j we're merging the sorted
		 * array. I'm saying sorted array because, Since we're using recursion and
		 * dividing the array until it cannot be divided into two parts, first we solve
		 * the smallest sub arrays and then a bigger ones and then much bigger ones
		 * until we reach the whole array size. Sorting the two sorted sub arrays can be
		 * done in o(n) by using two pointers, one pointer for each arrays. The division
		 * by two parts takes log base 2 time. Together it takes o(n log n) time
		 * complexity to sort the array. But it requires o(n) extra space.
		 */

		/*
		 * The base case that stops the recursion calls when the array can not be
		 * divided further.
		 */
		if (left >= right)
			return;

		/*
		 * Separate the array by two parts. When the array is even it would two equal
		 * parts.
		 */
		int mid = (left + right) / 2;

		// recursively call and sort the first part
		mergeSort(arr, left, mid, temp);

		// recursively call and sort the second part
		mergeSort(arr, mid + 1, right, temp);

		// recursively merge both parts for each sub arrays and finally the main array.
		merger(arr, left, mid, right, temp);
	}

	/**
	 * @hidden
	 * @param arr   as int[]
	 * @param left  as int
	 * @param mid   as int
	 * @param right as int
	 * @param temp  as int
	 */
	private static void merger(int[] arr, int left, int mid, int right, int[] temp) {
		/*
		 * Copy the elements of actual array from left to right to the auxiliary array
		 * temp.
		 */
		for (int i = left; i <= right; i++)
			temp[i] = arr[i];

		/*
		 * i and j are the pointers for two sorted sub arrays. With the help of mid we
		 * can easily find that two sorted sub arrays.
		 */
		int i = left;
		int j = mid + 1;

		// k is the pointer for the actual array.
		int k = left;

		/*
		 * As long as any of the pointer doesn't reach it's end, we can continue to
		 * compare and sort.
		 */
		while (i <= mid && j <= right) {
			if (temp[i] <= temp[j])
				arr[k++] = temp[i++];
			else
				arr[k++] = temp[j++];
		}

		/*
		 * There could be cases where, The pointer of one element has reached it's end
		 * but the other one doesn't. So in this case, we copy the elements which are
		 * left to the actual array.
		 */
		while (i <= mid)
			arr[k++] = temp[i++];
		while (j <= right)
			arr[k++] = temp[j++];
	}

	/**
	 * @hidden
	 * @param arr    as int[]
	 * @param i      as int
	 * @param j      as int
	 * @param toFind as int
	 * @return int
	 */
	private static int binarySearch(int[] arr, int i, int j, int toFind) {

		// Binary search finds an element in the array in o(log n) time complexity.

		/*
		 * The base case of recursive method and solves the case where the element to be
		 * found does not exist.
		 */
		if (i == j)
			return -1;

		// Taking the mid value to divide and search independently.
		int mid = (i + j) / 2;

		/*
		 * if considering element is lesser than or equal to mid, it means the element
		 * is on the left side of the array. So this recursively search in left array as
		 * long as the element is lesser than or equal to mid value.
		 */

		if (toFind <= arr[mid]) {
			if (arr[mid] == toFind) // if match found then return;
				return mid;
			return binarySearch(arr, i, mid, toFind);
		} else {
			/*
			 * If the above condition does not satisfy, then the element is on the right
			 * side. So, this recursively calls as long as element is on the right side of
			 * the array.
			 */
			if (arr[mid + 1] == toFind)// A small optimization to traditional binary search implementation.
				return mid + 1;
			return binarySearch(arr, mid + 1, j, toFind);
		}
	}

	/**
	 * @hidden
	 * @param arr    as int[]
	 * @param i      as int
	 * @param j      as int
	 * @param toFind as int
	 * @return int
	 */
	private static int search(int[] arr, int i, int j, int toFind) {
		// Iteratively finding the element.
		for (int start = i; i <= j; start++)
			if (arr[start] == toFind)
				return start;
		return -1;
	}

}