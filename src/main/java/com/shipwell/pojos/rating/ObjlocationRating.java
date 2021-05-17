package com.shipwell.pojos.rating;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObjlocationRating {
    @Builder.Default
    private String location_id="";
    @Builder.Default
    private String name = "";
    @Builder.Default
    private ObjAddressRating address = null;
}
