package com.nitara.APIFunctions;

import java.util.Properties;

import org.json.JSONObject;
import com.nitara.utils.PropertyManager;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetFarmId extends PropertyManager{
	
	public String getFarmId(String url,String token) throws Exception {

		Properties prop = new PropertyManager().getProps();
		
		String abstractname = "AM/GetUserDetails";
		RestAssured.baseURI = url;
		
		RequestSpecification request = RestAssured.given();
		
		String username = prop.getProperty("Username");

		//Create 
		JSONObject requestParams = new JSONObject();
		requestParams.put("userName", username); // Cast

		Response response= request.body(requestParams.toString()).
				header("Content-Type", "application/json").
				header("Authorization","Bearer " + token).
				post(abstractname);

		System.out.println(response.asString());
	
		String jsonString = response.asString();
		JSONObject res = new JSONObject(jsonString);
		JSONObject userDetails = res.getJSONObject("userDetail");
		String farmId = userDetails.getString("farm");
		
		return farmId;



	}


}
