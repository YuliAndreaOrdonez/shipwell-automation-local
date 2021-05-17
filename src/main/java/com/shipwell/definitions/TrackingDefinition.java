package com.shipwell.definitions;

import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.steps.Tracking.TrackingStep;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;

import java.io.IOException;

public class TrackingDefinition {
    private final TrackingStep trackingStep = new TrackingStep();

    @When("shipwell try to find shipment (.*) and carrier (.*) tracking")
    public void getShipmentTracking(String shipmentId, String carrier) throws IOException {
        ObjectMapper obj = new ObjectMapper();
        ShipwellAuth shipwellAuth = obj.readValue(System.getProperty("auth"), ShipwellAuth.class);
        Response response = trackingStep.getTracking(shipwellAuth,shipmentId,carrier);
        Serenity.getCurrentSession().put("response", response);
    }

    @Then("^validate status and tracking created correctly$")
    public void validateTrackingCreatedCorrectly() {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(200, response.statusCode());

    }
    @Then("^validate status and tracking dont get correctly$")
    public void validateTrackingNotCreatedCorrectly() {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(500, response.statusCode());

    }

}
