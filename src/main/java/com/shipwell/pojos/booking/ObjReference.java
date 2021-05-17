package com.shipwell.pojos.booking;

public class ObjReference {
    private String type = "";
    private String value = "";

    public String getType() {
        return type;
    }

    public ObjReference setType(String type) {
        this.type = type;
        return this;
    }

    public String getValue() {
        return value;
    }

    public ObjReference setValue(String value) {
        this.value = value;
        return this;
    }
}
