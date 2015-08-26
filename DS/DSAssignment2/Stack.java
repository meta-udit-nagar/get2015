import java.util.Scanner;


public class Stack {
private int top;
private int size;
Node<Object> node;



public int getTop() {
	return top;
}

public void setTop(int top) {
	this.top = top;
}

public int getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
}

public Node<Object> getNode() {
	return node;
}

public void setNode(Node<Object> node) {
	this.node = node;
}

public Stack(int size)
{
   
	this.size=size;
	top=-1;
	node =new Node<Object>();
	
}

public void push(Object item)
{
	
	if(top>=size-1)
	{
		System.out.println("Stack overflow");
		
	}else
	{
		top=top+1;
		node.add(item);
		System.out.println(top);
		
	}

}

public void pop()
{
if(size==-1)
{
	System.out.println("Stack underflow");
}else
{
	
	node.deleteByIndex(top+1);
	top--;
}}

public Object peep()
{
	Object object= new Object();
if(top>=size)
{
System.out.println("stack overflow");
}else if(top==-1)
{
	
System.out.println("Stack underflow");
}else
{
   object=node.getitem(top+1);	
}	
return object;
}

public void printStack()
{
node.display();
}
public static void main(String args[])
{
Scanner scanner = new Scanner(System.in);
Stack stack= new Stack(5);
   while(true)
   {
	   int ch=scanner.nextInt();
	   switch(ch)
	   {
	   case 1:{stack.push(scanner.nextInt());break;}
	   case 2:{stack.printStack();break;}
	   case 3:{stack.pop();break;}
	   case 4:{System.out.println(stack.peep());break;}
	   
	   
	   }
	   
	   
	   
   }

}

}
