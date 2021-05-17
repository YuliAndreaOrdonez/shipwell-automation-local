package com.shipwell.pojos.rating;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Objtemperature_specs {
    @Builder.Default
    private Double minimum = 0.0;
    @Builder.Default
    private Double maximum = 0.0;
    @Builder.Default
    private String  unit= "";
    @Builder.Default
    private String  operating_instructions="";
}

