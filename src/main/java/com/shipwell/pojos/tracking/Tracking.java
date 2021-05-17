package com.shipwell.pojos.tracking;

import com.shipwell.pojos.booking.ObjValue;
import lombok.Data;

@Data
public class Tracking {
        private ObjNextLocation latest_location = null;
        private ObjNexStop next_stop = null;
        private String estimated_arrival = "";
        private ObjValue next_stop_distance = null;

}
