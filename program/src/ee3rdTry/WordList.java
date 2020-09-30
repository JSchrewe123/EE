package ee3rdTry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordList {
	
	public String[] loadText() {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(new File("C:\\Users\\jansc\\Downloads\\evolution\\words.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    List<String> lines = new ArrayList<String>();
	    try {
			while (br.readLine() != null) {
			  String line = br.readLine();
			  lines.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return lines.toArray(new String[0]);
	}
	
	public static String randomWord(String words[]) {
		return words[getRandomNumber(0,words.length)];
	}
	
	public String randomFragment(String[] words) {
		String word = randomWord(words);
		int start = getRandomNumber(0, (word.length()-3));
		int end = getRandomNumber((start + 3), word.length());
		return word.substring(start,end);
	}
	
	public String hideLetter(String word) {
		int hidden = getRandomNumber(0,word.length()-1);
		if(hidden == 0) {
			return "?" + word.substring(hidden+1, word.length());
		}
		if(hidden == word.length()) {
			return word.substring(0, hidden-1) + "?";
		}
		
		return word.substring(0,(hidden-1)) + "?" + word.substring((hidden),word.length());
	}
	
	public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
}
