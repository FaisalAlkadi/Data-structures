public class MovieUtils {
	// Return the movie with the given id if found, null otherwise.
	public static Movie findMovieById(List<Movie> movies, int id) {
		movies.findFirst();
		if(movies.empty())
			return null;
		while(movies.last()==false) {
			if(movies.retrieve().id==id)
				return movies.retrieve();
			movies.findNext();
		}
		if(movies.retrieve().id==id)
			return movies.retrieve();
		return null;
	}
	
	
	
	
	
	// Return the list of movies having a given title. If none is found, empty list is returned.
	public static List<Movie> findMovieByTitle(List<Movie> movies, String title) {
		List<Movie> new_Node =new LinkedList<>();
		movies.findFirst();
		if(movies.empty())
			return new_Node;
		while(movies.last()!=true) {
			if(movies.retrieve().title.equals(title)) 
				new_Node.insert(movies.retrieve());
			movies.findNext();
		}
		if(movies.retrieve().title.equals(title)) 
			new_Node.insert(movies.retrieve());
		return new_Node;
	}
	// Return the list of movies of a given genre. If none is found, empty list is returned.
	public static List<Movie> findMoviesByGenre(List<Movie> movies, String genre) {
		List<Movie> new_Node =new LinkedList<>();
		movies.findFirst();
		if(movies.empty())
			return new_Node;
		for(;movies.last()!=true;movies.findNext()) {
			StringEqualCond check=new StringEqualCond(genre);
			if(movies.retrieve().genres.findFirstEle(check))
				new_Node.insert(movies.retrieve());
			
		}
		StringEqualCond check=new StringEqualCond(genre);
		if(movies.retrieve().genres.findFirstEle(check)) 
			new_Node.insert(movies.retrieve());	
		return new_Node;
	}	
	
	public static List<Movie> findMoviesByGenres(List<Movie> movies, List<String> genres) {
	List<Movie> new_Node =new LinkedList<>();
	movies.findFirst();
	genres.findFirst();
	if(movies.empty()||genres.empty())
		return new_Node;
	StringEqualCond check=new StringEqualCond(genres.retrieve());
	
	
	while(movies.last()!=true) {
		genres.findFirst();
		while(genres.last()!=true) {
			check=new StringEqualCond(genres.retrieve());
			if(!(movies.retrieve().genres.findFirstEle(check))) {
				break;}
		genres.findNext();
		}
		
	
		if(genres.last()) {
			check=new StringEqualCond(genres.retrieve());
			if(movies.retrieve().genres.findFirstEle(check)) {
				new_Node.insert(movies.retrieve());
			}
			}
		movies.findNext();
	}
	genres.findFirst();
	while(genres.last()!=true) {
		
		check=new StringEqualCond(genres.retrieve());
		if(!(movies.retrieve().genres.findFirstEle(check))) {
			break;}
	genres.findNext();
	}
	

	if(genres.last()) {
		
		
		check=new StringEqualCond(genres.retrieve());
		if(movies.retrieve().genres.findFirstEle(check)) {
			new_Node.insert(movies.retrieve());
		}
		}
	return new_Node;
}

	}
