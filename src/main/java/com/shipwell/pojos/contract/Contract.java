package com.shipwell.pojos.contract;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Contract {
    private Integer id = 0;
    private CompanyList company = null;
    private CarrierList carrier = null;
    private ObjAuthenticationList authentication = null;
    private Boolean active = true;

}
