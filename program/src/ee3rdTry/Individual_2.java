package ee3rdTry;

import java.util.Arrays;

public class Individual_2 {

	public final static int max_patterns = 20;
	Pattern[] patterns;
	public int score = 0;
	
	Individual_2(){
		patterns = new Pattern[max_patterns];
	}
	
	public Individual_2 initialize(){
		for(int i = 0; i < max_patterns; i++) {
			patterns[i] = new Pattern().initializePattern();
		}
		sortPatternsByLength();
		return this;
	}
	
	public boolean test(String question, String answer) {
		for(int i = 0; i < max_patterns; i++) {
			if(question.contains(patterns[i].getPattern()[0]));
			String attempt = question.replace(patterns[i].getPattern()[0], patterns[i].getPattern()[1]);
			if(attempt == answer) {
				return true;
			}
		}
		return false;
	}
	
	public Pattern[] randomSnippet() {
		int start = getRandomNumber(0,max_patterns);
		int end = getRandomNumber(start,max_patterns);
		return Arrays.copyOfRange(patterns, start, end);
	}
	
	/*public Pattern[] breed(Individual_2 partner) {
		Pattern[] holder = randomSnippet();
		for(int i = holder.length; i < max_patterns; i++) {
			holder[i] = partner[i];
		}
	}*/
	
	public Pattern[] getPatterns() {
		return patterns;
	}
	
	public String toString() {
		String string = "";
		for(int i = 0; i < max_patterns; i ++) {
			string = string +"["+ this.patterns[i].toString()+"] ";
		}
		return string;
	}
	
	void sortPatternsByLength(Individual_2 this) {
		boolean needsSort = true;
		while(needsSort) {
			needsSort = false;
			for(int i = 1; i != max_patterns; i ++) {
				Pattern first = patterns[i-1];
				Pattern second = patterns[i];
				if(patterns[i-1].getLength() > patterns[i].getLength()) {
					needsSort = true;
					patterns[i-1] = second;
					patterns[i] = first;
				}
			}
		}
	}
	
	public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int newScore) {
		score = newScore;
	}


}
