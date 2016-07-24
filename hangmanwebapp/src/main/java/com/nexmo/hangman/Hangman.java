package com.nexmo.hangman;

import java.io.IOException;
import java.util.Scanner;

import com.nexmo.hangman.word.DummyWordGenerator;
import com.nexmo.hangman.word.Word;
import com.nexmo.hangman.word.WordGeneratorInterface;

public class Hangman {

	private final int MAX_INCORRECT_ATTEMPT = 5;
	
	private WordGeneratorInterface myGenerator;
	private int totalGuessSoFar;
	
	
	//for default, use dummy generator
	public Hangman(){
		myGenerator = new DummyWordGenerator();
		totalGuessSoFar = 0;
	}
	
	public Hangman(WordGeneratorInterface generator){
		myGenerator = generator;
		totalGuessSoFar = 0;
	}
	
	
	//For testing now call this from the main method
	public void play(){
		Word generatedWord = myGenerator.generateWord();
		
		System.out.println("Welcome to Hangman");
		
		while(totalGuessSoFar <= MAX_INCORRECT_ATTEMPT
				&& !generatedWord.getIsGuessed()){
			System.out.println("");
			System.out.println("******************");
			System.out.println("Life left = " + (MAX_INCORRECT_ATTEMPT-totalGuessSoFar) + ". Generated word: " + String.valueOf(generatedWord.getCurrentGuess()));			
			System.out.println("Guess a letter: ");
			Scanner scanner = new Scanner(System.in);
			String userInput = scanner.next();
			
			//let's see if guess is correct
			boolean correctGuess = generatedWord.enterGuess(userInput.charAt(0));
			if(!correctGuess){
				totalGuessSoFar++; //incorrect
				
				//TODO need to tell the user, it is incorrect and how many attempts left
				System.out.println("Sorry, incorrect guess.");
				System.out.println("******************");
				promptEnterKey();
			}
			
			if(generatedWord.getIsGuessed()){
				System.out.println("Congratulations, you have guessed it.");
				System.out.println("******************");
				promptEnterKey();
			}
		}
		
		//if reached here, then player has lost
		if(!generatedWord.getIsGuessed())
			System.out.println("Sorry, you have run out of attempts. Please restart game.");
	}
	
	private void promptEnterKey(){
		   System.out.println("Press \"ENTER\" to continue...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
	}
	
	
	public static void main(String[] args){
		
		Hangman myHangman = new Hangman();
		myHangman.play();
		
	}
}
