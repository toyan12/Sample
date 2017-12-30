package myUtility;

public class SpeedTest 
{
	public long start=0;
	long end=0;
	public SpeedTest(){}
	public void start()
	{
		start=System.nanoTime();
	}
	public void end()
	{
		end=System.nanoTime();
	}
	public void showTime()
	{
		System.out.println("The function run for "+(end-start)+" nano second.");
	}
}
