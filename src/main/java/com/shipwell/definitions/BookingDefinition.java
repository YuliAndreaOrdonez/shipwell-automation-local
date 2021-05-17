package com.shipwell.definitions;

import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.steps.booking.BookingStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;


import java.io.IOException;

public class BookingDefinition {

    private final BookingStep bookingStep = new BookingStep();

    @Given("shipwell delete booking for company (.*)")
    public void deleteCompanyBooking(String companyId){
        bookingStep.deleteCompanyBooking(companyId);
    }

    @When("shipwell try makes the creation of the booking to carrier (.*) (.*)")
    public void CreationTheBookingCarrier(String carrier, String shipmentId) throws IOException {
        ObjectMapper obj = new ObjectMapper();
        ShipwellAuth shipwellAuth = obj.readValue(System.getProperty("auth"), ShipwellAuth.class);
        Response response = bookingStep.createBooking(shipwellAuth, carrier, shipmentId);
        Serenity.getCurrentSession().put("response", response);


    }

    @Then("^validate status and booking created correctly$")
    public void validateCreatedCorrectly() {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(200, response.statusCode());
    }

    @Then("validate status and booking was not created because it already exist")
    public void validateBookingAlreadyExists(){
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(400, response.statusCode());
    }
}
