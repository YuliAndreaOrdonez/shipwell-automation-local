package com.shipwell.pojos.rating;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Objgeo_coordinatesRating {
    @Builder.Default
    private Double latitude=0.0;
    @Builder.Default
    private Double longitude=0.0;
}
