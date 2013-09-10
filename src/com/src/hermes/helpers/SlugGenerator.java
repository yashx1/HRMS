package com.src.hermes.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Responsible for generating a random alphanumeric string
 * @author Yashaswi Kumar <yashx1@gmail.com>
 */

public class SlugGenerator { 
	private static String alphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final int SLUG_ID_LENGTH = 6;

	/**
	 * Used to generate a random 10 character long alphanumeric string. 
	 * This is primarily used to track replay attacks.
	 * @return 10 character long alphanumeric random string.
	 */
	private static String generate (int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);
		shuffle(alphaNumeric);
		char c;
		for (int i = 0; i < length;) {
			c = alphaNumeric.charAt(random.nextInt(alphaNumeric.length()));
			if (sb.indexOf(String.valueOf(c))==-1) {
				sb.append(c);
				i++;
			} 
		}
		return sb.toString();
	}
	
	
	public static String randomSlug(){
		return generate(SLUG_ID_LENGTH);
	}
	
	 private static void shuffle(String input){
        List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        alphaNumeric = output.toString();
    }

}