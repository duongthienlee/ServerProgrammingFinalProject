package fi.haagahelia.CourseProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import fi.haagahelia.CourseProject.domain.Artist;
import fi.haagahelia.CourseProject.domain.ArtistRepository;
import fi.haagahelia.CourseProject.domain.Tab;
import fi.haagahelia.CourseProject.domain.TabRepository;

@SpringBootApplication
public class CourseProjectApplication {
	private static final Logger log = LoggerFactory.getLogger(CourseProjectApplication.class);
	private static final Logger log2 = LoggerFactory.getLogger(CourseProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CourseProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ArtistRepository aRepository, TabRepository tRepository) {
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
			aRepository.save(new Artist("Elvis", "Presley", "USA", "https://www.youtube.com/user/ElvisPresleyVEVO",
					"1935-01-08"));

			log2.info("save tab");
			tRepository.save(new Tab(aRepository.findByFirstName("Ed").get(0), "Perfect", 5, "Chords", 12,
					"https://tabs.ultimate-guitar.com/tab/ed_sheeran/perfect_chords_1956589"));
			tRepository.save(new Tab(aRepository.findByFirstName("Ed").get(0), "All About It", 5, "Chords", 12,
					"https://tabs.ultimate-guitar.com/tab/hoodie_allen/all_about_it_chords_1677518"));
			tRepository.save(new Tab(aRepository.findByFirstName("Ed").get(0), "Be My Forever", 4, "Chords", 34,
					"https://tabs.ultimate-guitar.com/tab/christina_perri/be_my_forever_chords_1464118"));
			tRepository.save(new Tab(aRepository.findByFirstName("Ed").get(0), "Dark Times", 5, "Chords", 132,
					"https://tabs.ultimate-guitar.com/tab/the_weeknd/dark_times_chords_1762376"));
			tRepository.save(new Tab(aRepository.findByFirstName("Ed").get(0), "Everything has changed", 3, "Tab", 56,
					"https://tabs.ultimate-guitar.com/tab/taylor_swift/everything_has_changed_tabs_1190062"));
			tRepository.save(new Tab(aRepository.findByFirstName("Elvis").get(0), "Amazing Grace", 5, "Tab", 123,
					"https://tabs.ultimate-guitar.com/tab/elvis_presley/amazing_grace_tabs_985635"));
			tRepository.save(new Tab(aRepository.findByFirstName("Sung Ha").get(0), "Havana", 5, "Tab", 1235,
					"https://tabs.ultimate-guitar.com/tab/sungha_jung/havana_tabs_2330583"));
			tRepository.save(new Tab(aRepository.findByFirstName("Sung Ha").get(0), "Haru Haru", 5, "Tab", 1223,
					"https://tabs.ultimate-guitar.com/tab/sungha_jung/haru_haru_guitar_pro_1041255"));
			tRepository.save(new Tab(aRepository.findByFirstName("Sung Ha").get(0), "A Thousand Years", 5, "Tab", 1231,
					"https://tabs.ultimate-guitar.com/tab/sungha_jung/a_thousand_years_tabs_1241122"));
			tRepository.save(new Tab(aRepository.findByFirstName("Sung Ha").get(0), "Beat It", 5, "Tab", 1211,
					"https://tabs.ultimate-guitar.com/tab/sungha_jung/beat_it_tabs_1189438"));

			log.info("fetch all artists");
			for (Artist artist : aRepository.findAll()) {
				log.info(artist.toString());
			}
			log2.info("fetch all tabs");
			for (Tab tab : tRepository.findAll()) {
				log.info(tab.toString());
			}
		};
	}

}
