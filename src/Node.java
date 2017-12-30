
public class Node {
	private Integer a;
	private Node next;
	public Node()
	{
		a=null;
		next=null;
	}
	public Node(Integer i)
	{
		a=i;
		next=null;
	}
	public Node(Node n)
	{
		a=null;
		next=n;
	}
	public Node(Integer i,Node n)
	{
		a=i;
		next=n;
	}
	public Node getNext(){return next;}
	public void setNext(Node n){next=n;}
	public Integer getElement(){return a;}

}
