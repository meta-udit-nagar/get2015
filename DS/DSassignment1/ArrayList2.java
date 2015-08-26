import java.util.Arrays;

public class ArrayList2 {
	public static int defaultSize = 10;
	public static int size=0;
	public static Object newData[] = new Object[defaultSize];
	int index = 0;

	public static void add(Object value){
		
		if(size == newData.length ){
			increaseCapacity();
		}
		
		newData[size] = value;
		
		size++;
	}
		
	public static void increaseCapacity(){
		int newsize = newData.length * 2;
		newData = Arrays.copyOf(newData, newsize);
	}
	
	public int size() {
		
		return size;
		
	}
	
}
