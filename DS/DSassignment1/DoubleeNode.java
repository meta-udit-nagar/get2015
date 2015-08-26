
public class DoubleeNode<T> 
{
	
	T nodeValue;

	DoubleeNode<T> start;
	DoubleeNode<T> next;
	DoubleeNode<T> previous;
   
	public DoubleeNode() {
		nodeValue = null;
		next = null;
		previous = null;
	}
	
	public DoubleeNode(T item)
	{
		nodeValue = item;
		next = null;
		previous = null;
	}
	
	boolean addElement(T element)
	{
	
		DoubleeNode<T> newNode = new DoubleeNode<T>(element);
	
		DoubleeNode<T> current = new DoubleeNode<T>();
		if (start == null)
		{
			start = newNode;
			newNode.previous = start;
	
			return true;
		} 
		else 
		{
			current = start;
			while (current.next != null) 
			{
	
				current = current.next;
			}
			current.next = newNode;
			newNode.previous = current;
		}
		return true;
	}
	
	boolean display()
	{
		DoubleeNode<T> current = new DoubleeNode<T>();
		current = start;
		System.out.println("Singly Linked List:");
		while (current != null)
		{
			System.out.print(current.nodeValue + "<-> ");
			current = current.next;
		}
		System.out.println();
		return true;
	}
	
	boolean addAtPostion(int position, T value)
	{
		DoubleeNode<T> newNode = new DoubleeNode<T>(value);
		DoubleeNode<T> current = new DoubleeNode<T>();
		current = start;
		int count = 1;
		if (position == 1) {
			newNode.next = current;
			newNode.previous = start;
			start = newNode;
		}
		else
		{
			count = 2;
			while (current != null)
			{
				if (count == position) 
				{
					newNode.next = current.next;
					newNode.previous = current;
					current.next = newNode;
				}
				count++;
				current = current.next;
			}
			if (count < position)
			{
				return false;
			}
		}
		return true;
	}
	
	boolean deleteByValue(T value)
	{
		int flag = 0;
	
		DoubleeNode<T> current = start;
		if (current == null)
		{
			return false;
		}
		while (current != null) 
		{
			if (current.nodeValue == value)
			{
				start = current.next;
				current.next.previous = start;
				return true;
			}
			if (current.next != null)
			{
				if (current.next.nodeValue == value) 
				{
					current.next = current.next.next;
					current.next.next.previous = current;
					flag = 1;
					return true;
				}
			}
			current = current.next;
		}
		if ((flag == 0) && (current == null))
		{
			return false;
		}
		return false;
	}
	
	boolean deleteByIndex(int position)
	{
		DoubleeNode<T> current = new DoubleeNode<T>();
		current = start;
		int count = 1;
		if (position == 1) 
		{
			start = current.next;
			current.next.previous = start;
		} 
		else
		{
			count = 2;
			while (current != null) 
			{
				if (count == position)
				{
					current.next = current.next.next;
					current.next.next.previous = current;
				}
				count++;
				current = current.next;
			}
			if (count < position)
			{
				return false;
			}
		}
		return true;
	}
	
	T getitem(int position)
	{
		DoubleeNode<T> current = new DoubleeNode<T>();
		current = start;
		int count = 1;
		while (current != null) {
			if (count == position) {
				return current.nodeValue;

			}
			count++;
			current = current.next;
		}
		return null;
	}
	
	public void reverseLinkedList() 
	{
		if (start == null || start.next == null)
			return;
		DoubleeNode<T> Second = start.next;
		Second.previous = start;
	
		DoubleeNode<T> third = Second.next;
		third.previous = Second;
	
		Second.next = start; 
	
		start.next = null; 
	
		if (third == null)
			return;
		DoubleeNode<T> CurrentNode = third;
		DoubleeNode<T> PreviousNode = Second;
		while (CurrentNode != null)
		{
			DoubleeNode<T> NextNode = new DoubleeNode<T>();
			NextNode = CurrentNode.next;
			CurrentNode.next = PreviousNode;
			PreviousNode = CurrentNode;
			CurrentNode = NextNode;
		}
		start = PreviousNode;
		DoubleeNode<T> current = start;
	}
	
	public boolean sortList()
	{
		if (start == null || start.next == null)
			return true;
		DoubleeNode<T> newHead = new DoubleeNode<T>(start.nodeValue);
		DoubleeNode<T> pointer = start.next;
		pointer.previous = start;
		
		while (pointer != null)
		{
			
			DoubleeNode<T> innerPointer = newHead;
			DoubleeNode<T> next = pointer.next;
			
			if ((int) pointer.nodeValue <= (int) newHead.nodeValue) 
			{
				DoubleeNode<T> oldHead = newHead;
				newHead = pointer;
				newHead.next = oldHead;
				oldHead.previous = newHead;
			} 
			else 
			{
				while (innerPointer.next != null)
				{
					if ((int) pointer.nodeValue > (int) innerPointer.nodeValue && (int) pointer.nodeValue <= (int) innerPointer.next.nodeValue) 
					{
						DoubleeNode<T> oldNext = innerPointer.next;

						innerPointer.next = pointer;
						pointer.previous = innerPointer;
						pointer.next = oldNext;
						oldNext.previous = pointer;
					}
					innerPointer = innerPointer.next;
				}
				if (innerPointer.next == null && (int) pointer.nodeValue > (int) innerPointer.nodeValue)
				{
					innerPointer.next = pointer;
					pointer.previous = innerPointer;
					pointer.next = null;
				}
			}
			pointer = next;
		}
		start = newHead;
		return true;
	}
}
