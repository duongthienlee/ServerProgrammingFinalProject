package fi.haagahelia.CourseProject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.CourseProject.web.CRUDController;
import fi.haagahelia.CourseProject.web.GeneralMappingController;
import fi.haagahelia.CourseProject.web.RestfulController;
import fi.haagahelia.CourseProject.web.UserController;
import fi.haagahelia.CourseProject.web.YoutubeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseProjectApplicationTests {

	@Autowired
	private CRUDController crudController;

	@Autowired
	private GeneralMappingController gmController;

	@Autowired
	private UserController uController;

	@Autowired
	private YoutubeController youtubeController;

	@Autowired
	private RestfulController restfulController;

	// Smoke testing
	@Test
	public void contexLoads() throws Exception {
		assertThat(crudController).isNotNull();
		assertThat(gmController).isNotNull();
		assertThat(uController).isNotNull();
		assertThat(youtubeController).isNotNull();
		assertThat(restfulController).isNotNull();
	}

}
