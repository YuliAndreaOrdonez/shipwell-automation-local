package com.shipwell.rest;

import com.shipwell.constants.ConstantServices;
import com.shipwell.constants.EndPoints;
import com.shipwell.pojos.rating.Rating;
import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.setup.Rest;
import io.restassured.response.Response;

public class RatingRest {
    public Response postRating(ShipwellAuth shipwellAut, Rating rating) {
        return Rest.with()
                .given()
                .header(ConstantServices.SHIPWEL_AUTH_HEADER.get(), shipwellAut)
                .log()
                .all()
                .contentType(ConstantServices.CONTENT_TYPE_JSON.get())
                .body(rating)
                .when()
                .post(ConstantServices.URL.get()+EndPoints.END_POINT_QUOTE_RATING.get())
                .then()
                .log()
                .ifError()
                .log()
                .status()
                .extract()
                .response();
       }
}
