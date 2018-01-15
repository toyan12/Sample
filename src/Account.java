

public class Account 
{

	private int id=0;
	private double balance=0;
	private static double annualInterestRate=0;
	private java.util.Date dateCreated=new java.util.Date();
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public static void setAnnualInterestRate(double interest) {
		annualInterestRate=interest;
	}
	public Account()
	{
	}
	public Account(int id,int balance)
	{
		this.id=id;
		this.balance=balance;
	}
	public double getMonthlyInterestRate()
	{
		return annualInterestRate/1200;
	}
	public double getMonthlyInterest()
	{
		return annualInterestRate/1200*balance;
	}
	public void withdraw(int amount)
	{
		balance-=amount;
	}
	public void deposit(int amount)
	{
		balance+=amount;
	}
	public static void main(String[] args)
	{
		
		Account a=new Account(1122,20000);
		setAnnualInterestRate(4.5);
		a.withdraw(2500);
		a.deposit(3000);
		System.out.println(a.getBalance());
		System.out.println(a.getMonthlyInterest());
		
	}
	
}
