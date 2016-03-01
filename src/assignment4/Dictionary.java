package assignment4;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

	public Dictionary() {
		// TODO Auto-generated constructor stub
	}
	
	public void Init(String filename) {
		
		ArrayList<Word> dictionary = new ArrayList<Word>();
		
		try 
		{
			FileReader freader = new FileReader(filename);
			BufferedReader reader = new BufferedReader(freader);
			
			int i = 0;
			for (String s = reader.readLine(); s != null; s = reader.readLine())
			{
				Word input = new Word();
				if (s.charAt(0) != '*'){
					for (int j = 0; j < 5; j++) {
						input.addChar(input, s.charAt(j));
					}
					dictionary.add(input);
					i++;
				}
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
	}

}
