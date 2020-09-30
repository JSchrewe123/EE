package ee3rdTry;

public class Pattern {
	
	String[] pattern;
	
	Pattern(){
		pattern = new String[2];
	}
	
	int getLength() {
		return pattern[0].length();
	}
	
	public String toString() {
		return pattern[0] + " : " + pattern[1];
	}
	
	public Pattern initializePattern() {
		WordList wl = new WordList();
		String[] words = wl.loadText();
		pattern[1] = wl.randomFragment(words);
		pattern[0] = wl.hideLetter(pattern[1]);
		return this;
	}
	
	public String[] getPattern() {
		return pattern;
	}

}
