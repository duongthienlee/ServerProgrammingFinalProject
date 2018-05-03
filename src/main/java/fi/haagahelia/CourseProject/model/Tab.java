package fi.haagahelia.CourseProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tab {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;
	private String song, type, url;
	private int rating, downloaded;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "artistId")
	private Artist artist;

	public Tab() {
	}

	public Tab(Artist artist, String song, int rating, String type, int downloaded, String url) {
		super();
		this.artist = artist;
		this.song = song;
		this.rating = rating;
		this.type = type;
		this.downloaded = downloaded;
		this.url = url;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Tab [ID=" + ID + ", song=" + song + ", type=" + type + ", url=" + url + ", rating=" + rating
				+ ", downloaded=" + downloaded + ", artist=" + artist + "]";
	}

}
