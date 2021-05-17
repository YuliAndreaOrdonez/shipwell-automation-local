package com.shipwell.pojos.rating;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Objtime_window {
    @Builder.Default
    private String startTime= "";
    @Builder.Default
    private String endTime ="";
}
