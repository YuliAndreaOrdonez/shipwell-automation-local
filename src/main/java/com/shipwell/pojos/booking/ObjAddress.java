package com.shipwell.pojos.booking;

public class ObjAddress {
    private String line1 = "";
    private String postal_code="";
    private String city_name="";
    private String state_code="";
    private String country_code="";

    public String getLine1() {
        return line1;
    }

    public ObjAddress setLine1(String line1) {
        this.line1 = line1;
        return this;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public ObjAddress setPostal_code(String postal_code) {
        this.postal_code = postal_code;
        return this;
    }

    public String getCity_name() {
        return city_name;
    }

    public ObjAddress setCity_name(String city_name) {
        this.city_name = city_name;
        return this;
    }

    public String getState_code() {
        return state_code;
    }

    public ObjAddress setState_code(String state_code) {
        this.state_code = state_code;
        return this;
    }

    public String getCountry_code() {
        return country_code;
    }

    public ObjAddress setCountry_code(String country_code) {
        this.country_code = country_code;
        return this;
    }
}
