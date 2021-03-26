
public class primeTable 
{

	public static void main(String args[]) 
	{
		int low = 14;
		int high = 38;
		
		primeTable(low, high);
		
		
	}
	
	static void primeTable(int low, int high) 
	{
		int i;		//number to check if it is prime
		int j;		//divisor increasing from 2 to i
		int flag;	// flag variable to check if i is prime
		
		for(i = low; i<=high; i++)
		{
			flag = 0;
			for(j = 2; j < i; j++)
			{
				if(i%j ==0) 
				{
					flag = 1;
					break;
				}
					
			}
			if (flag == 0)
				System.out.print(form(i));
		}
		
		
		
	}
	
	static String form(int i)
	{
		return (i+"        ").substring(0,8);
	}
	
}
