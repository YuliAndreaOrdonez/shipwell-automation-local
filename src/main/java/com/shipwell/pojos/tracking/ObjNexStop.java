package com.shipwell.pojos.tracking;

import lombok.Data;

@Data
public class ObjNexStop {
    private Integer sequence = 0;
    private ObjNextLocation location= null;
    private String stop_type = "";

}
