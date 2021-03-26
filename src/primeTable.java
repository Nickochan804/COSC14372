
public class primeTable 
{

	public static void main(String args[]) 
	{
		int low = 4;
		int high = 15;
		
		primeTable(low, high);
		
		
	}
	
	static void getPrimes(int low, int high) 
	{
		System.out.print("        ");
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
		
		System.out.println();
		// second nested loop to do the multiplication
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
				System.out.print(i+":      ");
			
		}
		
	}
	
	static void primeTable()
	
	static String form(int i)
	{
		return (i+"        ").substring(0,8);
	}
	
}
