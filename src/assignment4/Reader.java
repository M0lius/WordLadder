package assignment4;

/******************************************************************************
		* Class: Reader                                             				  *
	  	* Purpose: Reads a file and Parses it										  *
	  	* Returns: Nothing                                                               *
	  	******************************************************************************/

	  public class Reader //static class Reader 
	  {
		  
	  	public static boolean Tail(String command, int skips){
	  		int pointer = SkipInputs(command, skips);
	  		if (pointer == -1){
	  			return false;
	  		} else {
	  			char now = command.charAt(pointer);
	  			if (now == ' '){
	  				return false;
	  			} else{
	  			return true;
	  			}
	  		}
	  	}
		  
		public static int SkipInputs(String command, int inputs)// assumes all previous inputs were valid and gathered 
		{//returns a pointer to the beginning of the next input after # skipped
			int pointer = 0; 
			
	  		if(pointer > (command.length() - 1)){ //execption of blank line
	  			return -1; //error
	  		}
	  		
			char now = command.charAt(pointer); //checks current char
	  		
	  		while (now == ' ' && pointer < (command.length())){ //skips initial space
	  			now = command.charAt(pointer); //checks current char
	  			pointer += 1;
	  		}
	  		
	  		if (pointer != 0) {pointer = pointer - 1;}
		  	for(int i = 0; i < inputs; i++){ //for inputs skips word and following spaces
		  		while (now != ' ' && pointer < (command.length())){//goes to word end
		  			now = command.charAt(pointer);
		  			pointer += 1;
		  		}		 
		  		pointer = pointer - 1;
		  		
		  		while (now == ' ' && pointer < (command.length())){ //goes to word start
		  			now = command.charAt(pointer); //checks current char
		  			pointer += 1;
		  		}
		  		pointer = pointer - 1;
		  		
		  	}	
		  			  	
			
			return pointer;
		}
		
	  	public static String GetWord (String command, int skip) //reads for the Operation
	  	{ 
	  		int beginning = Reader.SkipInputs(command, skip); //beginning of the word
	  		if (beginning == -1) {return "";}//already at the end of string
	  		
	  		int end = beginning; //end of the word
	  		
	  		if(beginning > (command.length() - 1)){return "";} //exception of blank line
	  		
	  		char now = command.charAt(beginning); //checks current char

	  		while (now != ' ' && end < (command.length())){//up too the first space it sees
	  			now = command.charAt(end);
	  			end += 1;
	  		}
	  		if (now == ' '){end -= 1;}
	  		return command.substring(beginning, end);
	  		
	  	}
	  }
