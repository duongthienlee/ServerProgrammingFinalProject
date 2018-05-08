package fi.haagahelia.CourseProject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class RestRequestTest extends CourseProjectApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	// creating request and receiving response without need of deploying code to a
	// web container.
	// The created Artist is in CreateArtistIntegrationTest, created 1 Artist with
	// firstName Thien, therefore, only ArtistInfo1 will pass the test
	@Test
	public void validate_ArtistInfo1() throws Exception {
		mockMvc.perform(get("/artistTest")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.firstName").value("Thien")).andExpect(jsonPath("$.lastName").value("Ly"));

	}

	@Test
	public void validate_ArtistInfo2() throws Exception {
		mockMvc.perform(get("/artistTest")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.firstName").value("Jack")).andExpect(jsonPath("$.lastName").value("Ma"));

	}

}
