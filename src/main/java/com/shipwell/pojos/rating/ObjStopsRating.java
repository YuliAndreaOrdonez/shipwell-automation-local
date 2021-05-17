package com.shipwell.pojos.rating;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObjStopsRating {
   @Builder.Default
   private Integer sequence_id = 0;
   @Builder.Default
   private String stop_type="";
   @Builder.Default
   private String stop_mode = "";
   @Builder.Default
   private String time_zone = "";
   @Builder.Default
   private Objtime_window time_window = null;
   @Builder.Default
   private ObjlocationRating location = null;
}
