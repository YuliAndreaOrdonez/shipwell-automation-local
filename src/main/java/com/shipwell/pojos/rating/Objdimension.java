package com.shipwell.pojos.rating;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Objdimension {
    @Builder.Default
    private Integer length =0;
    @Builder.Default
    private Integer height =0;
    @Builder.Default
    private Integer width= 0;
    @Builder.Default
    private String unit="";
}
