public class MainClass {

	public static void main(String args[]) {
		Node<Integer> a = new Node<Integer>();
		a.add(5);
		a.add(96);
		a.add(1);
		a.add(87);
		a.add(0);
		a.display();
		a.addAtPostion(2, 100);
		a.display();
		System.out.println("");
		if (a.deleteByValue(96)) {

		} else {

		}
		System.out.println("");
		a.display();
		System.out.println("");
		a.deleteByIndex(2);
		a.display();
		System.out.println("");
		System.out.println(a.getitem(3));
		a.reverseLinkedList();
		System.out.println("");
		a.display();
		System.out.println("");
		a.sortList();
		a.display();
	}
}
