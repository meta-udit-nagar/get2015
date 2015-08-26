import java.util.Arrays;

public class ArrayList1 {
	
	public static int defaultSize = 10;
	public static int size=0;
	public static Object data[] = new Object[defaultSize];
	
	public static int index;
	
	
	public  void add(Object value){
		if(size == data.length ){
			increaseCapacity();
		}
		data[size++] = value;
	
		
	}
	
	public void merge(){
		if((ArrayList2.size + size) >= data.length ){
			increaseCapacity();
		}
		for(int i = 0; i < ArrayList2.size;i++)
		add(ArrayList2.newData[i]) ;	
		System.out.println("both list merged");
		
	}
	public static void increaseCapacity(){
		int newsize = data.length * 2;
		data = Arrays.copyOf(data, newsize);
	}
	
		public Object get(int i) {
		if(index==-1){
			return 0;
		}
		else
		return data[i];
		
	}
	
	public  static void reverse() {
		  if(data == null || data.length <= 1){
	            System.out.println("either list is empty or have one element");
	        }       
	        
	        for (int i = 0; i < data.length / 2; i++) {
	            Object temp = data[i]; // swap numbers
	            data[i] = data[data.length - 1 - i];
	            data[data.length - 1 - i] = temp;
	        }
	        System.out.println("Array is reversed  " );
	        
	}
	
	 public static void add(int position, Object value) {
			
		 int flag=0;	
		 size++;
		if(position < size){
			flag=1;
		}
		if(flag==1){
		int index1=-1;
			Object myStore1[]=new Object[data.length-position];
			
		if(size<defaultSize){
			for(int j=position;j<size;j++){
				index1++;
				myStore1[index1]=data[j];	
			}
				
			data[position]=value;
			for(int k=0;k<index1;k++){
				 position++;
				data[position]=myStore1[k];
			}
			index++;
			}
		else{
			for(int j=position;j<size;j++){
				index1++;
				myStore1[index1]=data[j];	
			}
			increaseCapacity();
				
			data[position]=value;
			for(int k=0;k<index1;k++){
				position++;
				data[position]=myStore1[k];
			}
			index++;
			}
			}
		else{
			System.out.println("Array index out of bound");
			size--;
			}
	 }
	 
	
	 public static int retrieveFirstOccuerence(int position,Object value)
	 {
		 int index1 = 0,flag=-1;
		  position++;
		 for(int i=position; i < size; i++){
		    	if(data[i]==value){
		    		flag=0;
		    		index1=i;
		    		break;
		    	}
		  }
		 if(flag==0){
			return index1;
		 }
		 else{
			return flag;
		 }
	 }

	 public static int retrieveFirstIndexOfParticularItem(Object value) {
			// TODO Auto-generated method stub
			int index2 = 0,flag = -1;
			for(int i = 0; i < size; i++){
				if(data[i]==value){
					flag=1;
					index2=i;
					break;
				}
			}
			if(flag==1){
				return index2;
				
			}
			else{
				return flag;
			}
		}
	 
	
	 public static void remove(int position) {
			// TODO Auto-generated method stub
			if(position >= size){
				System.out.println("Array index out of bound");
			}
			else{
	        for(int i = position+1; i < size; i++)
	        {
	        	data[i-1] = data[i];
	        	
	        }
	        size--;
	        index--;
	        System.out.println("Item deleted from index "+ position);
			}
		}
	 
	 public static void removeValue(Object value) {
			// TODO Auto-generated method stub
			int flag = 0;
			int index2 = 0;
			for(int i = 0; i < size;i++){
				if(data[i]==value){
					flag=1;
					index2=i;
					break;
				}
			}
			if(flag == 1){
				 for(int i = index2+1; i < size; i++) {
			        	data[i-1] = data[i];
			        }
			     size--;
			     index--;
			     System.out.println(value+" deleted");
			}
			else{
				System.out.println(value+" not exist in list");
			}
		}
		 public static void removeAll() {
			int flag=0;
			if(size>0){
			 flag=1;
			 
			}
			if(flag==1){
				size=0;
				index=-1;
				System.out.println("All elewments are removed from list");
			}
			else
			  System.out.println("list is already empty");
		}
	 public static void show(){
		 for(int i = 0; i < size; i++){
			 System.out.println(data[i]);
		 }
	 }

}
