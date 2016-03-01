package assignment4;

public class Word {
	
	String entry;
	boolean visited;
	
	public Word() {
		entry = "";
		visited = false;
	}
	
	public String getEntry(){
		return entry;
	}
	
	public void setEntry(String input){
		entry = input;
	}
	
	public boolean getVisited(){
		return visited;
	}
	
	public void setVisited(boolean input) {
		visited = input;
	}
	
	public Word addChar(Word word, char input) {
		word.entry += input;
		return word;
	}

}
