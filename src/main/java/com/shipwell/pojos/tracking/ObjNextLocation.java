package com.shipwell.pojos.tracking;

import com.shipwell.pojos.booking.Objgeo_coordinates;
import lombok.Data;

@Data
public class ObjNextLocation {
        private ObjAdress address = null;
        private String timeStamp = "";
        private Objgeo_coordinates geoCoordinates = null;

}
