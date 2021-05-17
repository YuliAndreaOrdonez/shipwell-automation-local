package com.shipwell.steps.Tracking;

import com.shipwell.pojos.booking.Objweight;
import com.shipwell.pojos.rating.*;
import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.rest.RatingRest;
import com.shipwell.rest.TrackingRest;
import io.restassured.response.Response;

import java.util.Arrays;

public class TrackingStep {

    private final TrackingRest trackingRest = new TrackingRest();

    public Response getTracking(ShipwellAuth shipwellAuth, String shipmentId, String carrier) {
        return trackingRest.getTracking(shipwellAuth, shipmentId, carrier);
    }
}
