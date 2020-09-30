package ee3rdTry;

public class GeneticAlgorithm {
	
	public final static int trials_per_generation = 200;
	final static int tournamentPopulationSize = 5;
	public static final int num_sexually_selected = 8;
	public static final int num_mutated = 2;
	//public static final int num_elites = 1;
	public final static int populationSize = 50;
	
	public Population evolvePopulation(Population population) {
		return mutatePopulation(crossoverPopulation(population));
	}
	
	private Population crossoverPopulation(Population population) {
		Population crossoverPopulation = new Population(populationSize);
		for(int i = 0; i < populationSize;i++) {
			Individual_2 one = selectTournamentPopulation(population).getIndividual()[0];
			Individual_2 two = selectTournamentPopulation(population).getIndividual()[0];
			crossoverPopulation.getIndividual()[i] = crossoverIndividual(one,two);
		}
		return crossoverPopulation;
	}
	
	private Population mutatePopulation(Population population) {
		for(int i = 0; i < num_mutated; i++) {
			int toBeMutated = getRandomNumber(0,populationSize);
			Individual_2 mutate = population.getIndividual()[toBeMutated];
			population.getIndividual()[toBeMutated] = mutateIndividual(mutate);
		}
		return population;
	}
	
	public Individual_2 mutateIndividual(Individual_2 individual) {
		int number = getRandomNumber(0,Individual_2.max_patterns);
		Pattern newPattern = new Pattern();
		newPattern.initializePattern();
		individual.getPatterns()[number] = newPattern;
		return individual;
	}
	
	public Individual_2 crossoverIndividual(Individual_2 first, Individual_2 second) {
		Individual_2 newIndividual = new Individual_2();
		Pattern[] firstPart = first.randomSnippet();
		
		for(int i = 0; i < firstPart.length; i++) {
			newIndividual.getPatterns()[i] = firstPart[i];
		}
		
		for(int i = firstPart.length; i < Individual_2.max_patterns; i++) {
			newIndividual.getPatterns()[i] = second.getPatterns()[i - firstPart.length];
		}
		
		return newIndividual;
	}
	
	public Population selectTournamentPopulation(Population population) {
		Population tournamentPopulation = new Population(tournamentPopulationSize);
		for(int i = 0; i < tournamentPopulationSize; i ++) {
			tournamentPopulation.getIndividual()[i] = population.getIndividual()[getRandomNumber(0,populationSize)];
		}
		return tournamentPopulation;
	}
	
	public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
}
