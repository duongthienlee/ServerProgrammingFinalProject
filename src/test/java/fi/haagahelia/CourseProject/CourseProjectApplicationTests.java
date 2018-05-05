package fi.haagahelia.CourseProject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.CourseProject.web.CRUDController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseProjectApplicationTests {

	@Autowired
	private CRUDController controller;

	// Smoke testing
	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
