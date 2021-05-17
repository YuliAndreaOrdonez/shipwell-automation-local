package com.shipwell.steps.Rating;

import com.shipwell.pojos.booking.Objweight;
import com.shipwell.pojos.rating.*;
import com.shipwell.pojos.shipwellAuth.ShipwellAuth;
import com.shipwell.rest.RatingRest;
import io.restassured.response.Response;

import java.time.LocalDateTime;
import java.util.Arrays;

public class QuoteStep {

    private final RatingRest ratingRest = new RatingRest();

    public Response createRating(String shipment, ShipwellAuth shipwellAuth, String scac, String shipperId, String quoteId) {
        return ratingRest.postRating(shipwellAuth, Rating.builder()
                        .shipper_id(shipperId)
                        .shipment_id(shipment)
                        .quote_id(quoteId)
                        .equipment_type(Arrays.asList("DRY_VAN"))
                        .notes("string")
                        .scac(scac)
                        .is_hazmat(false)
                        .total_miles(100)
                        .team_driver(true)
                        .is_drop_trailer(false)
                        .commodity("Sample Commodity")
                        .weight(Objweight.builder()
                                .value(6333)
                                .unit("LB")
                                .build())
                        .dimension(Objdimension.builder()
                                .length(53)
                                .height(0)
                                .width(6333)
                                .unit("IN").build())
                        .stops(Arrays.asList(ObjStopsRating.builder()
                                .sequence_id(1)
                                .stop_type("PICKUP")
                                .stop_mode("LIVE")
                                .time_zone("America/Chicago")
                                .time_window(Objtime_window.builder()
                                        .startTime(LocalDateTime.now().plusDays(2).toString())
                                        .endTime(LocalDateTime.now().plusDays(6).toString()).build())
                                .location(ObjlocationRating.builder()
                                        .location_id("BUILDING_1")
                                        .name("BUILDING_1")
                                        .address(ObjAddressRating.builder()
                                                .country("USA")
                                                .line_1("137 North Ave")
                                                .locality("Chicago")
                                                .postal_code("60647")
                                                .region("IL")
                                                .urbanization("string")
                                                .residential(true)
                                                .geolocation(Objgeo_coordinatesRating.builder()
                                                        .latitude(37.7749)
                                                        .longitude(-122.4194).build())
                                                .build())
                                        .build())
                                .build(), ObjStopsRating.builder()
                                .sequence_id(2)
                                .stop_type("DROPOFF")
                                .stop_mode("LIVE")
                                .time_zone("America/Chicago")
                                .time_window(Objtime_window.builder()
                                        .startTime(LocalDateTime.now().plusDays(15).toString())
                                        .endTime(LocalDateTime.now().plusDays(15).toString()).build())
                                .location(ObjlocationRating.builder()
                                        .location_id("BUILDING_2")
                                        .name("BUILDING_2")
                                        .address(ObjAddressRating.builder()
                                                .country("USA")
                                                .line_1("200, International Pkwy")
                                                .locality("Madison")
                                                .postal_code("53703")
                                                .region("WI")
                                                .urbanization("string")
                                                .residential(true)
                                                .geolocation(Objgeo_coordinatesRating.builder()
                                                        .latitude(37.7749)
                                                        .longitude(-122.4194).build())
                                                .build())
                                        .build())
                                .build())).build());
    }
}
