package fi.haagahelia.CourseProject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import ch.qos.logback.core.net.server.Client;
import fi.haagahelia.CourseProject.model.Artist;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateArtistIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	// Execute the createArtist() test method, it will send a POST to the web server
	// that will be routed to the GeneralMappingController. After that, the
	// controller will
	// create the artist. In the end, the service
	// will use the ArtistRepository to create the artist in the database.
	public void createArtist() {
		Artist artist = new Artist("Thien", "Ly", "Vietnam", "https://www.youtube.com/channel/UCAbWFEsAAstYlXFQo6ngsLA",
				"1996-09-24");
		ResponseEntity<Client> responseEntity = restTemplate.postForEntity("/addArtist", artist, Client.class);
		assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());

	}
}
