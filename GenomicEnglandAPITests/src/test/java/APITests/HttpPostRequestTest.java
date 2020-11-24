package APITests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class HttpPostRequestTest {

	@Test
	public void testHttpPostRequest_extractChocolatesCupCakesGames() {

		Map<String, String> data = new HashMap<>();

		data.put("id", "900");
		data.put("main", "Cloudy");
		data.put("description", "rain");
		data.put("icon", "02n");

		Response response = RestAssured.given().contentType("application/JSON").body(data).when().post(
				"api.openweathermap.org/data/2.5/weather?q=London&appid=09ff030cfacab11f97d0d36c97e6de29&unit=metric")
				.then().statusCode(201).log().body().extract().response();

		String jsonString = response.asString();

		Assert.assertEquals(jsonString.contains("Cloudy"), true);

	}

}
