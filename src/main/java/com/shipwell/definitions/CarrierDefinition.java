package com.shipwell.definitions;

import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.steps.carrier.CreateCarrierStep;

import com.shipwell.utils.DB;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;

import java.io.IOException;

public class CarrierDefinition {
    private final CreateCarrierStep createCarrierStep = new CreateCarrierStep();
    private ShipwellAuth shipwellAuth=new ShipwellAuth();

    @When("shipwell try makes the creation of the carrier with (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) data")
    public void shipwellCreationCarrier(String name, String scacCode, Boolean rating, Boolean booking, Boolean tracking, Boolean imaging, String authorizationMethod, String contentType, String clientId, String clientSecret, String grant_type, String scope, String authenticationMethod, String authorizationKey) throws IOException {
        ObjectMapper obj = new ObjectMapper();
        shipwellAuth = obj.readValue(System.getProperty("auth"), ShipwellAuth.class);
        String scopeValue = null;
        if(!scope.equals("null")){
            scopeValue = scope;
        }
        Response response = createCarrierStep.createCarrierPost(shipwellAuth,
                name,
                scacCode,
                rating,
                booking,
                tracking,
                imaging,
                authorizationMethod,
                contentType,
                clientId,
                clientSecret,
                grant_type,
                scopeValue,
                authenticationMethod,
                authorizationKey
        );
        Serenity.getCurrentSession().put("response", response);
    }

    @When("shipwell try makes the update of the carrier with (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) data")
    public void shipwellUpdateCarrier(String name, String scacCode, Boolean rating, Boolean booking, Boolean tracking, Boolean imaging, String authorizationMethod, String contentType, String clientId, String clientSecret, String grant_type, String scope, String authenticationMethod, String authorizationKey) throws IOException {
        ObjectMapper obj = new ObjectMapper();
        shipwellAuth = obj.readValue(System.getProperty("auth"), ShipwellAuth.class);
        String scopeValue = null;
        if(!scope.equals("null")){
            scopeValue = scope;
        }
        Response response = createCarrierStep.updateCarrier(
                shipwellAuth,
                name,
                scacCode,
                rating,
                booking,
                tracking,
                imaging,
                authorizationMethod,
                contentType,
                clientId,
                clientSecret,
                grant_type,
                scopeValue,
                authenticationMethod,
                authorizationKey
        );
        Serenity.getCurrentSession().put("response", response);
    }

    @Then("validate status and carrier created correctly (.*), (.*)")
    public void validateCarrierCreatedCorrectly(String name, String scacCode ) {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("name"),name);
        Assert.assertEquals(response.getBody().jsonPath().getString("scac_code"),scacCode);
        Assert.assertEquals(200, response.statusCode());
    }

    @Then("validate status and carrier updated correctly (.*), (.*)")
    public void validateCarrierUpdatedCorrectly(String name, String scacCode ) {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        //Assert.assertEquals(response.getBody().jsonPath().getString("name"),name);
        //Assert.assertEquals(response.getBody().jsonPath().getString("scac_code"),scacCode);
        //"Bad response when updating the contract: 0"
        Assert.assertEquals(200, response.statusCode());
    }



    @Then("^validate status and carrier not created because it already exists (.*)$")
    public void validateBecauseItAlreadyExists(String scacCode) {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("title"), "Bad Request");
        Assert.assertEquals(response.getBody().jsonPath().getString("detail"), "The carrier already exists with scac_code: "+scacCode);
        Assert.assertEquals(400, response.statusCode());

    }

    @Then("^validate status and carrier not updated because it dont exists (.*)$")
    public void validateBecauseItDontExists(String scacCode) {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("title"), "Carrier - Can't access to the token");
        Assert.assertEquals(response.getBody().jsonPath().getString("detail"), "Carrier not found with sca_code: "+scacCode);
        Assert.assertEquals(400, response.statusCode());

    }

    @Then("delete carrier (.*)")
    public void deleteCarrier(String scacCode){
        DB.deleteCarrier(scacCode);
    }
}
