package fi.haagahelia.CourseProject.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long artistId;
	private String firstName, lastName, country, youtubeChannel, birthday;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "artist")
	private List<Tab> tabs;
	
	

	public Artist() {
	}

	public Artist(String firstName, String lastName, String country, String youtubeChannel, String birthday) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.youtubeChannel = youtubeChannel;
		this.birthday = birthday;
	}

	

	public long getArtistId() {
		return artistId;
	}

	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public List<Tab> getTabs() {
		return tabs;
	}

	public void setTabs(List<Tab> tabs) {
		this.tabs = tabs;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", firstName=" + firstName + ", lastName=" + lastName + ", country=" + country
				+ ", youtubeChannel=" + youtubeChannel + ", birthday=" + birthday + "]";
	}

}
