package com.shipwell.steps.company;

import com.shipwell.pojos.company.Company;
import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.rest.CompanyRest;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;


public class CompanySteps {
    private final CompanyRest companyRest = new CompanyRest();

    @Step
    public Response createCompany(String companyId, String companyName, ShipwellAuth shipwellAuth){
        return companyRest.postCompany(shipwellAuth, Company.builder().company_id(companyId).company_name(companyName).build());
    }

    @Step
    public Response updateCompany(String companyId, String companyName, ShipwellAuth shipwellAuth){
        return companyRest.putCompany(shipwellAuth, Company.builder().company_id(companyId).company_name(companyName).build());
    }
}
