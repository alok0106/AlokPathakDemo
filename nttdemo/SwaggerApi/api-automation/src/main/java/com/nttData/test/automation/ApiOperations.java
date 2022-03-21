package com.nttData.test.automation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttData.test.api.pojo.Category;
import com.nttData.test.api.pojo.PojoRequest;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiOperations {

	ConfigProvider provider = new ConfigProvider();
	Map<String, String> map = provider.getPropValues();
	Response response;
	PojoRequest request = new PojoRequest();
	Category category = new Category();
	

	private String createRequestBody(int id, String username) {
		request.setId(id);
		request.setUsername(username);
		request.setFirstname("firstname");
		request.setLastname("lastname");
		request.setEmail("email");
		request.setPhone("phone");
		request.setPassword("password");
		request.setUserstatus(111);
		
		ObjectMapper mapper = new ObjectMapper();
		String payload = null;
		try {
			payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return payload;
	}

	public Response responseFromGetRequest(String status) {
		RestAssured.baseURI = map.get("getURI") + status;
		response = RestAssured.given().
				   headers("Content-Type", "application/json").
				   contentType(ContentType.JSON).accept(ContentType.JSON).
				   when().
				   get();
		return response;
	}

	public Response responseFromPostRequest(int id, String username) {
		RestAssured.baseURI = map.get("postURI");
		String payload = createRequestBody(id,username);
		response = RestAssured.given().
				   header("Content-Type", "application/json").
				   contentType(ContentType.JSON).accept(ContentType.JSON).
				   body(payload).
				   when().
				   post();
		return response;
	}

	public Response responseFromPutRequest(int id, String username) {
		RestAssured.baseURI = map.get("putURI");
		String payload = createRequestBody(id,username);
		response = RestAssured.given().
				   header("Content-Type", "application/json").
				   contentType(ContentType.JSON).accept(ContentType.JSON).
				   body(payload).
				   when().
				   put();
		return response;
	}

	public Response responseFromGetUserRequest(String status) {
		RestAssured.baseURI = map.get("getuserURI") + status;
		response = RestAssured.given().
				   header("Content-Type", "application/json").
				   contentType(ContentType.JSON).accept(ContentType.JSON).
				   when().
				   get();
		return response;
	}
	public Response responseFromgetRequest(String status) {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
    	RequestSpecification request = RestAssured.given();
    	response = request.request(Method.GET, "/findByStatus?status=sold");
    	
		return response;
	}

}
