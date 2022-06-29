package com.nitara.APIFunctions;

import java.io.File;
import java.util.Properties;
import org.json.JSONObject;
import org.testng.Assert;
import com.nitara.Helper.GenerateData;
import com.nitara.utils.ExcelUtils;
import com.nitara.utils.PropertyManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegisterMilkingCattle extends PropertyManager{
	
	
	public String registerMilkingOrDryCattle(String url,String scenario) throws Exception {
		
	Properties prop = new PropertyManager().getProps();

	RestAssured.baseURI = url;
	String abstractname = prop.getProperty("RegisterMilkingOrDryCattle"); //
	String filepath = prop.getProperty("API_Testdata");

	ExcelUtils exceldata = new ExcelUtils();
	
	LoginAPI user = new LoginAPI();
	String usertoken = user.API_FarmerLogin(url);

	RequestSpecification request = RestAssured.given();

	//Update tag numbers in excel
	GenerateData var = new GenerateData();
	String TagNo = var.generateRandomNumber(8);
	exceldata.writeStringData("GeneralData","TagNumber",TagNo, filepath);
	String CoopNo = var.generateRandomNumber(12);
	exceldata.writeStringData("GeneralData","CooperativeTagNumber",CoopNo, filepath); 
	
	String farmId = new GetFarmId().getFarmId(url,usertoken);
	System.out.println(farmId);
	exceldata.writeStringData("GeneralData","farmId",farmId, filepath); 

	JSONObject dataObject = exceldata.readCase("RegMilkingDryCattle",scenario,filepath);

	System.out.println(dataObject);
	request.header("Authorization","Bearer " + usertoken);
	for (String key: dataObject.keySet()){
		if((dataObject.get(key) instanceof String)) 
			if((dataObject.getString(key)).matches("([^\\s]+(\\.(?i)(jpe?g|png))$)")) {
				request.multiPart(key, new File(dataObject.getString(key)));}

			else {
				request.formParam(key, dataObject.get(key));
			}
		else {
			request.formParam(key, dataObject.get(key));
		}

	}
	Response res = request.post(abstractname).then().extract().response();

	//Print response
	res.prettyPeek();

	//Validate status code
	Assert.assertEquals( res.getStatusCode(),200);

	//Validate success message
	String jsonString = res.asString();
	String  message = JsonPath.from(jsonString).get("message");
	Assert.assertEquals(message, "Cattle Registered successfully." );
	
	//To use the numbers use .split(" ") this will give an array of Strings. At index 0 CoopNo and index 1 TagNo.
	return CoopNo+" "+TagNo;
	}
}
