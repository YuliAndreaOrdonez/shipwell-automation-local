package com.shipwell.steps.carrier;

import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.rest.CarrierRest;
import io.restassured.response.Response;


public class CreateCarrierStep {
    private final CarrierRest carrierRest = new CarrierRest();
    public Response createCarrierPost(ShipwellAuth shipwellAuth, String name, String scacCode, Boolean rating, Boolean booking, Boolean tracking, Boolean imaging, String authorizationMethod, String contentType, String clientId, String clientSecret, String grant_type, String scope, String authenticationMethod, String authorizationKey) {
        return carrierRest.postCarrier(shipwellAuth, name, scacCode, rating, booking, tracking, imaging, authorizationMethod, contentType, clientId, clientSecret, grant_type, scope, authenticationMethod, authorizationKey);
    }

    public Response updateCarrier(ShipwellAuth shipwellAuth, String name, String scacCode, Boolean rating, Boolean booking, Boolean tracking, Boolean imaging, String authorizationMethod, String contentType, String clientId, String clientSecret, String grant_type, String scope, String authenticationMethod, String authorizationKey) {
        return carrierRest.putCarrier(shipwellAuth, name, scacCode, rating, booking, tracking, imaging, authorizationMethod, contentType, clientId, clientSecret, grant_type, scope, authenticationMethod, authorizationKey);
    }
}
