package com.shipwell.definitions;

import com.shipwell.pojos.contract.Contract;
import com.shipwell.pojos.shipwellAuth.Id;
import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.steps.contract.CreateContractStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ContractDefinition   {
    private final CreateContractStep createContractStep = new CreateContractStep();
    private final ShipwellAuth shipwellAuth=new ShipwellAuth();

    @Given("i delete contract for company (.*)")
    public void deleteContract(String companyId){
        createContractStep.deleteCompanyContract(companyId);
    }
    @Given("^shipwell wants to authenticate (.*), (.*)$")
    @When("^shipwell wants update a contract with shipwell auth (.*), (.*)$")
    @Then("^shipwell wants create a new contract with shipwell auth (.*), (.*)$")
    public void shipwellAuth(String companyAuth, String userIdAuth) throws IOException {
        shipwellAuth.setCompany(new Id().setId(companyAuth)).setUser(new Id().setId(userIdAuth));
        ObjectMapper mapper = new ObjectMapper();
        System.setProperty("auth",mapper.writeValueAsString(shipwellAuth));
    }

    @When("^shipwell try makes the creation of the contract with (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void createContract(String clientId, String clientSecret, String grant_type, String scope, boolean active, String companyId, String scacCode){
        String scopeValue = null;
        if(!scope.equals("null")){
            scopeValue = scope;
        }
        Response response = createContractStep.createContractPost(clientId, clientSecret, grant_type, scopeValue, shipwellAuth, active, companyId, scacCode);
        Serenity.getCurrentSession().put("response", response);
    }

    @Then("^validate status and contract created correctly$")
    public void validateContractCreate() {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(200, response.statusCode());

    }

    @Then("^validate status and contract was not created$")
    public void validateContractNotCreate() {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("title"),"test");
        Assert.assertEquals(400, response.statusCode());
    }


    @Then("^validate status and contract was not created because the contract already exists$")
    public void validateContractAlreadyExists() {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("title"),"Bad Request");
        Assert.assertEquals(response.getBody().jsonPath().getString("detail"), "There is already a contract for the company and the specified carrier. ");
        Assert.assertEquals(400, response.statusCode());
    }

    @Then("^validate status and contract was not created because the company does not exist$")
    public void validateCompanyDoesNotExist() {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("title"),"Bad Request");
        Assert.assertEquals(response.getBody().jsonPath().getString("detail"), "Company did not find");
        Assert.assertEquals(400, response.statusCode());
    }

    @Then("^validate status and contract was not created because the carrier does not exist$")
    public void validateTheCarrierDoesNotExist() {
        Response response = (Response) Serenity.getCurrentSession().get("response") ;
        Assert.assertEquals(response.getBody().jsonPath().getString("title"),"Bad Request");
        Assert.assertEquals(response.getBody().jsonPath().getString("detail"), "Carrier did not find");
        Assert.assertEquals(400, response.statusCode());
    }

    @Given("^shipwell active contract with id (.*)$")
    public void updateContract(Integer contractId) {
        createContractStep.updateContract(contractId, true);
    }

    @When("^shipwell try makes the update of the contract with (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void UpdateOfTheContract(Boolean active, Integer contractId, String clientId, String clientSecret, String grantType, String scope) {
        String scopeValue = null;
        if(!scope.equals("null")){
            scopeValue = scope;
        }
        Response response = createContractStep.updateContractPut(clientId, clientSecret, grantType, scopeValue, shipwellAuth, active, contractId);
        Serenity.getCurrentSession().put("response", response);
    }

    @Then("^validate status and contract update fail (.*)$")
    public void validateUpdateFail(Integer contractId){
        Response response = (Response) Serenity.getCurrentSession().get("response");
        Assert.assertEquals("Contract not found", response.getBody().jsonPath().getString("title"));
        Assert.assertEquals("Bad response when updating the contract: "+contractId, response.getBody().jsonPath().getString("detail"));
        Assert.assertEquals(404, response.statusCode());
    }

    @Then("validate status and contract update correctly with active in (.*)")
    public void validateStatusAndContractUpdateCorrectly(Boolean active) {
        Response response = (Response) Serenity.getCurrentSession().get("response");
        Boolean updateValue = response.getBody().jsonPath().getBoolean("active");
        Assert.assertEquals(active, updateValue);
        Assert.assertEquals(200, response.statusCode());
    }

    @When("shipwell try to list company (.*) contracts")
    public void listCompanyContracts(String companyId){
        Response response = createContractStep.listCompanyContractsGet(shipwellAuth, companyId);
        Serenity.getCurrentSession().put("response", response);
    }

    @Then("validate status and company contracts (.*)")
    public void validateListCompanyContracts(String companyId){
        Response response = (Response) Serenity.getCurrentSession().get("response");
        List<Contract> list = response.getBody().jsonPath().getList("", Contract.class);
        Assert.assertEquals(list.get(0).getCompany().getCompany_id(), companyId);
        Assert.assertEquals(200, response.statusCode());
    }

    @Then("validate status and empty company contracts (.*)")
    public void validateEmptyListCompanyContracts(String companyId){
        Response response = (Response) Serenity.getCurrentSession().get("response");
        List<Contract> list = response.getBody().jsonPath().getList("", Contract.class);
        Assert.assertEquals(list.isEmpty(), true);
        Assert.assertEquals(200, response.statusCode());
    }


}
