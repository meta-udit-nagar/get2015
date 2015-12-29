
public class DAta {
	
	Integer integer = new Integer(8);
	int ab=5;
	public void add(Integer a)
	{
		a=++a;
		System.out.println(a);
		ab=
		integer = integer+a;
		
	}
	public void display() {
		System.out.println("integer" + integer);
	}
	
	public static void main(String args[])
	{
		Integer a=new Integer(5);
		int b=6;
		DAta ata=new DAta();
		ata.add(a);
		ata.display();
		System.out.println("Integer value ="+a+"\nint value="+b);
	}
}
