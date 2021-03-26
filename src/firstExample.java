public class firstExample {
	//everything must be in a class
	public static void main(String adsasdf[])
	{
		//output
		//cout << "great things" << endl;
		System.out.println("asdfasdf");
		System.out.print("one ");
		
		
		//chapter 2: variables (java is more rigidly typed than c++)
			byte b; // 1 byte of memory
			char c; // 2 byte (Unicode)
				c = 7;
				c+=58;
				System.out.println(c);
			short s; //2 byte ~-32k to 32k
			int i; // 4 bytes
			long l = 8_343_543_234L; // 8 bytes  cannot use commas but can use _
			
			boolean yesNo = true;
			System.out.println(yesNo);
			
			//floating
			float fnum; //4bytes (6/7 significant figures)
			double d; //8 bytes (~15 sig figures)
				
			fnum = 17.5f; // double literals
			
			//strings
			String name = "bob barker";
				
		// 4: selections
			//if/else/switch
			int month = 7;
			
			if (month == 1)
				System.out.println("Jan");
			else if (month == 2)
				System.out.println("Feb");
			else if (month == 3)
				System.out.println("Mar");
			else if (month == 4)
				System.out.println("Apr");
			else if (month == 5)
				System.out.println("May");
			else if (month == 6)
				System.out.println("Jun");
			else if (month == 7)
				System.out.println("Jul");
			
			switch (month)
			{
			case 1:
				System.out.println("Jan");
				break;
			case 2:
				System.out.println("Feb");
				break;
			case 3:
				System.out.println("Mar");
				break;
			case 4:
				System.out.println("Apr");
				break;
			case 5:
				System.out.println("May");
				break;
			case 6:
				System.out.println("Jun");
				break;
			case 7:
				System.out.println("Jul");
				break;
			}
			
			// short hand if
			int num = 5;
			int other = 8;
			int max = num > other ? num : other;
			
			
			
		//5: loop
			// for/while do/while
			for (int x=0; x<10; x++)
				System.out.print(x+ " ");
			System.out.println();
			
			int lcv = 0;
			while (lcv < 10)
				System.out.print(lcv+++ " ");
			System.out.println();
			
			int pvc = 0;
			do {
				System.out.print(pvc+++ " ");	
			}while(pvc<10);
			System.out.println();
			
		//6: functions --> methods
		System.out.println(calcPerimeter(3,5));
		
		//7: strings
		
		//8: arrays
		
		
	}
	// methods "instanced" by default (unique to each object)
	// functions are static by default (shared by each object) 
	
	static int calcPerimeter (int length, int width)
	{
		return 2*(length+width);
	}
	
}
