package fi.haagahelia.CourseProject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.CourseProject.model.Artist;
import fi.haagahelia.CourseProject.model.Tab;
import fi.haagahelia.CourseProject.model.User;
import fi.haagahelia.CourseProject.repository.ArtistRepository;
import fi.haagahelia.CourseProject.repository.TabRepository;
import fi.haagahelia.CourseProject.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
// Test all repositories using H2 in memory database
public class AllRepositoriesTest {
	@Autowired
	private TabRepository tRepository;
	@Autowired
	private ArtistRepository aRepository;
	@Autowired
	private UserRepository uRepository;

	/*-----------------------------------Test Tab Add, Delete functionalities-------------------------------- */
	@Test
	public void TestTabCrud() {
		// Add new Tab for testing
		Tab tab = new Tab(aRepository.findByFirstNameAndLastName("Ed", "Sheeran").get(0), "Perfect", 5, "Chords", 12,
				"https://tabs.ultimate-guitar.com/tab/ed_sheeran/perfect_chords_1956589");
		// save the added tab to tab repository
		tRepository.save(tab);

		// assert that the added tab is created and saved in the tab repository
		assertThat(tab.getID()).isNotNull();
		assertThat(tRepository.findById(tab.getID())).isNotNull();

		// now delete the added tab out of the tab repository
		tRepository.deleteById(tab.getID());

		/*
		 * Verify that the deleted tab exists in the repository or not, If false, then
		 * it has been deleted
		 */
		assertThat(tRepository.existsById(tab.getID())).isFalse();
	}

	/*-----------------------------------Test Artist Add, Delete functionalities-------------------------------- */
	@Test
	public void TestArtistCrud() {
		// Add a new artist for testing
		Artist artist = new Artist("Thien", "Ly", "Vietnam",
				"https://www.youtube.com/channel/UCAbWFEsAAstYlXFQo6ngsLA?view_as=subscriber", "1996-01-01");
		aRepository.save(artist);

		// assert that the added artist is created and saved in the artist repository
		assertThat(artist.getArtistId()).isNotNull();
		assertThat(aRepository.findById(artist.getArtistId())).isNotNull();

		// now delete the added artist out of the artist repository
		aRepository.deleteById(artist.getArtistId());

		/*
		 * Verify that the deleted artist exists in the repository or not, If false,
		 * then it has been deleted
		 */
		assertThat(aRepository.existsById(artist.getArtistId())).isFalse();

	}

	/*-----------------------------------Test User Add, Delete functionalities-------------------------------- */
	@Test
	public void TestUserCrud() {
		// Add a new user for testing
		User user = new User("test", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "test@gmail.com",
				"ROLE_ADMIN");
		uRepository.save(user);
		// assert that the added user is created and saved in the user repository
		assertThat(user.getId()).isNotNull();
		assertThat(uRepository.findById(user.getId())).isNotNull();
		// now delete the added user out of the user repository
		uRepository.deleteById(user.getId());
		/*
		 * * Verify that the deleted user still exists in the repository or not, If //
		 * false, * then it has been deleted
		 */
		assertThat(uRepository.existsById(user.getId())).isFalse();
	}

}