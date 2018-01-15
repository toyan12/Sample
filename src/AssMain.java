import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
//TODO 1. ask lab, overall seperation
//TODO 2. ask input file string input method



public class AssMain 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please input the filename");
		String str=sc.next();
		try {
			BufferedReader br=new BufferedReader(new FileReader(str));
			String line="";
			//process first row for init
			line=br.readLine();
			String[] para=line.split(",");
			int count=(para.length-2)/2;
			String[] assName=new String[count+3];
			assName[count+2]="Overall";
			int[] weight=new int[count];
			int[] columnL=new int[count+3];
			double[] sum=new double[count+1];
			int totalStu=0;
			//init id name overall
			assName[0]="ID";
			assName[1]="Name";
			assName[count+2]="Overall";
			columnL[0]=10;
			columnL[1]=21;
			columnL[count+2]=9;
			
			//init assignment
			for(int i=0;i<count;i++)
			{
				assName[i+2]=para[i*2+2].substring(1);
				weight[i]=Integer.parseInt(para[i*2+3].substring(1));
				columnL[i+2]=assName[i+2].length()+2>8 ? assName[i+2].length()+2:8;
			}
			//init format
			String format1="";
			for(int i=0;i<count+3;i++)
			{
				format1+="%-"+columnL[i]+"s";
			}
			format1+="\n";
			//output first row
			System.out.printf(format1,(Object[])assName);
			//output record
			while((line=br.readLine())!=null)
			{
				//temp to score
				totalStu++;
				String[] temp=line.split(",");
				int colCount=temp.length+1;
				int scoreCount=temp.length-2;
				double[] score=new double[scoreCount];
				for(int i=0;i<score.length;i++)
				{
					score[i]=Double.parseDouble(temp[i+2].substring(1));
				}
				//score to overall
				double overall=0;
				for(int i=0;i<score.length;i++)
				{
					overall+=score[i]*weight[i]/100;
				}
				//add score to sum
				for(int i=0;i<scoreCount;i++)
				{
					sum[i]+=score[i];
				}
				sum[scoreCount]+=overall;
				//init string
				String[] record=new String[colCount];
				record[0]=temp[0];
				for(int i=1;i<colCount-1;i++)
				{
					record[i]=temp[i].substring(1);
				}
				record[colCount-1]=String.format("%.2f",overall);
				//output
				System.out.printf(format1,(Object[])record);
			}
			
			//average
			for(int i=0;i<sum.length;i++)
			{
				sum[i]/=totalStu;
			}
			//output last row
			String[] record=new String[columnL.length];
			record[0]="";
			record[1]=String.format("%21s", "Average: ");
			for(int i=2;i<record.length;i++)
			{
				record[i]=String.format("%.2f", sum[i-2]);
			}
			System.out.printf(format1,(Object[])record);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
