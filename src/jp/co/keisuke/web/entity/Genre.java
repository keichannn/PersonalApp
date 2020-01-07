package jp.co.keisuke.web.entity;

public class Genre {

	private Integer genreId;
	private String genreStr;

	public Genre() {}

	public Genre(Integer genreId, String genreStr) {

		this.genreId = genreId;
		this.genreStr = genreStr;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getGenreStr() {
		return genreStr;
	}

	public void setGenreStr(String genreStr) {
		this.genreStr = genreStr;
	}
}
