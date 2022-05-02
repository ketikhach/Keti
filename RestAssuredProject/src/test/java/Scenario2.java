import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Scenario2 {
	@Test
	public void AddUser() {
		RestAssured.baseURI = "https://bookstore.toolsqa.com";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("userName", "uniqueUser");
		requestParams.put("password", "Automation@!@123");

		request.body(requestParams.toString());
		request.post("/Account/v1/User");
	}

	@Test
	public void NotAuthorized() {
		RestAssured.baseURI = "https://bookstore.toolsqa.com";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("userName", "uniqueUser");
		requestParams.put("password", "Automation@!@123");

		request.body(requestParams.toString());
		Response response = request.post("/Account/v1/Authorized");

		Assert.assertEquals(response.getBody(), "false");
	}

	@Test
	public void GenerateToken() {
		RestAssured.baseURI = "https://bookstore.toolsqa.com";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("userName", "uniqueUser");
		requestParams.put("password", "Automation@!@123");

		request.body(requestParams.toString());
        request.post("/Account/v1/GenerateToken");
	}

	@Test
	public void AlreadyAuthorized() {
		RestAssured.baseURI = "https://bookstore.toolsqa.com";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("userName", "uniqueUser");
		requestParams.put("password", "Automation@!@123");

		request.body(requestParams.toString());
		Response response = request.post("/Account/v1/Authorized");

		Assert.assertEquals(response.getBody(), "true");
	}

}
