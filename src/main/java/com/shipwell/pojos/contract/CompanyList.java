package com.shipwell.pojos.contract;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyList {
    private Integer id = 0;
    private String company_id = "";
    private String company_name = "";
}
