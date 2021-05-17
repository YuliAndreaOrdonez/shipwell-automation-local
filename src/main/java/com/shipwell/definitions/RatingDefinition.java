package com.shipwell.definitions;

import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.steps.Rating.QuoteStep;
import com.shipwell.utils.DB;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;

import java.io.IOException;

public class RatingDefinition {

    @Steps
    private final QuoteStep quoteStep = new QuoteStep();

    @When("shipwell try makes the creation of the rating to carrier with shipment (.*), (.*), (.*), (.*)")
    public void CreationTheRating(String shipment, String scac, String shipperId, String quoteId) throws IOException {
        Response response = quoteStep.createRating(shipment, new ObjectMapper().readValue(System.getProperty("auth"), ShipwellAuth.class), scac, shipperId, quoteId);
        Serenity.getCurrentSession().put("response", response);
    }

    @Then("validate status and rating created correctly")
    public void RatingCreatedCorrectly() {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(200, response.statusCode());
    }

    @Then("validate status and rating is not created")
    public void validateRatingNotCreated(){
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertNull(response.getBody().jsonPath().getString("shipment_id"));
        Assert.assertNull(response.getBody().jsonPath().getString("success"));
        Assert.assertNull(response.getBody().jsonPath().getString("errors"));
        Assert.assertEquals(200, response.statusCode());
    }

    @Then("^validate status and it is not created correctly because there is no contract associated with the company (.*)$")
    public void validateNoContractAssociatedWithTheCompany(String company) {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("title"),"Bad Request");
        Assert.assertEquals(response.getBody().jsonPath().getString("detail"), "No contract was found associated with the company: "+company);
        Assert.assertEquals(400, response.statusCode());
    }

    @Then("delete quote (.*)")
    public void deleteCarrier(String shipment){
        DB.deleteQuoteShipment(shipment);
    }

    @Then("^validate status and it is not created correctly because the companyId does not exists$")
    public void validateCompanyIdDoesNotExists() {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("title"),"Shipwell-Auth Error");
        Assert.assertEquals(response.getBody().jsonPath().getString("status"), "Unauthorized");
        Assert.assertEquals(401, response.statusCode());
    }

    @Then("validate status and it is not created correctly beacuse shipmentId is repeated")
    public void validateShipmentIdRepeated() {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("title"),"Bad Request");
        Assert.assertEquals(response.getBody().jsonPath().getString("status"), "400");
        Assert.assertEquals(400, response.statusCode());
    }
}
