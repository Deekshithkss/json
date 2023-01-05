package json;


import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class testonlocalapi {
	//@Test
	public void get() {
		baseURI="http://localhost:3000/";
		given().get("subjects").then().statusCode(200).log().all();
	

}
	//@Test 
	public void put() {
		JSONObject request = new JSONObject();
		request.put("Firstname", "raghu");
		request.put("Secondname", "raghu");
		request.put("age", 22);
		
		baseURI="http://localhost:3000";
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("users")
		.then()
		.statusCode(201);
	}
	
	@Test
	public void delete() {
		baseURI="http://localhost:3000";
		when().delete("users/6").then().statusCode(200);
		
		
	}
}
