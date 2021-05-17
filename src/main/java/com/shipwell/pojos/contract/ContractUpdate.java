package com.shipwell.pojos.contract;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContractUpdate {
    @Builder.Default
    private ObjAuthentication authentication = null;
    @Builder.Default
    private Boolean active = true;
    @Builder.Default
    private Integer contract_id = 0;
}
