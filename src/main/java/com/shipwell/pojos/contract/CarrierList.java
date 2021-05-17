package com.shipwell.pojos.contract;

import com.shipwell.pojos.carrier.EnableServices;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarrierList {
    private Integer id = 0;
    private String name = "";
    private String scac_code = "";
    private EnableServices enabled_services = null;
    private String authorization_method = "";
    private String content_type = "";
    private String authentication_method = "";
    private String authorization_key = "";
}
