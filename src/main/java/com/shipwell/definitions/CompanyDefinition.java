package com.shipwell.definitions;

import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.steps.company.CompanySteps;
import com.shipwell.utils.DB;
import cucumber.api.java.en.Then;


import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;

import java.io.IOException;

public class CompanyDefinition {
    @Steps
    private final CompanySteps companySteps = new CompanySteps();

    @When("^shipwell try makes the creation of the company with (.*), (.*)$")
    public void createCompany(String companyId, String companyName) throws IOException {
        Response response = companySteps.createCompany(companyId, companyName, new ObjectMapper().readValue(System.getProperty("auth"), ShipwellAuth.class));
        Serenity.getCurrentSession().put("response", response);
    }

    @Then("^validate status and company created correctly (.*), (.*)$")
    public void validateResponse(String company_id, String company_name)
    {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("company_id"),company_id);
        Assert.assertEquals(response.getBody().jsonPath().getString("company_name"),company_name);
        Assert.assertEquals(200, response.statusCode());
    }

    @Then("^validate status and the company already exists (.*)$")
    public void validateStatusAndTheCompanyAlreadyExists(String companyId) {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals( response.getBody().jsonPath().getString("detail"), "The company already exists with company_id: " +companyId);
        Assert.assertEquals(400, response.statusCode());
    }


    @Then("delete company (.*)")
    public void deleteCarrier(String company){
        DB.deleteCompany(company);
    }

    @When("shipwell try makes the update of the company with (.*), (.*)")
    public void updateCompany(String companyId, String companyName) throws IOException {
        Response response = companySteps.updateCompany(companyId, companyName, new ObjectMapper().readValue(System.getProperty("auth"), ShipwellAuth.class));
        Serenity.getCurrentSession().put("response", response);
    }

    @Then("validate status and company updated correctly (.*), (.*)")
    public void validateUpdateResponse(String company_id, String company_name)
    {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("company_id"),company_id);
        Assert.assertEquals(response.getBody().jsonPath().getString("company_name"),company_name);
        Assert.assertEquals(200, response.statusCode());
    }

    @Then("^validate status and the company dont exists (.*)$")
    public void validateStatusAndTheCompanyDontExists(String companyId) {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("detail"), "Company did not find with company_id: " +companyId);
        Assert.assertEquals(400, response.statusCode());
    }
}
