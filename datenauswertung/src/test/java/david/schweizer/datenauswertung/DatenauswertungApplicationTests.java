package david.schweizer.datenauswertung;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import feign.Response;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatenauswertungApplicationTests {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8080);

	@Test
	public void contextLoads() {
	}

	@Test
	@Description("Test")
	public void testUser() {
		stubFor(get(urlPathMatching("/"))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json)")
						.withBody("") // Hier den gewünschten Body zum testen einfügen.
				)
		);

		RestTemplate restTemplate = new RestTemplate();
		String resourceURL = "http://localhost:8080/";
		ResponseEntity<String> response = restTemplate.getForEntity(resourceURL, String.class);
		assertNotNull(response);
		//weitere asserts zum testen.
	}



}
