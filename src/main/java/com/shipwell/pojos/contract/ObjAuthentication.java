package com.shipwell.pojos.contract;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObjAuthentication {
    @Builder.Default
    private String client_id= "";
    @Builder.Default
    private String client_secret = "";
    @Builder.Default
    private String grant_type = "";
    @Builder.Default
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String scope = null;



}
