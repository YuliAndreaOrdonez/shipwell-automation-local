package com.shipwell.steps.imaging;

import com.shipwell.pojos.booking.Objweight;
import com.shipwell.pojos.rating.*;
import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.rest.ImagingRest;
import com.shipwell.rest.RatingRest;
import cucumber.api.java.bs.I;
import io.restassured.response.Response;

import java.util.Arrays;

public class ImagingStep {

    private final ImagingRest imagingRest = new ImagingRest();

    public Response upload(ShipwellAuth shipwellAuth, String file, String type, String extension, String shipmentId, String carrier) {
        return imagingRest.upload(shipwellAuth, file, type, extension, shipmentId, carrier);
    }

    public Response getFile(ShipwellAuth auth, String type, String shipmentId, String scacCode) {
        return imagingRest.getFile(auth, type,shipmentId,scacCode);
    }
}
