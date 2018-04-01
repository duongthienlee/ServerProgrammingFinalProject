package fi.haagahelia.CourseProject.domain;

public class Artist {
	private String firstName, lastName, country, youtubeChannel;
	private int age;

	public Artist(String firstName, String lastName, String country, String youtubeChannel, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.youtubeChannel = youtubeChannel;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
