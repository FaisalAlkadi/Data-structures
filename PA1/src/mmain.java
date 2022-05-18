
public class mmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Movie> movies = new LinkedList<Movie>();
		// First, we add some movies.
		// 1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy
		{
			List<String> genres = new LinkedList<String>();
			genres.insert("Adventure");
			genres.insert("Animation");
			genres.insert("Children");
			genres.insert("Comedy");
			genres.insert("Fantasy");
			movies.insert(new Movie(1, "Toy Story (1995)", genres));
		}
		// 4,Jumanji (1995),Adventure|Children|Fantasy
		{
			List<String> genres = new LinkedList<String>();
			genres.insert("Adventure");
			genres.insert("Children");
			genres.insert("Fantasy");
			movies.insert(new Movie(4, "Jumanji (1995)", genres));
		}
		// 6,Grumpier Old Men (1995),Comedy|Romance
		{
			List<String> genres = new LinkedList<String>();
			genres.insert("Comedy");
			genres.insert("Romance");
			movies.insert(new Movie(6, "Grumpier Old Men (1995)", genres));
		}
		// 7,Jurassic World: Fallen Kingdom(2018),Action|Adventure|Drama|Sci-Fi|Thriller
		{
			List<String> genres = new LinkedList<String>();
			genres.insert("Action");
			genres.insert("Adventure");
			genres.insert("Drama");
			genres.insert("Sci-Fi");
			genres.insert("Thriller");
			movies.insert(new Movie(7, "Jurassic World: Fallen Kingdom (2018)", genres));
		}

		// 9,Pacific Rim: Uprising (2018),Action|Fantasy|Sci-Fi
		{
			List<String> genres = new LinkedList<String>();
			genres.insert("Action");
			genres.insert("Fantasy");
			genres.insert("Sci-Fi");
			movies.insert(new Movie(7, "Pacific Rim: Uprising (2018)", genres));
		}

		// Some queries.
		print(MovieUtils.findMovieById(movies, 7)); // prints: 7,Jurassic World: Fallen Kingdom (2018),Action|Adventure|Drama|Sci-Fi|Thriller
		print(MovieUtils.findMovieById(movies, 10)); // prints: null
		print(MovieUtils.findMovieByTitle(movies, "Jumanji (1995)")); // prints a list with one movie: 4,Jumanji (1995),Adventure|Children|Fantasy
		print(MovieUtils.findMovieByTitle(movies, "Incredibles 2 (2018)")); // prints an empty list
		print(MovieUtils.findMoviesByGenre(movies, "Fantasy")); // prints a list of three movies
		print(MovieUtils.findMoviesByGenre(movies, "Musical")); // prints an empty list
		{
			List<String> genres = new LinkedList<String>();
			genres.insert("Action");
			genres.insert("Sci-Fi");
			print(MovieUtils.findMoviesByGenres(movies, genres)); // prints a list of two movies
		}
		{
			List<String> genres = new LinkedList<String>();
			genres.insert("Adventure");
			genres.insert("Sci-Fi");
			print(MovieUtils.findMoviesByGenres(movies, genres)); // prints a list of one movie
		}
		{
			List<String> genres = new LinkedList<String>();
			genres.insert("Animation");
			genres.insert("Sci-Fi");
			print(MovieUtils.findMoviesByGenres(movies, genres)); // prints an empty list
		}
		{
			List<String> genres = new LinkedList<String>();
			genres.insert("Fantasy");
			print(MovieUtils.findMoviesByGenres(movies, genres)); // prints a list of three movies
		}
	}

	private static void print(Movie m) {
		if (m == null) {
			System.out.println("null");
		} else {
			System.out.print(m.id + "," + m.title + ",");
			if (!m.genres.empty()) {
				m.genres.findFirst();
				while (!m.genres.last()) {
					System.out.print(m.genres.retrieve() + "|");
					m.genres.findNext();
				}
				System.out.print(m.genres.retrieve());
			}
			System.out.println();
		}
	}

	private static void print(List<Movie> movies) {
		System.out.println("-------------------------------------------------------------");
		if (movies.empty()) {
			System.out.println("empty");
		} else {
			movies.findFirst();
			while (!movies.last()) {
				print(movies.retrieve());
				movies.findNext();
			}
			print(movies.retrieve());
		}
		System.out.println("-------------------------------------------------------------");
	}


	}


