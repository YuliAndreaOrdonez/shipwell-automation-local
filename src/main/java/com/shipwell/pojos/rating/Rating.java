package com.shipwell.pojos.rating;

import com.shipwell.pojos.booking.Objweight;
import lombok.Builder;
import lombok.Data;
import java.util.List;
@Data
@Builder
public class Rating {
    @Builder.Default
    private String shipper_id = "";
    @Builder.Default
    private String shipment_id = "";
    @Builder.Default
    private String quote_id = "";
    @Builder.Default
    private List<String> equipment_type =null;
    @Builder.Default
    private String notes = "";
    @Builder.Default
    private String scac="";
    @Builder.Default
    private Boolean is_hazmat=false;
    @Builder.Default
    private Integer total_miles= 0;
    @Builder.Default
    private Boolean team_driver=false;
    @Builder.Default
    private Boolean is_drop_trailer=false;
    @Builder.Default
    private String  commodity = "";
    @Builder.Default
    private Objweight weight = null;
    @Builder.Default
    private Objdimension dimension = null;
    @Builder.Default
    private List<ObjStopsRating> stops = null;

}
