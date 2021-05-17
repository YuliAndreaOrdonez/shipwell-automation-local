package com.shipwell.pojos.booking;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Objweight {
    @Builder.Default
    private Integer value = 0 ;
    @Builder.Default
    private String unit = "";
}
