package com.shipwell.rest;

import com.shipwell.constants.ConstantServices;
import com.shipwell.constants.EndPoints;
import com.shipwell.pojos.company.Company;
import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.setup.Rest;
import io.restassured.response.Response;
public class CompanyRest {
    public Response postCompany(ShipwellAuth shipwellAut, Company company) {
        return Rest.with()
                .given()
                .header(ConstantServices.SHIPWEL_AUTH_HEADER.get(), shipwellAut)
                .log()
                .all()
                .contentType(ConstantServices.CONTENT_TYPE_JSON.get())
                .body(company)
                .when()
                .post(ConstantServices.URL.get()+EndPoints.END_POINT_CREATE_COMPANY.get())
                .then()
                .log()
                .ifError()
                .log()
                .status()
                .extract()
                .response();

    }

    public Response putCompany(ShipwellAuth shipwellAut, Company company) {
        return Rest.with()
                .given()
                .header(ConstantServices.SHIPWEL_AUTH_HEADER.get(), shipwellAut)
                .log()
                .all()
                .contentType(ConstantServices.CONTENT_TYPE_JSON.get())
                .body(company)
                .when()
                .put(ConstantServices.URL.get()+EndPoints.END_POINT_UPDATE_COMPANY.get())
                .then()
                .log()
                .ifError()
                .log()
                .status()
                .extract()
                .response();

    }
}
