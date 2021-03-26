import java.util.Scanner;

public class homework 
{
	
	public static void main(String[] homeworkTest)
	{

		long number = 200739;

        int val = 90;

        while (number > 0)

        {

              int temp = (int)number % 100;

              val %= temp;

              number /= 100;

        }

        System.out.println(val);
	}
}
