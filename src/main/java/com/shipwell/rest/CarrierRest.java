package com.shipwell.rest;

import com.shipwell.constants.ConstantServices;
import com.shipwell.constants.EndPoints;
import com.shipwell.pojos.carrier.Carrier;
import com.shipwell.pojos.carrier.EnableServices;
import com.shipwell.pojos.contract.ObjAuthentication;
import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.setup.Rest;
import io.restassured.response.Response;

public class CarrierRest {
    public Response postCarrier(ShipwellAuth shipwellAut, String name, String scacCode, Boolean rating, Boolean booking, Boolean tracking, Boolean imaging, String authorizationMethod, String contentType, String clientId, String clientSecret, String grant_type, String scope, String authenticationMethod, String authorizationKey) {
        return Rest.with()
                .given()
                .header("shipwell-auth", shipwellAut)
                .log()
                .all()
                .contentType(ConstantServices.CONTENT_TYPE_JSON.get())
                .body(carrierInfoRequest(name, scacCode, rating,  booking, tracking, imaging, authorizationMethod, contentType, clientId, clientSecret, grant_type, scope, authenticationMethod, authorizationKey))
                .when()
                .post(ConstantServices.URL.get()+EndPoints.END_POINT_CREATE_CARRIER.get())
                .then()
                .log()
                .ifError()
                .log()
                .status()
                .extract()
                .response();


    }

    private Carrier carrierInfoRequest(String name, String scacCode, Boolean rating, Boolean booking, Boolean tracking, Boolean imaging, String authorizationMethod, String contentType, String clientId, String clientSecret, String grant_type, String scope, String authenticationMethod, String authorizationKey){
        Carrier carrier= new Carrier()
                .setName(name)
                .setScac_code(scacCode)
                .setEnabled_services(new EnableServices()
                        .setRating(rating)
                        .setBooking(booking)
                        .setTracking(tracking)
                        .setImaging(imaging))
                .setAuthorization_method(authorizationMethod)
                .setContent_type(contentType)
                .setCredential_as(ObjAuthentication.builder().client_id(clientId).client_secret(clientSecret).grant_type(grant_type).scope(scope).build())
                .setAuthentication_method(authenticationMethod)
                .setAuthorization_key(authorizationKey);
        return carrier;
    }

    public Response putCarrier(ShipwellAuth shipwellAut, String name, String scacCode, Boolean rating, Boolean booking, Boolean tracking, Boolean imaging, String authorizationMethod, String contentType, String clientId, String clientSecret, String grant_type, String scope, String authenticationMethod, String authorizationKey) {
        return Rest.with()
                .given()
                .header("shipwell-auth", shipwellAut)
                .log()
                .all()
                .contentType(ConstantServices.CONTENT_TYPE_JSON.get())
                .body(carrierInfoRequest(name, scacCode, rating,  booking, tracking, imaging, authorizationMethod, contentType, clientId, clientSecret, grant_type, scope, authenticationMethod, authorizationKey))
                .when()
                .put(ConstantServices.URL.get()+EndPoints.END_POINT_UPDATE_CARRIER.get())
                .then()
                .log()
                .ifError()
                .log()
                .status()
                .extract()
                .response();


    }

}

/*Coyote
Demo Client ID: SHIPWELLTX
Demo Client Secret: wBBbcmjMqMWfwFsx
Prod Client ID: SHIPWELLTX
Prod Client Secret: qRHEgrbTfdzjkvmK
Scope: ExternalApi
Grant Type: client_credentials


uber
###Documentation

- https://developer.uber.com/docs/secured/freight/introduction

### Sandbox environment
- Endpoint: https://sandbox-api.uber.com
- Customer Id: TESTONLY

### Credentials

- [Api Documentation](https://api.coyote.com/docs/index.html)
- Demo Client ID: Q86ffsVQ8fKgv2drdOvtLVBfkOPT2w51
- Demo Client Secret: pn7i6HipcKxunkuP1gonwDw2idQPnZhewck5b9rc
- Prod Client ID: Q86ffsVQ8fKgv2drdOvtLVBfkOPT2w51
- Prod Client Secret: pn7i6HipcKxunkuP1gonwDw2idQPnZhewck5b9rc
- Scope: freight.loads
- Grant Type: client_credentials


Convoy
Demo Client ID: 7mo5roip0ovkpb1vhma6f2vnv4
Demo Client Secret: inuj0606dj6v6eatjbl3esg9mej3c5qn0v0cgua2o37c7ldq97e
Prod Client ID: 1rj2sivked2on0tbitdv7r9pur
Prod Client Secret: cp3l8koejj77hnrnu2jl1tapcje4p2cosrdrdh1tbr8f1ap7tni
Grant Type: client_credentials
 */