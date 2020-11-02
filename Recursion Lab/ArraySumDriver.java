/**
 * 
 * @author Darren King
 *
 */
public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		
		myArray[index++] = 13;
		myArray[index++] = 5;
		myArray[index++] = 12;
		myArray[index++] = 6;
		
		int sum = sumOfArray(myArray, 3);
		System.out.println(sum);
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		
		sum = sumOfArray(myArray, 5);
		System.out.println(sum);
		
		System.out.println(fibbonacci(5));
	}
	
	/**
	 * Recursive method for generating sum of values in array
	 * @param arr array of Integers
	 * @param num index of array to sum all previous index values (including num)
	 * @return sum of array values
	 */
	public static int sumOfArray(Integer[] arr, int num) {
		int sum = arr[num];
		if(num == 0) {
			return sum;
		}
		else {
			sum += sumOfArray(arr, num - 1);
		}
		return sum;
	}
	
	public static int fibbonacci(int n) {
		int arr[] = new int[n+2];
		if(n == 0) {
			return 1;
		}
		if(arr[n] != 0) {
			return arr[n];
		}
		if(arr[n-1] != 0) {
			arr[n] = n * arr[n-1];
			return arr[n];
		}
		else {
			arr[n-1] = fibbonacci(n-1);
			arr[n] = n * arr[n-1];
			return arr[n];
		}
	}

}
