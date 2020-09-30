package ee3rdTry;

public class Population {
	
	Individual_2[] individuals;
	int populationSize;
	
	Population(int populationSize){
		this.populationSize = populationSize;
		individuals = new Individual_2[populationSize];
	}
	
	public Population initializePopulation() {
		
		for(int i = 0; i < populationSize; i ++) {
			individuals[i] = new Individual_2().initialize();
		}
		
		return this;
	}
	
	public Individual_2[] getIndividual() {
		return individuals;
	}
	
	public void rank() {
		
		for(int i = 0; i < GeneticAlgorithm.populationSize; i ++) {
			individuals[i].setScore(0);
		}
		
		WordList wl = new WordList();
		String[] words = wl.loadText();
		
		for(int i = 0; i < GeneticAlgorithm.trials_per_generation; i++) {
			
			String answer = WordList.randomWord(words);
			String question = wl.hideLetter(answer);
			
			for(int a = 0; a < populationSize; a++) {
				if(individuals[a].test(question, answer)) {
					individuals[a].setScore(individuals[i].getScore()+1);
				}
			}
		}
		
		boolean needsSort = true;
		
		while(needsSort) {
			needsSort = false;
			for(int i = 1; i != populationSize; i ++) {
				Individual_2 first = individuals[i-1];
				Individual_2 second = individuals[i];
				if(first.getScore() < second.getScore()) {
					needsSort = true;
					individuals[i-1] = second;
					individuals[i] = first;
				}
			}
		}
		
	}

}
