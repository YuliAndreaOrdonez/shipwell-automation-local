package com.shipwell.pojos.booking;

public class ObjValue {
    private Double value=0.0;
    private String unit="";

    public Double getValue() {
        return value;
    }

    public ObjValue setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public ObjValue setUnit(String unit) {
        this.unit = unit;
        return this;
    }
}
