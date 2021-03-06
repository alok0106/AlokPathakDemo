package com.NTT.test.automation;

import java.util.HashMap;
import java.util.Map;

import com.nttData.test.automation.ApiOperations;
import com.nttData.test.automation.HttpStatusCodes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class stepDefinition {

	ApiOperations operation = new ApiOperations();
	
	Response response;
	

	@When("^I hit get API with (.*) status$")
	public void i_hit_get_API(String status) {
		
		response = operation.responseFromGetRequest(status);
		
    }

	@Then("^I verify success status code$")
	public void i_verify_success_status_code() {
		Assert.assertEquals(HttpStatusCodes.SUCCESS.getCode(), response.getStatusCode());
		System.out.println("result : " + response.getStatusCode());
	}

	@Then("^I verify response body is not blank$")
	public void i_verify_response_body_is_not_blank() {
		Assert.assertFalse(response.getBody().toString().isBlank());
	}
	

	
	@When("^I hit the API with (.*) (.*) details$")
	public void i_hit_the_API_with_AP0106_details(Integer id, String username) {
	    
		response = operation.responseFromPostRequest(id, username);
	   
	}

	@When("^I hit API with (.*) username$")
	public void i_hit_API_with_AP0106_username(String username) {
		
		response = operation.responseFromGetUserRequest(username);
	}
	
	@Then("^I store values from (.*) response body$")
	public void i_store_values_from_response_body(String status) {
	    
		
		response = operation.responseFromgetRequest(status);
		String userId = response.path("id").toString();
		System.out.println("id : " +userId);
    	String dogName = response.path("name").toString();
    	System.out.println("All dognames are: "+dogName);
		
		dogName = dogName.replaceAll(" ", "");
		String[] dogname = dogName.split(",");
		
		for(int i=0;i<dogname.length;i++) {
			
			dogname[i] = dogname[i].replace("[", "");
			dogname[i] = dogname[i].replace("]", "");
		}
		
	Map<String,Integer> dogList = new HashMap<String,Integer>();

		 for(String s : dogname) {
			
			if(dogList.containsKey(s)) {
					dogList.put(s, dogList.get(s)+1);
				}
			else {
					dogList.put(s, 1);
				}
				}
				System.out.println("sorted count of dog names are : " +dogList);
				  
	}
 /*  @When("^I hit post API with values (.*) (.*) (.*)$")
	public void i_hit_post_api_with_values_boxer_milo_available(int id, String name, String status) {
		response = operation.responseFromPostRequest(id, name, status);
	}
   
   @Then("^I verify successful creation status code$")
	public void i_verify_successful_creation_status_code() {
		Assert.assertEquals(HttpStatusCodes.SUCCESS.getCode(), response.getStatusCode());
	}

   @When("^I hit put API with values (.*) (.*) (.*)$")
	public void i_hit_put_api_with_values_boxer_milo_sold(int id, String name, String status) {
		response = operation.responseFromPutRequest(id, name, status);
	}

   @When("^I hit delete API with (.*) id$")
	public void i_hit_delete_api_with_id(int id) {
		response = operation.responseFromDeleteRequest(id);
	}

	@Then("^I verify that the pet with (.*) (.*) (.*) has been added$")
	public void i_verify_that_the_pet_with_values_has_been_added(int id, String name, String status){
		JsonPath path = new JsonPath(response.asString());
		Assert.assertEquals(id,path.getInt("id"));
		Assert.assertEquals(name,path.getString("name"));
		Assert.assertEquals(status,path.getString("status"));
	}

	@Then("^I verify that the pet's status with (.*) (.*) has been updated to (.*)$")
	public void i_verify_that_the_pet_status_has_been_updated(int id, String name, String status){
		JsonPath path = new JsonPath(response.asString());
		Assert.assertEquals(id,path.getInt("id"));
		Assert.assertEquals(name,path.getString("name"));
		Assert.assertEquals(status,path.getString("status"));
	}*/
}
