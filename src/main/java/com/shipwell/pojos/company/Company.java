package com.shipwell.pojos.company;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {
    @Builder.Default
    private String company_id = "";
    @Builder.Default
    private String company_name = "";

}


