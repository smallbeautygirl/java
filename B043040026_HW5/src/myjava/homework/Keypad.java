package myjava.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Keypad {
	
	private BufferedReader br;
	
	// initializes 
	public Keypad () {
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/*
	 *  This function may throw some Exception if the user enters non-integer input.
	 *  You must use try...catch to deal with it.
	 */
	public int getInput() throws IOException{
		/* Fill your code here */
		return Integer.parseInt(this.br.readLine());
	}
}
