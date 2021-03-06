//Assignment4 - WordLadder Team Lab
//
//TEAM: Mario A Molina  -> EID: MAM22696
//::::: Maxwe Archibald -> EID: MMA2629 
//Group# 2
//
//Git URL: https://github.com/M0lius/WordLadder.git
//Main Method on the top of Assign4Driver
//
//TA::: Jo Egner
//Discussion Time: 9:30 AM -> 11:00 AM
//
//Prints out total time to get all word ladders at the end 
 

package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Assign4Driver
{
    public static void main(String[] args)
    {
    	
    	//Open file; file name specified in args (command line)
    	//code snipped from the Translate Program
  		 if (args.length != 1) 
  	  	{
  	  		System.err.println ("Error: Incorrect number of command line arguments");
  	  		System.exit(-1);
  	  	}
  		  
  		 try 
  		{ 			 
  			FileReader freader = new FileReader(args[0]);
  			BufferedReader reader = new BufferedReader(freader);
  	 			
  			long startTime = System.currentTimeMillis(); //startTime for program
  			
  	  		for (String s = reader.readLine(); s != null; s = reader.readLine()) 
  	  		{
  	  		
  	  		Dictionary dictionary = new Dictionary(); //hold the english words to verify input
  	  		WordLadderSolver wordLadder = new WordLadderSolver(); //my word ladder
  	  		boolean invalid = false; //checks if words are both valid before making a ladder
  	  		
  	  		String firstWord = Reader.GetWord(s, 0);
  	  		if (firstWord.equals(null) || firstWord.equals("") || firstWord.length() != 5 
  	  				|| !dictionary.WordExists(firstWord)){
  	  			//TODO Check if real word
  	  			System.out.println("Invalid First Word");
  	  			invalid = true;
  	  		}
  	  		String secondWord = Reader.GetWord(s, 1);
  	  		if (secondWord.equals(null) || secondWord.equals("") || secondWord.length() != 5
  	  				|| !dictionary.WordExists(secondWord)){
  	  			//TODO check if real word
  	  			if (invalid == false){//dont give out two errors
  	  				System.out.println("Invalid Second Word");
  	  				invalid = true;
  	  			} 
	  		}
  	  		
  	  		try {
  	  			if(!invalid){
					List<String> ladder = wordLadder.computeLadder(firstWord, secondWord); //get word ladder
					for(int i = 0; i < ladder.size()  ; i++){
	  	  				System.out.println(ladder.get(i)); //output one word per line
	  	  			}
	  	  				System.out.println("**********"); //seperate ladders
  	  			}
			} catch (NoSuchLadderException e) {
				System.err.println("No Wordladder Possible For " + firstWord + " And " + secondWord + "."); //no ladder found
				System.err.println("**********"); //seperate from next ladder
			}  	  			
  	  		
  	  	} //end of for loop
  	  		
  	  	long totalTime = System.currentTimeMillis() - startTime;//total time of program to run
  	  	double seconds = (double) totalTime/1000; //total time in seconds
		System.out.printf("Total time = %g sec", seconds);	
  	  		
  	  } 
  	  	catch (FileNotFoundException e) 
  	  	{
  	  		System.err.println ("Error: File not found. Exiting...");
  	  		e.printStackTrace();
  	  		System.exit(-1);
  	  	} catch (IOException e) 
  	  	{
  	  		System.err.println ("Error: IO exception. Exiting...");
  	  		e.printStackTrace();
  	  		System.exit(-1);
  	  	}
  		 
    }
}
