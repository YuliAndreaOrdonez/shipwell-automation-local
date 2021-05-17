package com.shipwell.rest;

import com.shipwell.constants.ConstantServices;
import com.shipwell.constants.EndPoints;
import com.shipwell.pojos.contract.ContractUpdate;
import com.shipwell.pojos.contract.NewContract;
import com.shipwell.pojos.contract.ObjAuthentication;
import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.setup.Rest;
import io.restassured.response.Response;

public class ContractRest {
    public Response postCreateContract(String clientId, String clientSecret, String grant_type, String scope, ShipwellAuth shipwellAut, boolean active, String companyId, String scacCode) {
        return Rest.with()
                .given()
                .header("shipwell-auth", shipwellAut)
                .log()
                .all()
                .contentType(ConstantServices.CONTENT_TYPE_JSON.get())
                .body(contractInfoRequest(clientId, clientSecret, grant_type, scope, active, companyId, scacCode))
                .when()
                .post(ConstantServices.URL.get() + EndPoints.END_POINT_CREATE_CONTRACT.get())
                .then()
                .log()
                .ifError()
                .log()
                .status()
                .extract()
                .response();


    }

    public Response listCompanyContractsGet(ShipwellAuth shipwellAut, String companyId) {
        return Rest.with()
                .given()
                .header("shipwell-auth", shipwellAut)
                .log()
                .all()
                .contentType(ConstantServices.CONTENT_TYPE_JSON.get())
                .when()
                .get(ConstantServices.URL.get() + EndPoints.END_POINT_LIST_CONTRACT.get().replace(":companyId", companyId))
                .then()
                .log()
                .ifError()
                .log()
                .status()
                .extract()
                .response();
    }



    private NewContract contractInfoRequest(String clientId, String clientSecret, String grant_type, String scope, boolean active, String companyId, String scacCode) {
        NewContract newContract = new NewContract()
                .setActive(active)
                .setCompany_id(companyId)
                .setScac_code(scacCode)
                .setAuthentication(ObjAuthentication.builder()
                        .client_id(clientId)
                        .client_secret(clientSecret)
                        .grant_type(grant_type)
                        .scope(scope).build());
        return newContract;
    }

    private ContractUpdate contractPutInfoRequest(String clientId, String clientSecret, String grant_type, String scope, boolean active, Integer contractId) {
       return ContractUpdate.builder()
               .authentication(
                       ObjAuthentication.builder()
                               .client_id(clientId)
                               .client_secret(clientSecret)
                               .grant_type(grant_type)
                               .scope(scope).build()
               )
               .contract_id(contractId)
                .active(active)
               .build();
    }


    public Response putUpdateContract(String clientId, String clientSecret, String grantType, String scope, ShipwellAuth shipwellAuth, Boolean active, Integer contractId) {
        return Rest.with()
                .given()
                .header("shipwell-auth", shipwellAuth)
                .log()
                .all()
                .contentType(ConstantServices.CONTENT_TYPE_JSON.get())
                .body(contractPutInfoRequest(clientId, clientSecret, grantType, scope, active, contractId))
                .when()
                .put(ConstantServices.URL.get() + EndPoints.END_POINT_UPDATE_CONTRACT.get())
                .then()
                .log()
                .ifError()
                .log()
                .status()
                .extract()
                .response();
    }
}
