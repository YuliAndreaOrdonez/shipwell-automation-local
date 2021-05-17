package com.shipwell.rest;

import com.shipwell.constants.ConstantServices;
import com.shipwell.constants.EndPoints;
import com.shipwell.pojos.rating.Rating;
import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.setup.Rest;
import io.restassured.response.Response;

public class TrackingRest {
    public Response getTracking(ShipwellAuth shipwellAut, String shipmentId, String carrier) {
        return Rest.with()
                .given()
                .header(ConstantServices.SHIPWEL_AUTH_HEADER.get(), shipwellAut)
                .log()
                .all()
                .contentType(ConstantServices.CONTENT_TYPE_JSON.get())
                .when()
                .get(ConstantServices.URL.get()+EndPoints.END_POINT_GET_TRACKING.get().replace(":loadId", shipmentId).replace(":carrier", carrier))
                .then()
                .log()
                .ifError()
                .log()
                .status()
                .extract()
                .response();
       }
}
