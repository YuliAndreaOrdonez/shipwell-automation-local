package com.shipwell.definitions;

import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.steps.imaging.ImagingStep;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ImagingDefinition {
    private final ImagingStep imagingStep = new ImagingStep();

    @When("shipwell try to upload a file (.*), (.*), (.*), (.*), (.*)")
    public void createImagin(String file, String type, String extension, String shipmentId, String carrier) throws URISyntaxException, IOException {
        URL resource = getClass().getClassLoader().getResource("files/"+file);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            String fileString = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(resource.toURI())));
            Response response = imagingStep.upload(new ObjectMapper().readValue(System.getProperty("auth"), ShipwellAuth.class), fileString, type, extension, shipmentId, carrier);
            Serenity.getCurrentSession().put("response", response);
        }


    }

    @Then("^validate status and imagine created correctly$")
    public void validateImagineCreated() {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals("400 Bad Request: [\"\\\"Validation failed: \\\\r\\\\n -- : Invalid document extension type.\\\"\"]", response.getBody().jsonPath().getString("detail"));
        Assert.assertEquals(400, response.statusCode());
    }

    @Then("^validate status and imagine was not created correctly (.*)$")
    public void validateImagineWasNotCreated(String shipmentId) {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals("There is no Booking associated with the shipment: "+shipmentId, response.getBody().jsonPath().getString("detail"));
        Assert.assertEquals(400, response.statusCode());
    }

    @When("^shipwell try to get a file (.*), (.*), (.*)$")
    public void getFile(String type, String shipmentId, String scacCode) throws IOException {
        Response response = imagingStep.getFile(new ObjectMapper().readValue(System.getProperty("auth"), ShipwellAuth.class), type, shipmentId, scacCode);
        Serenity.getCurrentSession().put("response", response);
    }

    @Then("validate status and file (.*)")
    public void validateFile(String type){
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(type, response.getBody().jsonPath().getString("document_type"));
        Assert.assertEquals(200, response.statusCode());
    }

    @Then("validate status and get file failed")
    public void validateFileFail(){
        Response response = (Response) Serenity.getCurrentSession().get("response");
        Assert.assertEquals(400, response.statusCode());
    }
}
