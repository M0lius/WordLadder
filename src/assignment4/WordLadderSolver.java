/*
    ADD YOUR HEADER HERE
 */

package assignment4;

import java.util.List;
import java.util.Vector;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface
{
	// delcare class members here.
	private char[] alph = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
			'n','o','p','q','r','s','t','u','v','w','x','y','z'}; 
	
	private Vector<String> solutionList = new Vector<String>();
	
	private Dictionary dictionary = new Dictionary();
	
/*
 String myName = "domanokz";
char[] myNameChars = myName.toCharArray();
myNameChars[4] = 'x';
myName = String.valueOf(myNameChars);
 */
	
	public boolean MakeLadder (String fromWord, String toWord, int index){
		solutionList.addElement(fromWord);
		dictionary.MarkVisited(fromWord);
		
		if(fromWord.equalsIgnoreCase(toWord)){return true;}		
		
		//checks for words one char more similar
		for(int i = 0; i < 5; i++){
			if( (index - 1) != i && fromWord.toLowerCase().charAt(i) != toWord.toLowerCase().charAt(i) ){
				//TODO if(word exist){mark and MakeLadder(word}
				char[] check = fromWord.toCharArray();
				check[i] = toWord.charAt(i);
				if(dictionary.WordExists(String.valueOf(check)) && !dictionary.WordVisited(String.valueOf(check))){
					if (MakeLadder(String.valueOf(check), toWord, i + 1)){
						return true;
					}
				}
			}
		}
		
		//could not be found so looking through every other neighbor word
		for(int i = 0; i < 5; i++){
			if( (index - 1) != i && fromWord.toLowerCase().charAt(i) != toWord.toLowerCase().charAt(i) ){
				for(int j = 0; j < alph.length; j++){
					//TODO if(word exist){mark and if(MakeLadder(word}) {return true;} }
					char[] check = fromWord.toCharArray();
					check[i] = alph[j];
					if(dictionary.WordExists(String.valueOf(check))&& !dictionary.WordVisited(String.valueOf(check))){
						if (MakeLadder(String.valueOf(check), toWord, i + 1)){
							return true;
						}
					}
				}
			}	
		}
		
		solutionList.remove(solutionList.size() - 1);	
		return false;
	}
	
//	public void PrintSolution (Vector<String> solution){
//		
//	}

    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there

    // do not change signature of the method implemented from the interface
	
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException 
    {
        // implement this method
    	if (!MakeLadder (startWord, endWord, 0)){
    		 throw new NoSuchLadderException("No Word Ladder Possible");
    	}
		return solutionList;
    }

    @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder) 
    {
    	
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    // add additional methods here
}
