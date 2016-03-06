package assignment4;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;

public class LadderTest {

	Dictionary dictionary = new Dictionary(); //hold the english words to verify input
	
	public int charDifference(String one, String two){ //checks how many charachters are different in two words
		int differentChars = 0;
		char[] charsOne = one.toCharArray();
		char[] charsTwo = two.toCharArray();
		
		for (int i = 0; i < 5; i++){
			if(charsOne[i] != charsTwo[i]){
				differentChars++;
			}
		}
		
		return differentChars;
	}
	
	@Test
	public void BlackBoxOne() { //makes sure it can produce a wordLadder on words that should produce a word ladder
		WordLadderSolver wordLadder = new WordLadderSolver();
		
		// Should produce a word ladder
		String firstWord = "stone";
		String secondWord = "money";
		assertTrue(wordLadder.makeLadder(firstWord, secondWord, 0));
	}
	
	@Test
	public void BlackBoxTwo() {//makes sure that it can find word that should not be able to make a word ladder
		WordLadderSolver wordLadder = new WordLadderSolver();
		
		// Should not produce a word ladder
		String firstWord = "atlas";
		String secondWord = "zebra";
		assertFalse(wordLadder.makeLadder(firstWord, secondWord, 0));
	}
	
	@Test
	public void BlackBoxThree() { //makes sure that each word in a word ladder is one char away from the word below and on top of it
		WordLadderSolver wordLadder = new WordLadderSolver();
		
		// Should not produce a word ladder
		String firstWord = "stone";
		String secondWord = "money";
		try {
			List<String> testLadder = wordLadder.computeLadder(firstWord, secondWord);
			int length = testLadder.size();
			for(int i =0; i < (length - 1); i++){
				assertTrue(charDifference(testLadder.get(i), testLadder.get(i+1)) == 1);
			}
			
		} catch (NoSuchLadderException e) {
			// Should not reach here
			e.printStackTrace();
		} 
	}
	
	@Test
	public void WhiteBoxOne() { //verifies that the dictionary got initialized correct
		// Dictionary should only have 5757 words in it
		int size = dictionary.getSize();
		String message = ("String is size " + size);
		//System.out.println(message);
		assertTrue(message ,size == 5757);
	}
	
	@Test
	public void WhiteBoxTwo() {//checks that the word class and its methods are working as well as that the words in the dictionary are only 5 chars long		
		// every word should be 5 chars of length 
		int random = (int) (Math.random() * 5757 + 1);
		String testWord = dictionary.getWord(random);
		assertTrue("Not a 5 letter word" ,testWord.length() == 5);
	}
}
