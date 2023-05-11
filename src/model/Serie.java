package model;

public class Serie {
	String majorGenre;
	String title;
	String subGenre;
	int premiereYear;
	String episodes;
	String status;
	int imdbRating;
	
	public Serie(String majorGenre, String title, String subGenre, int premiereYear, String episodes, String status, int imdbRating) {
		this.majorGenre = majorGenre;
		this.title = title;
		this.subGenre = subGenre;
		this.premiereYear = premiereYear;
		this.episodes = episodes;
		this.status = status;
		this.imdbRating = imdbRating;
	}
	
	public String getMajorGenre() {
		return majorGenre;
	}
	public String getTitle() {
		return title;
	}
	public String getSubGenre() {
		return subGenre;
	}
	public int getPremiereYear() {
		return premiereYear;
	}
	public String getEpisodes() {
		return episodes;
	}
	public String getStatus() {
		return status;
	}
	public int getImdbRating() {
		return imdbRating;
	}
	
}
