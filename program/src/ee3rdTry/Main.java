package ee3rdTry;

public class Main {
	public static final int num_generations = 100;
	
	public static void main(String[] args) {
		
		GeneticAlgorithm gA = new GeneticAlgorithm();
		Population population = new Population(GeneticAlgorithm.populationSize);
		population.initializePopulation();
		population.rank();
		
		for(int i = 0; i < num_generations; i ++) {
			population = gA.evolvePopulation(population);
			population.rank();
		}
		
		Individual_2 best = population.getIndividual()[0];
		
		System.out.println("highest percentage correct guesses = " + ((best.getScore()/GeneticAlgorithm.trials_per_generation)*100));
		
		System.out.println("Best Individual -->" + best.toString());
		
		//System.out.println(population.);

	}

}
