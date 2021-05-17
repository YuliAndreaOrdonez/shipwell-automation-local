package com.shipwell.steps.contract;

import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.rest.ContractRest;
import com.shipwell.utils.DB;
import io.restassured.response.Response;


public class CreateContractStep {


    private final ContractRest contractRest = new ContractRest();

    public Response createContractPost(String clientId, String clientSecret, String grant_type, String scope, ShipwellAuth shipwellAuth, boolean active, String companyId, String scacCode) {
        return contractRest.postCreateContract(clientId, clientSecret, grant_type, scope, shipwellAuth, active, companyId, scacCode);

    }

    public void deleteCompanyContract(String companyId) {
        DB.deleteCompanyContract(companyId);
    }

    public Response listCompanyContractsGet(ShipwellAuth shipwellAuth, String companyId){
        return contractRest.listCompanyContractsGet(shipwellAuth, companyId);
    }

    public Response updateContractPut(String clientId, String clientSecret, String grantType, String scope, ShipwellAuth shipwellAuth, Boolean active, Integer contractId) {
        return contractRest.putUpdateContract(clientId, clientSecret, grantType, scope, shipwellAuth, active, contractId);
    }

    public void updateContract(Integer contractId, boolean active) {
        DB.updateContract(contractId, active);
    }
}
