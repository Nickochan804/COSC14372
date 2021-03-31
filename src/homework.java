import java.util.Scanner;

public class homework 
{
	public static void main(String args[])

    {

        square sq = new square(6);

        square copy = sq;

        sq = sq.adjustSquare(3);

        System.out.print(copy.getArea() + " ");

        System.out.println(sq.getArea());

    }

}

class square

{

     private int length;

     square(int a)

     {

          length = a;

     }

     public int getArea()

     {

          return length * length;

     }

     public square adjustSquare(int i)

     {

          return new square(length+i);

     }

}

	 
	 


