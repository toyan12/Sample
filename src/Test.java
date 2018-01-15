import javax.swing.JOptionPane;

public class Test 
{
	public static void main(String[] args)
	{
		int output=0;
		int add=0;
		do
		{
			output+=add;
			String addS=JOptionPane.showInputDialog("Input a number");
			add=Integer.parseInt(addS);
		}while(add>=0);
		JOptionPane.showMessageDialog(null, "The sum is: "+output, "lab2", JOptionPane.DEFAULT_OPTION);
	}
}