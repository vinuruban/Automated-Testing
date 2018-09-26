package com.qa.NESTEDPOSTPersonCUCUMBER;

import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PersonSteps {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	
	JSONArray addressArray = new JSONArray();
	JSONObject nestedAdrsAsOBJ = new JSONObject(); //address 1
	JSONObject nestedAdrs2AsOBJ = new JSONObject(); //address 2
	JSONObject requestParams = new JSONObject();
	
	@Given("^a valid RequestSpec$")
	public void a_valid_RequestSpec() {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI = Constants.personURL;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("userID", "00000000");
	}

	@When("^a post request with city \"([^\"]*)\", description \"([^\"]*)\", id \"([^\"]*)\", name \"([^\"]*)\" and rating \"([^\"]*)\" is sent$")
	public void a_post_request_with_city_description_id_name_and_rating_is_sent(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {
	    // Write code here that turns the phrase above into concrete actions
		nestedAdrsAsOBJ.put("city", arg1);
		nestedAdrsAsOBJ.put("id", arg2);
		nestedAdrsAsOBJ.put("line1", arg3);
		nestedAdrsAsOBJ.put("line2", arg4);
		nestedAdrsAsOBJ.put("state", arg5);
		nestedAdrsAsOBJ.put("zip", arg6);
		
		addressArray.put(nestedAdrsAsOBJ);
	}

	@Then("^the response will have Status Code of \"([^\"]*)\"$")
	public void the_response_will_have_Status_Code_of(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		response = request.when().put("/");
		assertEquals(arg1,response.getStatusCode());
	}

	@When("^a get request is sent$")
	public void a_get_request_is_sent() {
	    // Write code here that turns the phrase above into concrete actions
		request = null;
		request = given().contentType(ContentType.JSON);
		response = request.when().get(Constants.pageURL);
	}

	@Then("^the response will have Status Code of (\\d+)$")
	public void the_response_will_have_Status_Code_of(int arg1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(arg1,response.getStatusCode());
	}

	@When("^a Put request is entered to update id (\\d+)'s description$")
	public void a_Put_request_is_entered_to_update_id_s_description(int arg1) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^a Delete request is sent for id \"([^\"]*)\"$")
	public void a_Delete_request_is_sent_for_id(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	}

}
