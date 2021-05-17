package com.shipwell.rest;

import com.shipwell.constants.ConstantServices;
import com.shipwell.constants.EndPoints;
import com.shipwell.pojos.imagine.Imaging;
import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.setup.Rest;
import io.restassured.response.Response;

public class ImagingRest {
    public Response upload(ShipwellAuth shipwellAut, String file, String type, String extension, String shipmentId, String carrier) {
        return Rest.with()
                .given()
                .header(ConstantServices.SHIPWEL_AUTH_HEADER.get(), shipwellAut)
                .log()
                .all()
                .contentType(ConstantServices.CONTENT_TYPE_JSON.get())
                .body(Imaging.builder().file(file).document_type(type).extension_type(extension).shipment_id(shipmentId).build())
                .when()
                .post(ConstantServices.URL.get()+EndPoints.END_POINT_IMAGING.get().replace(":carrier", carrier))
                .then()
                .log()
                .ifError()
                .log()
                .status()
                .extract()
                .response();
       }

    public Response getFile(ShipwellAuth auth, String type, String shipmentId, String scacCode) {
        return Rest.with()
                .given()
                .header(ConstantServices.SHIPWEL_AUTH_HEADER.get(), auth)
                .log()
                .all()
                .contentType(ConstantServices.CONTENT_TYPE_JSON.get())
                .when()
                .get(ConstantServices.URL.get()+EndPoints.END_POINT_GET_IMAGING.get().replace(":shipmentId", shipmentId).replace(":type", type).replace(":scacCode", scacCode))
                .then()
                .log()
                .ifError()
                .log()
                .status()
                .extract()
                .response();

    }
}
