public class IntIntegerDiff {
	public static void main(String[] args) 
	{
		//it will call function Integer.valueOf(2) method to convert int to Integer
		Integer i = 2;
		int j=i;
		System.out.println("j = "+j);
		int k = 4;//Primitive data type
		System.out.println("input i and i1 = " + i + " and " + k);
		changeInteger(i, k);//here the value of i1 and the reference value of i will be passed but
		                    //since the Integer is immutable so it won't update the value of original variable 
		System.out.println("2.output i and i1 = " + i + " and " + k);//old value will  print as an output
	}

	private static void changeInteger(Integer i, Integer j) {
		i = 5; 
		        //it will not reflect in the original variable
		      
		j = 5;
		       //it will not reflect in the original variable
		System.out.println("1.output i and i1 = " + i + " and " + j);
	}
}
