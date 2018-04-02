package fi.haagahelia.CourseProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import fi.haagahelia.CourseProject.domain.Artist;
import fi.haagahelia.CourseProject.domain.ArtistRepository;

@SpringBootApplication
public class CourseProjectApplication {
	private static final Logger log = LoggerFactory.getLogger(CourseProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CourseProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ArtistRepository aRepository) {
		return (args) -> {
			log.info("save artists");
			aRepository.save(new Artist("firstName", "lastName", "country", "youtubeChannel", 32));
			log.info("fetch all books");
			for (Artist artist : aRepository.findAll()) {
				log.info(artist.toString());
			}
		};
	}

}
