import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GridBagTutorial extends JFrame 
{
	private JPanel contentPane;
	public static int width;
	public static int height;
	public static int cellWidth;
	public static int cellHeight;

	public static void main(String args[]) throws IOException
	{
		BufferedReader sysIn=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input the width and height");
		width=Integer.parseInt(sysIn.readLine());
		height=Integer.parseInt(sysIn.readLine());
		System.out.println("Input the cell width and height");
		cellWidth=Integer.parseInt(sysIn.readLine());
		cellHeight=Integer.parseInt(sysIn.readLine());
		ArrayList<GridBagObject> objects=new ArrayList<GridBagObject>();
		{
			int command=0;
			while(command!=3)
			{
				System.out.println("1. add Panel\n2. view Panel\n3. Display\nInput your command");
				command=Integer.parseInt(sysIn.readLine());
				switch(command)
				{
				case 1:
					System.out.println(
							"Create the following object\n"
							+ "1. JPanel\n"
							+ "2. JButton\n"
							+ "3. JLabel");
					int choice=Integer.parseInt(sysIn.readLine());
					System.out.println("What is the position of the object?\n"
							+ "Width,Height");
					int tempwidth=Integer.parseInt(sysIn.readLine());
					int tempheight=Integer.parseInt(sysIn.readLine());
					switch(choice)
					{
					case 1:
						JPanel panel=new JPanel();
						System.out.println("choose your color:\n1. RED\n2. GREEN\n3. BLUE");
						int choice1=Integer.parseInt(sysIn.readLine());
						switch(choice1)
						{
						case 1:
							panel.setBackground(Color.RED);
							break;
						case 2:
							panel.setBackground(Color.GREEN);
							break;
						case 3:
							panel.setBackground(Color.BLUE);
							break;
						default:
							break;	
						}
						objects.add(new GridBagObject(tempwidth,tempheight,panel));
						break;
					case 2:
						break;
					case 3:
						break;
					default:
						break;
					}
					break;
				case 2:
					
					break;
				default:
					break;
				}
			}
		}
		GridBagTutorial frame=new GridBagTutorial(objects);
		frame.pack();
		frame.setVisible(true);
	}
	public GridBagTutorial(ArrayList<GridBagObject> objects)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[width];
		for(int i=0;i<width;i++)
		{
			gbl_contentPane.columnWidths[i]=cellWidth;
		}
		gbl_contentPane.rowHeights = new int[height];
		for(int i=0;i<height;i++) gbl_contentPane.rowHeights[i]=cellHeight;
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		for(int i=0;i<objects.size();i++)
		{
			objects.get(i).add(contentPane);
		}
	}
	public static class GridBagObject
	{
		private GridBagConstraints layout;
		private Component object;
		public GridBagObject(int x,int y, Component object)
		{
			this.object=object;
			layout=new GridBagConstraints();
			layout.gridx=x;
			layout.gridy=y;
		}
		public void add(JPanel panel)
		{
			panel.add(object,layout);
		}
	}
}
