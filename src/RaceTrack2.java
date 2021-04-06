

/**
 * This is the program driver (where the program starts)
 * It is in charge of creating the race and it's participants and telling them to "go" in the race.
 * @author vjl8401
 */

public class RaceTrack //driver 
{
	public final static int raceDuration = 1000; //store the length of the race (can be accessed anywhere in code)

	public static void main(String arg[])
	{
		
		//Instantiating my object instances	
			Engine engine = new Engine(67);
			Vehicle c1 = new Car(1,engine,2); //this one I'm storing as the base class (vehicle)			
			Car c2 = new Car(2,new Engine(94),4);    //this one I store as the sub class (car). There are differences but they do not come into play here
			Truck t1 = new Truck(3,new Engine(87),2,250);
			
		//This is an array
		Vehicle[] allVehicles = new Vehicle[3];
		//placing the vehicles into an array
			allVehicles[0] = c1;   //polymorphism ("isa")
			allVehicles[1] = c2;   //remember just because I store these as vehicles doesn't mean that the 
			allVehicles[2] = t1;   //methods for them has changed. Each still stores its own go method.
					
		//infinite loop (well without the base case it is)
		while (true) //this will run until a race participant crosses the finish line (passes raceDuration)
		{
			int max=0;
			//tell the cars to "go" one by one
				for (int i=0; i<allVehicles.length;i++) //3 times
				{
					Vehicle v = allVehicles[i];
									
					v.Go();//polymorphism
					
					System.out.println(v);
					max = Math.max(max,v.RaceProgress);					
				}
				System.out.println();
			//check to see if someone has won the race
				if (max > raceDuration)
				{
					break;
				}
		}		
		System.out.println("We have a winner!!! \n*** Vehicle "+RaceTrack.GetFurthestVehicle(allVehicles)+" ***");
		
		
	}
	//just a helper method to find out which vehicle won the race
	public static int GetFurthestVehicle(Vehicle[] allVehicles)
	{
		int max=0;
		int VIN=0;
		for (int i=0; i<allVehicles.length;i++)
		{
			if (max < allVehicles[i].RaceProgress)
			{
				max = allVehicles[i].RaceProgress;
				VIN = allVehicles[i].VIN;
			}
		}
		return VIN;
	}
}
class Engine
{
	int speed;
	public Engine(int speed)
	{
		this.speed = speed;
	}
	/**
	 * This is the original speed modifier (it may need to be redefined)
	 * @return int random between half the speed and the whole speed
	 */
	public int SpeedModifier()
	{
		//returns speed/2 to maxSpeed
		return (int)(Math.random()*speed/2)+speed/2;
	}
}
//Base class (abstract means that we can't make Vehicles)
//class' responsibility to protect its data/attributes
abstract class Vehicle extends Object
{		
	//attributes (fields
	int passengers;
	int VIN;
	int RaceProgress;
	Engine engine;   //storage (association, aggregation, composition)
	
	//Constructors (used to create the objects):
	Vehicle(int vin, Engine e) 
	{
		passengers = 1;
		RaceProgress = 0;
		VIN = vin;
		engine = e;
	}	
	
	/**
	 * This is the main function that progresses the vehicles through the race
	 * this should be called each loop of the program (this must be redefined in each 
	 * subclass of vehicle)
	 */
	abstract public void Go(); //this is correctly coded, the abstract method only has its header, and no body - the body must be overwritten in subclasses
	
	/**
	 * Part of object. This is invoked when an instance of this class is attempted to be used as a string (like during System.out.println)
	 */
	public String toString()
	{
		return "Vehicle: "+VIN+
				" Progress: "+RaceProgress;		
	}
	
	public boolean equals(Object other)
	{
		return this.VIN == ((Vehicle)other).VIN;
	}	
	
	public void reset()
	{
		RaceProgress = 0;
	}
}

/**
 * 
 * SubClass of Vehicle
 *
 */
class Car extends Vehicle //car "is a" vehicle
{	
	/**
	 * Car Constructor (no return specified)
	 * @param i = (0,100) 
	 * @param passengers
	 * @param speed
	 */
	Car(int i, Engine e, int passengers) //Working constructor
	{			
		//super or this
		//super(); implied
		super(i,e);//calling the constructor in Vehicle
		this.passengers = passengers;
		
	}
	public String toString()
	{
		return "Car::"+super.toString();		
	}
	//This is overwriting the super/base classes method
	//car satisfies the vehicles Go requirement
	public void Go()
	{
		RaceProgress += engine.SpeedModifier() - 10 * (passengers-1);
		
	}
}
//Another subclass of Vehicle (this is considered a concrete class because it is not abstract)
class Truck extends Vehicle
{
	//This is data that exists only in trucks
	int towWeight;//special note that vehicle cannot access this. In order for it to do so a 
	              //cast operation must be applied to a valid truck.
	
	Truck(int i, Engine e, int passengers, int towWeight)
	{
		super(i, e);
		this.passengers = passengers;
		this.towWeight = towWeight;
	}
	public String toString()
	{
		return "Truck::"+super.toString();		
	}
	//truck satisfies the vehicles Go requirement
	public void Go()
	{
		RaceProgress += engine.SpeedModifier() - (0.1f * towWeight);
	}	
}
