package myUtility;
import java.util.Scanner;

public class ConsoleUtility
{
	public static Scanner sc=new Scanner(System.in);
	public static String readInput(String prompt)
	{
    	System.out.println(prompt);
    	String output= sc.next();
    	return output;
	}
	public static int readInt(String prompt)
	{
    	System.out.println(prompt);
    	int output= sc.nextInt();
    	return output;
	}
	public static int menu(String[] option)
	{
		for(int i=0;i<option.length;i++)
		{
			System.out.println(i+". "+option[i]);
		}
		int option1=readInt("Choose your option");
		if(option1<0||option1>=option.length)
		{
			System.out.println("Invalid input");
			return -1;
		}
		else return option1;
	}
}
