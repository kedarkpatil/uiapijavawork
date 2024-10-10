package com.example.apitests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.CountryPage;
import com.example.pages.HomePage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiTest {

    private static String clientId = "7e29e2facf83359855f746fc490443e6";
    private static String clientSecret = "e5NNajm6jNAzrWsKoAdr41WfDiMeS1l6IcGdhmbb";  
    private static String tokenUrl = "https://sandbox-partners-api.airalo.com/v2/token";  
    private static String apiUrl = "https://sandbox-partners-api.airalo.com";    
    private static String accessToken;

    // Step 1: Obtain OAuth2 token
    public static String getOAuthToken() {
        Response response = RestAssured.given()
            //.contentType(ContentType.URLENC)
            .formParam("client_id", clientId)
            .formParam("client_secret", clientSecret)
            .formParam("grant_type", "client_credentials")
            .post(tokenUrl);

        if (response.statusCode() == 200) {
            JSONObject jsonObject = new JSONObject(response.asString());
            JSONObject dataObject = jsonObject.getJSONObject("data");
            String accessToken = dataObject.getString("access_token");
           // System.out.println("Access Token: " + accessToken);
            return accessToken;
        } else {
            throw new RuntimeException("Failed to obtain access token. Status code: " + response.statusCode());
        }
    }

    public static Response postOrderForEsims() {
        	accessToken=getOAuthToken();

        Response response = RestAssured.given()
            .header("Authorization", "Bearer " + accessToken)
            .header("Accept", "application/json")
            .contentType("multipart/form-data")  
            .multiPart("quantity", 6)  
            .multiPart("package_id", "merhaba-7days-1gb") 
            .multiPart("type", "sim")  //optional
            .multiPart("description", "6 sims merhaba-7days-1gb")  //optional
            .multiPart("brand_settings_name", "our perfect brand")  //optional
            .post(apiUrl + "/v2/orders");  
        
//        if (response.getStatusCode() == 200 ||response.getStatusCode() == 201) {
//            System.out.println("POST REQUEST SUCCESS: ");
//        } else {
//            System.out.println("Failed to save data order. Status code: " + response.statusCode());
//        }
        return response;
    }
    
    public static Response getEsimList() {
        	accessToken=getOAuthToken();

        Response response = RestAssured.given()
            .header("Authorization", "Bearer " + accessToken)
            .get(apiUrl + "/v2/sims");  
        return response;
//        if (response.statusCode() == 200) {
//            System.out.println("eSIM List: response " + response.asString());
//            System.out.println("GET REUQEST and Order placed successfully: " + response.statusCode());
//            JSONObject jsonResponse = new JSONObject(response.asString());
//        } else {
//            System.out.println("Failed to get eSIM list. Status code: " + response.statusCode());
//        }
    }
    
    @Test
    public void apitest() throws InterruptedException
    {     
    	getOAuthToken();
    	
    	Response postresponse = postOrderForEsims();
    	Assert.assertEquals(postresponse.statusCode(), 201);
        
        getEsimList();
        Response getresponse = getEsimList();
        Assert.assertEquals(getresponse.statusCode(), 200);
    }
}
	
