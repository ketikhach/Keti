import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class RegistrationSuccessful {
	
	@DataProvider(name = "DataForValidation")
	public Object[][] dataForValidation() {
		Object[][] data = {{"automation", "Automation@!@123"},{"automation", "Automation@2"},{"automation", ""}};
		return data;
	}
	
	@Test(dataProvider = "DataForValidation")
	public void RegistrationSuccess(String userName, String password) {
	        RestAssured.baseURI = "https://bookstore.toolsqa.com";
	        RequestSpecification request = RestAssured.given();

	        JSONObject requestParams = new JSONObject();
	        requestParams.put("userName", userName);
	        requestParams.put("password", password);

	        request.body(requestParams.toString());
	        Response response = request.post("/Account/AccountV1User");

	        System.out.println(response.getBody().asString());
	        }
}
