package com.nexmo.hangman.word;

public class Word {

	private final char BLANK_UNDERSCORE_CHAR = '_';
	
	private String myString;
	private boolean isGuessed;
	
	private char[] currentGuess; //contains the characters guessed correctly by user
	private int totalCharacterGuessed; //keeps track how many of the characters have been guessed correctly
	
	public Word(String s){
		myString = s;		
		
		currentGuess = new char[myString.length()]; //init the size of the array
		for(int a = 0; a < currentGuess.length; a++){
			currentGuess[a] = BLANK_UNDERSCORE_CHAR;
		}
		
		totalCharacterGuessed = 0;
	}
	
	/*
	public void setIsGuessed(boolean b){
		isGuessed = b;
	}
	*/
	
	public boolean getIsGuessed(){
		return isGuessed;
	}
	
	//this is for the final reveal
	public String showFinalString(){
		return myString;
	}
	
	@Override
	public String toString(){
		return "myString = " + myString 
				+ ", isGuessed = " + isGuessed
				+ ", totalCharacterGuessed = " + totalCharacterGuessed;
	}
	
	public char[] getCurrentGuess(){
		return currentGuess;
	}
	
	
	public boolean enterGuess(char c){
		
		boolean correctGuess = false;
		
		char[] myStringArray = myString.toCharArray();
		
		//loop through the string and compare the guess with the string
		for(int a = 0; a < myStringArray.length; a++){
			//this means the character has already been guessed before
			if(myStringArray[a] == c && currentGuess[a] == c){
				correctGuess = true;
			}
			else if(myStringArray[a] == c && currentGuess[a] != c){
				currentGuess[a] = c;
				totalCharacterGuessed++;
				correctGuess = true;
			}
		}
		
		
		if(totalCharacterGuessed == myStringArray.length){
			this.isGuessed = true;
		}
		
		return correctGuess; //by default return false, unless user enters a matching one
	}
}
