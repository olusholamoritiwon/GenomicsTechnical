package APITests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class HttpGetRequestTest {

	private static RequestSpecification requestSpec;

	// api.openweathermap.org/data/2.5/weather?q=London&appid=09ff030cfacab11f97d0d36c97e6de29&unit=metric
	// api key:{09ff030cfacab11f97d0d36c97e6de29}

	@BeforeClass
	public static void createRequestSpecBuilder() {

		requestSpec = new RequestSpecBuilder().setBaseUri("https:api.openweathermap.org/data/2.5")
				.setBasePath("/weather?q=London&appid=09ff030cfacab11f97d0d36c97e6de29&unit=metric").build();

	}

	@Test
	public void testHttpGETReguest_checkstatusCode_expectHttp200() {

		given().spec(requestSpec).when().get("/weather?q=London&appid=09ff030cfacab11f97d0d36c97e6de29&unit=metric")
				.then().assertThat().statusCode(200);
	}

	@Test
	public void testHttpGETReguest_checkContentType_expectHTML() {

		given().spec(requestSpec).when().get("/weather?q=London&appid=09ff030cfacab11f97d0d36c97e6de29&unit=metric")
				.then().assertThat().contentType(ContentType.JSON);
	}

	@Test
	public void testHttpLogReguestResponseBody() {

		given().spec(requestSpec).log().all().when()
				.get("/weather?q=London&appid=09ff030cfacab11f97d0d36c97e6de29&unit=metric").then().log().body();
	}

	@Test
	public void testHttpLogReguest_extractWeatherDescriptionfromResponseBody_assertEqualToClearSky() {

		String weather = "clear sky";

		given().spec(requestSpec).get("/weather?q=London&appid=09ff030cfacab11f97d0d36c97e6de29&unit=metric").then()
				.extract()

				.path("weather[description].'clear sky' ");

		Assert.assertEquals(weather, "clear Sky");
	}

	@Test
	public void testHttpLogReguest_extractWindspeedfromResponseBody_assertEqualTo21() {

		String wind = "2.1";

		given().spec(requestSpec).get("/weather?q=London&appid=09ff030cfacab11f97d0d36c97e6de29&unit=metric").then()
				.extract()

				.path("wind[speed].'2.1' ");

		Assert.assertEquals(wind, "2.1");

	}

	@Test
	public void testHttpLogReguest_extractPlaceNamefromResponseBody_assertEqualToGB() {

		String placeName = "GB";

		given().spec(requestSpec).get("/weather?q=London&appid=09ff030cfacab11f97d0d36c97e6de29&unit=metric").then()
				.extract()

				.path("sys[country].'GB' ");

		Assert.assertEquals(placeName, "GB");

	}

	@Test
	public void testDetailsWithInvalidWeatherDescription() {

		given().spec(requestSpec).param("weather?q=London", "Dark cloudy Sky").when().then()
				.statusLine("HTTP/1.1 200 OK");

	}

}
