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
  	 			
  	  		for (String s = reader.readLine(); s != null; s = reader.readLine()) 
  	  		{
  	  		String firstWord = Reader.GetWord(s, 0);
  	  		if (firstWord.equals(null) || firstWord.equals("") || firstWord.length() != 5){
  	  			//TODO Check if real word
  	  			System.out.println("Bad First Word");
  	  			System.exit(-1);
  	  		}
  	  		String secondWord = Reader.GetWord(s, 1);
  	  		if (secondWord.equals(null) || secondWord.equals("") || secondWord.length() != 5){
  	  			//TODO check if real word
	  			System.out.println("Bad Second Word");
	  			System.exit(-1);
	  		}
  	  		
  	  		System.out.println(firstWord + "*" + secondWord);
  	  		//Doit(s);//This should do something
  	  		}
  	  		
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
        // Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver();
        System.exit(0);
        try 
        {
            List<String> result = wordLadderSolver.computeLadder("money", "honey");
            boolean correct = wordLadderSolver.validateResult("money", "honey", result);
        } 
        catch (NoSuchLadderException e) 
        {
            e.printStackTrace();
        }
    }
}
