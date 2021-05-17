package com.shipwell.pojos.contract;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ObjAuthenticationList {
    private String client_id= "";
    private String client_secret = "";
    private String grant_type = "";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String scope = null;



}
