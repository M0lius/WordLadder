package assignment4;

import static org.junit.Assert.*;
import org.junit.Test;

public class LadderTest {

	@Test
	public void BlackBoxOne() {
		WordLadderSolver wordLadder = new WordLadderSolver();
		
		// Should produce a word ladder
		String firstWord = "stone";
		String secondWord = "money";
		assertTrue(wordLadder.MakeLadder(firstWord, secondWord, 0));
	}
	
	@Test
	public void BlackBoxTwo() {
		WordLadderSolver wordLadder = new WordLadderSolver();
		
		// Should not produce a word ladder
		String firstWord = "atlas";
		String secondWord = "zebra";
		assertFalse(wordLadder.MakeLadder(firstWord, secondWord, 0));
	}

}
