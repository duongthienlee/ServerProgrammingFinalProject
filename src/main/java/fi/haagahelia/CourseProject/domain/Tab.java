package fi.haagahelia.CourseProject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tab {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tabId;
	private String song, type;
	private int rating, downloaded;

	@ManyToOne
	@JoinColumn(name = "id")
	private Artist artist;

	public Tab() {
	}

	public Tab(Artist artist, String song, int rating, String type, int downloaded) {
		super();
		this.artist = artist;
		this.song = song;
		this.rating = rating;
		this.type = type;
		this.downloaded = downloaded;
	}

	public long getId() {
		return tabId;
	}

	public void setId(long tabId) {
		this.tabId = tabId;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDownloaded() {
		return downloaded;
	}

	public void setDownloaded(int downloaded) {
		this.downloaded = downloaded;
	}

	@Override
	public String toString() {
		return "Tab [tabId=" + tabId + ", song=" + song + ", rating=" + rating + ", type=" + type + ", downloaded="
				+ downloaded + ", artist=" + artist + "]";
	}

}
