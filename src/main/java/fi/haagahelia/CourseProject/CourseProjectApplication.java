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

			aRepository.save(new Artist("Ed", "Sheeran", "England",
					"https://www.youtube.com/channel/UC0C-w0YjGpqDXGB8IHb662A", "1991-02-17"));
			aRepository.save(new Artist("Sung Ha", "Jung", "Korea",
					"https://www.youtube.com/channel/UCjWRi2qaGtKjQyoQLc4OGkw", "1996-09-02"));
			aRepository.save(new Artist("Ewan", "Dobson", "Canada",
					"https://www.youtube.com/channel/UC6SvF0tR6n5al0-3ieIxWcQ", "1981-09-09"));
			aRepository.save(new Artist("Andy", "McKee", "USA",
					"https://www.youtube.com/channel/UCMJecdKUslHToOEpeuRGwXg", "1979-04-04"));
			aRepository.save(
					new Artist("Don", "Ross", "Canada", "https://www.youtube.com/watch?v=YkidVP0AcQ8", "1960-11-19"));
			aRepository.save(new Artist("Thomas", "Leeb", "Austria",
					"https://www.youtube.com/channel/UCSOA2hdMFzzGNbvqFJPxCRA", "1977-09-14"));
			aRepository.save(new Artist("Estas", "Tonne", "Ukraina",
					"https://www.youtube.com/channel/UCTsnTp-g5Rj3VY7Tlm2XQ6A", "1975-04-24"));
			aRepository.save(new Artist("Gabriella", "Quevedo", "Sweden",
					"https://www.youtube.com/channel/UCbK6S8jFtYZ3UnPhWRIJ0bA", "1997-01-12"));
			aRepository.save(new Artist("Ed", "Sheeran", "England",
					"https://www.youtube.com/channel/UC0C-w0YjGpqDXGB8IHb662A", "1991-02-17"));
			aRepository.save(new Artist("Sung Ha", "Jung", "Korea",
					"https://www.youtube.com/channel/UCjWRi2qaGtKjQyoQLc4OGkw", "1996-09-02"));
			aRepository.save(new Artist("Ewan", "Dobson", "Canada",
					"https://www.youtube.com/channel/UC6SvF0tR6n5al0-3ieIxWcQ", "1981-09-09"));
			aRepository.save(new Artist("Andy", "McKee", "USA",
					"https://www.youtube.com/channel/UCMJecdKUslHToOEpeuRGwXg", "1979-04-04"));
			aRepository.save(
					new Artist("Don", "Ross", "Canada", "https://www.youtube.com/watch?v=YkidVP0AcQ8", "1960-11-19"));
			aRepository.save(new Artist("Thomas", "Leeb", "Austria",
					"https://www.youtube.com/channel/UCSOA2hdMFzzGNbvqFJPxCRA", "1977-09-14"));
			aRepository.save(new Artist("Estas", "Tonne", "Ukraina",
					"https://www.youtube.com/channel/UCTsnTp-g5Rj3VY7Tlm2XQ6A", "1975-04-24"));
			aRepository.save(new Artist("Gabriella", "Quevedo", "Sweden",
					"https://www.youtube.com/channel/UCbK6S8jFtYZ3UnPhWRIJ0bA", "1997-01-12"));

			log.info("fetch all books");
			for (Artist artist : aRepository.findAll()) {
				log.info(artist.toString());
			}
		};
	}

}
