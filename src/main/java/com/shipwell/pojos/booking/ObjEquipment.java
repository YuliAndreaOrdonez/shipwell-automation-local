package com.shipwell.pojos.booking;

public class ObjEquipment {
    private String type="";
    private ObjValue height=null;
    private ObjValue length=null;
    private ObjValue width=null;

    public String getType() {
        return type;
    }

    public ObjEquipment setType(String type) {
        this.type = type;
        return this;
    }

    public ObjValue getHeight() {
        return height;
    }

    public ObjEquipment setHeight(ObjValue height) {
        this.height = height;
        return this;
    }

    public ObjValue getLength() {
        return length;
    }

    public ObjEquipment setLength(ObjValue length) {
        this.length = length;
        return this;
    }

    public ObjValue getWidth() {
        return width;
    }

    public ObjEquipment setWidth(ObjValue width) {
        this.width = width;
        return this;
    }
}
