
import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		final String pro_name="Robel Endashaw";
		//Declare an int variables called randomNumber. Then, declare a String variable called option
		//
		int randomNumber;
		String option="";
		// Initialized a Scanner object called user_Input, and a RNG object called rn .
		Scanner user_Input =new Scanner(System.in); 
		RNG rn=new RNG();

		
		//Display an introduction message to the user of what the program does. 
		System.out.println("This application generates a random integer between 1 and 100"
			      + "\nand asks the user to guess repeatedly until they guess correctly\n");
		
		//Use the rand() method from RNG to set a random number to randomNumber
		
		// Do a while loop if the user inputs yes for the option
	 
		do {
			//Declare an int variables called next_guess, low_guess, so that they can hold the user's guess, the smallest guess, and 
			//high guess from the user.
			
			int next_guess=0;
			int low_guess=1;
			int high_guess=100;
			
			//Reset our count so that it can start from zero
			RNG.resetCount();
			// Declare an in variable called randomNumber and use the RNG.rand() function to set it 
			randomNumber=RNG.rand();
			
			//create a while loop that checks if the count is less than 7
			while(RNG.getCount()<7) {
				
				// Check if the count is equal to zero
				if(RNG.getCount()==0) 
				System.out.println("Enter your first guess");
				else 
				System.out.println("Enter your next guess between "+ low_guess+" and "+ high_guess);
				
				//Ask the user to input their guess
				next_guess=user_Input.nextInt();
				//If the user's guess is equal to the random number break out of the do while loop
				if(next_guess==randomNumber) {
					break;
				}
				//Check for input validation
				if(RNG.inputValidation(next_guess, low_guess, high_guess)==true) {
					if(next_guess<randomNumber) {
					   System.out.println("Your guess is too low");
					   low_guess=next_guess+1;
					}else if(next_guess>randomNumber) {
						System.out.println("Your guess is to high");
					    high_guess=next_guess-1;
					}
				}
				
				// Print out the number of guess so far
				System.out.println("Number of guess is: "+ RNG.getCount());
			}
			//Check if the number of count have exceeded 7 and the users guess is not equal to the random number
			if(RNG.getCount()==7 && next_guess!=randomNumber ) {
				System.out.println("You have exceeded the maximum number of guesses, "+ RNG.getCount()+". Try again");
				break;
			}else {
				System.out.println("Congratulations, you guessed correctly\nTry again? (yes or no)");
				option=user_Input.next();
			}
			
			
		}while(option.equalsIgnoreCase("yes"));
	
		if(option.equalsIgnoreCase("no")) {
			System.out.println("Thanks for playing...");
			System.out.println("Programmer's Name: "+pro_name );
		}
		
	}
	
}


