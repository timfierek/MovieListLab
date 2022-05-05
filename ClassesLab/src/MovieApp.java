import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Tim Fierek
 *
 */
public class MovieApp {

	private static Scanner scnr;
	
	public static void main(String[] args) {
		scnr = new Scanner(System.in);
		ArrayList<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Back to the Future", "scifi"));
		movies.add(new Movie("Space Balls", "scifi"));
		movies.add(new Movie("Up", "animated"));
		movies.add(new Movie("Horton Hears a Who", "animated"));
		movies.add(new Movie("Scary Movie 4", "horror"));
		movies.add(new Movie("Saw", "horror"));
		movies.add(new Movie("King Richard", "drama"));
		movies.add(new Movie("House of Gucci", "drama"));
		movies.add(new Movie("Cloudy with a Chance of Meatballs", "animated"));
		movies.add(new Movie("Star Wars", "scifi"));
		
		
		System.out.println("Welcome to the Movie List Application!");
		String category = "";
		boolean loop = true;
		
		while(loop) {
			category = promptInput(movies.size());
			printCategory(movies,category);
			loop = promptContinue();
		}
		
		scnr.close();
	}
	
	/**
	 * Console input and validation method to collect category type from user
	 * 
	 * @param numMovies number of movies in movie list
	 * @return category entered by user in String form
	 */
	public static String promptInput(int numMovies) {
		String input = "";
		System.out.println("\nThere are " + numMovies + " movies in this list.");
		System.out.println("What category are you interested in? ");
		System.out.print("1. animated\n2. drama\n3. horror\n4. scifi\nPlease enter a number: ");
		
		while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
			try {
				input = scnr.nextLine().toLowerCase().trim();
			} catch(Exception e) {
				System.out.print("Invalid input, please enter \"animated\", \"drama\", \"horror\", or \"scifi\": ");
			}
			
			if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
				System.out.print("Invalid input, please enter a number (1-4): ");
			}
		}
		
		int selection = Integer.parseInt(input);
		switch(selection) {
		case 1: 
			input = "animated";
			break;
		case 2:
			input = "drama";
			break;
		case 3:
			input = "horror";
			break;
		case 4: 
			input = "scifi";
			break;
		}
		return input;
	}
	
	/**
	 * Simple console input method to determine if user would like to continue
	 * 
	 * @return true if user enters "y", false if user enters "n"
	 */
	public static boolean promptContinue() {
		String in = "";
		System.out.print("\nContinue? (y/n): ");

		while (!in.equals("y") && !in.equals("n")) {
			try {
				in = scnr.nextLine().toLowerCase().trim();
			} catch (Exception e) {
				System.out.print("Invalid input, please enter \"y\" or \"n\": ");
			}

			if (!in.equals("y") && !in.equals("n")) {
				System.out.print("Invalid input, please enter \"y\" or \"n\": ");
			}
		}
		
		if(in.equals("y")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Console output method to print each movie of a particular category from a movies List
	 * 
	 * @param movies 	List of movies to be traversed
	 * @param category  Category to be printed
	 */
	public static void printCategory(ArrayList<Movie> movies, String category) {
		for(Movie movie : movies) {
			if(movie.getCategory().equals(category)) {
				System.out.println(movie.getTitle());
			}
		}
	}

}
