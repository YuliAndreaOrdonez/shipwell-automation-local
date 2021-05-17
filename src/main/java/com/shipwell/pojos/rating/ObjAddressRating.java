package com.shipwell.pojos.rating;

import com.shipwell.pojos.booking.Objgeo_coordinates;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObjAddressRating {
     @Builder.Default
     private String country = "";
     @Builder.Default
     private String line_1 = "";
     @Builder.Default
     private String locality = "";
     @Builder.Default
     private String postal_code = "";
     @Builder.Default
     private String region = "";
     @Builder.Default
     private String urbanization = "";
     @Builder.Default
     private Boolean residential=false;
     @Builder.Default
     private Objgeo_coordinatesRating geolocation = null;
}
