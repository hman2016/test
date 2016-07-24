package com.nexmo.hangman.word;

import java.util.Random;

/*
 * For the purpose of simplicity, 
 * this dummy generator will be generating from fixed list of words
 * using random selection
 * The idea of the interface is simply to allow it to be changed to a different generator in the future
 */
public class DummyWordGenerator implements WordGeneratorInterface{
	
	private final String[] words = {"london", 
					"southampton", 
					"butterfly", 
					"chelsea",
					"cowboy",
					"horse",
					"hat",
					"hello",
					"good",
					"excellent"
					};
	
	/*
	 * Generate a random choice from a dummy fixed list provided in this dummy generator
	 * @see com.nexmo.hangman.nexmohangman.WordGeneratorInterface#generateWord()
	 */
	public Word generateWord() {

		Random random = new Random();
		
		int chosenIndex = random.nextInt(words.length);
		
		Word generatedWord = new Word(words[chosenIndex]);
		System.out.println("FOR TESTING, generated word = " + generatedWord);
		
		return generatedWord;
	}

	
	public static void main(String[] args){
		DummyWordGenerator dummy = new DummyWordGenerator();
		System.out.println(dummy.generateWord());
		
		System.out.println(dummy.generateWord());
		
		System.out.println(dummy.generateWord());
	}
}
