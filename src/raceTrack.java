import java.util.Arrays;

public class raceTrack 
{
	
	// Nicholas Lamb
	public static void main(String[] args) 
	{		
		//car 1
		Car bobsCar = new Car("Bob Barker Car", .3f, .62f, .1f, .93f, .11f, '1');
		Car patsCar = new Car("Pat Sajak Car", .45f,.65f,.3f,.83f,.14f, 'P');
		Car alexsCar = new Car("Alex Trebek Car", 0.29f,0.45f,.02f,.85f,.19f, 'A');
		Car bob2sCar = new Car("Bob Eubanks Car", .15f,.18f,.05f,.89f,.21f, 'E');
		Car montysCar = new Car("Monty Hall Car", .18f,.22f,.09f,.93f,.17f, 'M');
		Car richardsCar = new Car("Richard Dawson Car", .40f,.5f,.35f,.815f,.19f, 'R');
		
		Car[] allCars = {bobsCar, patsCar, alexsCar, bob2sCar, montysCar, richardsCar};		//array to store all cars for comparison later

		
		
		
		for (int i = 1; i < 26; i++) 
		{
			String Racetrack = ""; // reset track
		
			String track[] = {"-", "C" ,"U" , "S","-","-","-","-","-","-"}; // array to store the track parts
			for(int j = 1; j < 45; j++) //loop that creates a new track
			{
				int randomNumber = (int)(Math.random()*10 );
				Racetrack += track[randomNumber];
			
			}
			int raceLength = Racetrack.length();
		
			boolean runningRace = true; //once someone wins we can stop this
			while (runningRace)
			{
				System.out.println(Racetrack);
				
			
				
			
					//display the car
					bobsCar.display();
					patsCar.display();
					alexsCar.display();
					bob2sCar.display();
					montysCar.display();
					richardsCar.display();
							
					//accelerate based on where you are on the track
					//Racetrack[(int)RaceProgress)]
					bobsCar.accelerate(Racetrack);
					patsCar.accelerate(Racetrack);
					alexsCar.accelerate(Racetrack);
					bob2sCar.accelerate(Racetrack);
					montysCar.accelerate(Racetrack);
					richardsCar.accelerate(Racetrack);
					
					if(bobsCar.checkIfWon(raceLength) == false|| 
							patsCar.checkIfWon(raceLength) ==false || 
							alexsCar.checkIfWon(raceLength) == false || 
							bob2sCar.checkIfWon(raceLength) ==false || 
							montysCar.checkIfWon(raceLength)==false|| 
							richardsCar.checkIfWon(raceLength)==false)
					{
						runningRace = false;
					}
					
					
					
			}	//end of while loop
			
			bobsCar.resetProgressAndSpeed();
			patsCar.resetProgressAndSpeed();
			alexsCar.resetProgressAndSpeed();
			bob2sCar.resetProgressAndSpeed();
			montysCar.resetProgressAndSpeed();
			richardsCar.resetProgressAndSpeed();
			
		} //end of for loop
		System.out.println();
		
		bobsCar.displayWins();
		patsCar.displayWins();
		alexsCar.displayWins();
		bob2sCar.displayWins();
		montysCar.displayWins();
		richardsCar.displayWins();
		
		Car winner = allCars[0];
		for (int i = 1;i<allCars.length; i++)
			if(winner.Wins < allCars[i].Wins)
				winner = allCars[i]; 
		System.out.println();
		System.out.println("This season's winner is "+ winner.carName +" with "+ winner.Wins +" wins.");
		}
		
		
		
		
	}//end of main
	



class Car
{
	String carName;
	float  HandlingS;
	float  HandlingC;
	float  HandlingU;
	float  RaceProgress = 0;
	float  CurrentSpeed = 0;
	float  TopSpeed;
	float  Acceleration;
	int    Wins = 0;
	char   Symbol;
	
	Car(String carName, float HandlingS, float HandlingC, float HandlingU, float TopSpeed, float Acceleration, char Symbol)
	{
		this.carName = carName;
		this.HandlingS = HandlingS;
		this.HandlingC = HandlingC;
		this.HandlingU = HandlingU;
		this.TopSpeed = TopSpeed;
		this.Acceleration = Acceleration;
		this.Symbol = Symbol;
		
	}
	
	void display()
	{
		String Progress = "";
		for (int i=0;i<RaceProgress;i++)
			Progress+= " ";
		System.out.println(Progress+Symbol);
	}
	
	void accelerate(String Racetrack)
	{
		switch (Racetrack.charAt((int)RaceProgress))
		{
		case '-': //strait-away
			if (CurrentSpeed < TopSpeed)
				CurrentSpeed += Acceleration;
			if (CurrentSpeed > TopSpeed)
				CurrentSpeed = TopSpeed;
			break;
		case 'S': //Chicane
			if (CurrentSpeed < TopSpeed*HandlingS)
				CurrentSpeed += Acceleration;
			else if (CurrentSpeed > TopSpeed*HandlingS)
				CurrentSpeed = TopSpeed*HandlingS;
			break;
		case 'C': //curve
			if (CurrentSpeed < TopSpeed*HandlingC)
				CurrentSpeed += Acceleration;
			else if (CurrentSpeed > TopSpeed*HandlingC)
				CurrentSpeed = TopSpeed*HandlingC;
			break;
		case 'U': //Hairpin
			if (CurrentSpeed < TopSpeed*HandlingU)
				CurrentSpeed += Acceleration;
			else if (CurrentSpeed > TopSpeed*HandlingU)
				CurrentSpeed = TopSpeed*HandlingU;
			break;
		}
		RaceProgress+=CurrentSpeed;
	}
	
	boolean checkIfWon(int raceLength)
	{
		
		
		if (RaceProgress >= raceLength)
		{
			System.out.println(carName+" wins");
			Wins++;
			return false;
		}
		return true;
	}
	
	void resetProgressAndSpeed()
	{
		CurrentSpeed = 0;
		RaceProgress = 0;
	}
	
	void displayWins()
	{
		System.out.println(carName+" had " +Wins + " wins this season.");

	}
	
	void displaySeasonWinner()
	{
		
	}
}