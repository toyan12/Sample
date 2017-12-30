
public class LinkedList 
{
	private Node head;
	private Node tail;
	private int size;
	private LinkedListRun run;
	public static void main(String[] arg)
	{
		LinkedList testList = new LinkedList(new Node(new Integer(0)));
		testList.add(new Node(new Integer(1)));
		testList.add(new Node(new Integer(2)));
		testList.add(new Node(new Integer(3)));
		testList.add(new Node(new Integer(4)));
		testList.add(new Node(new Integer(5)));
		testList.add(new Node(new Integer(5)),4);
		System.out.println("The size of list is: "+testList.size());
		testList.setRun(new LinkedListRun(){public void runList(Node n){System.out.println(n.getElement());}});
		testList.print();
	}
	public LinkedList()
	{
		head=null;
		tail=null;
		size=0;
	}
	public LinkedList(Node a)
	{
		head=a;
		tail=a;
		size=1;
	}
	public void setRun(LinkedListRun r){run=r;}
	public int size()
	{
		return size;
	}
	public Integer getElement(int index)
	{
		Node temp=head;
		for(int i=0;i<index;i++)
		{
			temp=temp.getNext();
		}
		return temp.getElement();
	}
	public void add(Node n)
	{
		if(tail!=null)
		{
			tail.setNext(n);
			tail=tail.getNext();
		}
		else
		{
			head=n;
			tail=n;
		}
		size++;
	}
	public void add(Node n,int index)
	{
		if(index==size)
			add(n);
		else if(index>size||index<0)
		{
			System.out.println("index out of limit");
			return;
		}
		else if(index==0)
		{
			Node temp=head;
			n.setNext(temp);
			head=n;
			size++;
		}
		else
		{
			Node temp=head;
			for(int i=0;i<index-1;i++)
			{
				temp=temp.getNext();
			}
			n.setNext(temp.getNext());
			temp.setNext(n);
			size++;
		}
	}
	public void remove(int index)
	{
		if(index>size-1||index<0)
		{
			System.out.println("index out of limit");
			return;
		}
		else if(index==0)
		{
			head=head.getNext();
			if(size==1)
				tail=null;
			size--;
		}
		else
		{
			Node temp=head;
			for(int i=0;i<index-1;i++)
			{
				temp=temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
			if(index==size-1)
				tail=temp;
			size--;
		}
	}
	public void print()
	{
		Node temp=head;
		if(head==null)
			return;
		else
		{
			while(temp!=null)
			{
				run.runList(temp);
				if(temp.getNext()!=null)
					temp=temp.getNext();
				else
					return;
			}
		}
	}
}
