
public class UseMovie implements Cond<Movie> {
	private Movie m;
	
	public UseMovie(Movie e) {
		m=e;
		// TODO Auto-generated constructor stub
	}
	public boolean test(Movie e) {
		m.genres.findFirst();
		e.genres.findFirst();
		if(e.genres.empty())
		return false;
		while(e.genres.last()!=true) {
			if(e.genres.retrieve().equals(m.genres.retrieve()))
				return true;
			e.genres.findNext();
		}
		return false;
		
	}
	

}

