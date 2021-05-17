package com.shipwell.steps.booking;

import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.rest.BookingRest;
import com.shipwell.utils.DB;
import io.restassured.response.Response;

public class BookingStep {
    private final BookingRest bookingRestRest = new BookingRest();
    public Response createBooking(ShipwellAuth shipwellAuth, String carrier, String shipmentId) {
        return bookingRestRest.postBooking(shipwellAuth,carrier, shipmentId);
    }

    public void deleteCompanyBooking(String companyId){
        DB.deleteCompanyBooking(companyId);
    }
}
