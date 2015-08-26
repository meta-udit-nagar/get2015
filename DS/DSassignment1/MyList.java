import java.util.Scanner;

public class MyList {
	
	
	
	public int index;
	
	Scanner scan = new Scanner(System.in);
	
	ArrayList1 arrayList1Object = new ArrayList1();
	Object value;
	
	public static void main(String[] args)
	{
		MyList object = new MyList();
		object.arrayOperations();
	}
		
	public void arrayOperations()
	{
	int loopVar = 0;
	
	do {
		System.out.println("enter your choice\n1. adding an element" +
				"\n2. adding an element at particular location" +
				"\n3. Retrieving the first occurrence of an item" +
				"\n4. Retrieving the first index of particular item" +
				"\n5. Removing an item based on particular location" +
				"\n6. Remove given particular item from the arraylist " +
				"\n7. Clear the list " +
				"\n8. Reverse the arraylist" +
				"\n9. show list" +
				"\n10 add elements in list2 " +
				"\n11 merge the lists");
		
		int choice = 0;
		try {
			choice = scan.nextInt();
		} catch (Exception e) {
			System.out.println("please enter integer values only!");;
		}
		switch (choice) {
		case 1:
			System.out.println("how many elements you want to enter");
			int number = scan.nextInt();
			for(int i = 0; i < number; i++){
			System.out.println("enter the element");
			value = scan.nextInt();
			arrayList1Object.add(value);
			}
			for(int i=0;i<arrayList1Object.size;i++){
				
					System.out.println(arrayList1Object.get(i));
			}
			
			break;
		
		case 2:
			System.out.println("enter the index at which you want to store the element");
			index = scan.nextInt();
			System.out.println("enter the value");
			value = scan.nextInt();
			ArrayList1.add(index, value);
			for(int i=0;i<arrayList1Object.size;i++){
				
				System.out.println(arrayList1Object.get(i));
			}
			break;
		case 3:
			System.out.println("enter the index from where you want to retrieve the element");
			index = scan.nextInt();
			System.out.println("enter the value");
			value = scan.nextInt();
			int returnValue = ArrayList1.retrieveFirstOccuerence(index, value);
			if(returnValue==-1){
		    	System.out.println(value+" not found after index " + index);
		    }
		    else{
		    	System.out.println(value+" found at index " + returnValue);
		    }
			break;
		case 4:
			System.out.println("enter the value");
			value = scan.nextInt();
			returnValue = ArrayList1.retrieveFirstIndexOfParticularItem(value);
			if(returnValue == -1){
		    	System.out.println(value+" not found in list");
		    }
		    else{
		    	System.out.println(value+" found at index "+returnValue);
		    }
			break;
		case 5:
			System.out.println("enter the index from where you want to delete the element");
			index = scan.nextInt();
			ArrayList1.remove(index);
			break;
		case 6:
			System.out.println("enter the value");
			value = scan.nextInt();
			ArrayList1.removeValue(value);
			break;
		case 7:
			ArrayList1.removeAll();
			break;
		case 8:
			ArrayList1.reverse();
			break;
		case 9:
			ArrayList1.show();
			break;
		case 10:
			ArrayList2 ob = new ArrayList2();
			System.out.println("how many elements you want to enter");
			number = scan.nextInt();
			for(int i = 0; i < number; i++){
			System.out.println("enter the value");
			value = scan.nextInt();
			ob.add(value);
			}
			break;
		case 11:
			arrayList1Object.merge();
			break;
		default :
			System.out.println("enter proper input");
		}
		System.out.println("\ndo you want to continue?\n1. yes\n2. no");
		try {
			loopVar = scan.nextInt();
		} catch (Exception e) {
			System.out.println("enter valid input!");
		}
	}while(loopVar==1);
	}}
