package com.shipwell.pojos.booking;

public class ObjAccessorials {
    private String type="";
    private ObjCharge charge = null;


    public String getType() {
        return type;
    }

    public ObjAccessorials setType(String type) {
        this.type = type;
        return this;
    }

    public ObjCharge getCharge() {
        return charge;
    }

    public ObjAccessorials setCharge(ObjCharge charge) {
        this.charge = charge;
        return this;
    }
}

