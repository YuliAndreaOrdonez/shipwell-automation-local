package com.shipwell.pojos.contract;

public class NewContract {
    private boolean active;
    private String company_id = "";
    private String scac_code= "";
    private ObjAuthentication authentication = null;

    public String getCompany_id() {
        return company_id;
    }

    public NewContract setCompany_id(String company_id) {
        this.company_id = company_id;
        return this;
    }

    public String getScac_code() {
        return scac_code;
    }

    public NewContract setScac_code(String scac_code) {
        this.scac_code = scac_code;
        return this;
    }

    public ObjAuthentication getAuthentication() {
        return authentication;
    }

    public NewContract setAuthentication(ObjAuthentication authentication) {
        this.authentication = authentication;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public NewContract setActive(boolean active) {
        this.active = active;
        return  this;
    }



}
