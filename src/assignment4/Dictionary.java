package assignment4;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	ArrayList<Word> dictionary;

	public Dictionary() {
		Init();
	}
	
	//very stupid simple check if exists method
	public boolean WordExists(String word){
		for(int i = 0; i <dictionary.size(); i++){
			if(dictionary.get(i).getEntry().equalsIgnoreCase(word)){
				return true;
			}
		}
		return false;
	}
	
	public boolean WordVisited(String word){
		for(int i = 0; i <dictionary.size(); i++){
			if(dictionary.get(i).getEntry().equalsIgnoreCase(word)){
				return dictionary.get(i).getVisited();
			}
		}
		return true; //doesnt even exist so act as if visited
	}
	
	public void MarkVisited(String word){
		for(int i = 0; i <dictionary.size(); i++){
			if(dictionary.get(i).getEntry().equalsIgnoreCase(word)){
				dictionary.get(i).setVisited(true);
				return;
			}
		}
	}
	
	public String getWord(int i){
		return dictionary.get(i).getEntry();
	}
	public int getSize(){
		return dictionary.size();
	}
	
	public void Init() {
		
		dictionary = new ArrayList<Word>();
		
		try 
		{
			FileReader freader = new FileReader("A4words.dat");
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
					//System.out.println(input.getEntry());
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
