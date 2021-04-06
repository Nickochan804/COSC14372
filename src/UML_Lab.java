
public class UML_Lab {

	public static void main(String args[])
	{
		
		
		
		
		
		
	}
	



}

class Bank
{
	private Person[] persons;
	private static int personNumber;
	
	public void addPerson(String name)
	{
		
	}
	public void addPerson(Person person)
	{
		
	}
	public void removePerson(String name)
	{
		
	}
	public void modifyAccountType(String name, String accountType)
	{
		
	}
	public void withdrawAccount(String name, int amt)
	{
		
	}
	public void depositAccount(String name, int amt)
	{
		
	}
//	public int getAccountBalance(String name)
//	{
//		return
//	}
//	private Person getPerson(String name)
//	{
//		return 
//	}
	
}

class Person
{
	private Account account;
	private String name;
	
	public  Person(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setupAccount(String type)
	{
		
	}
	public void deposit(int amt)
	{
		
	}
	public void withdraw(int amt)
	{
		
	}
//	public int getAccountBalance()
//	{
//		return 
//	}
}




class Account
{
	private int value;
	
	public Account(int value)
	{
		this.value = value;
	}
	public Account()
	{
		
	}
	public void withdraw(int amt)
	{
		
	}
	public void deposit(int amt)
	{
		
	}
//	public int getValue()
//	{
//		return value;
//	}
	
}


