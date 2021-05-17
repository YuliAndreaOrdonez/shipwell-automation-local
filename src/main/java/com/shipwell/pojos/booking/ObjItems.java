package com.shipwell.pojos.booking;

public class ObjItems {
    private String id = "";
    private ObjValue quantity = null;
    private ObjValue weight = null;
    private String packaging_type = "";
    private Integer cargo_value=0;
    private String freight_class = "";
    private String nmfcNumber = "";
    private String commodity_description = "";

    public String getId() {
        return id;
    }

    public ObjItems setId(String id) {
        this.id = id;
        return this;
    }

    public ObjValue getQuantity() {
        return quantity;
    }

    public ObjItems setQuantity(ObjValue quantity) {
        this.quantity = quantity;
        return this;
    }

    public ObjValue getWeight() {
        return weight;
    }

    public ObjItems setWeight(ObjValue weight) {
        this.weight = weight;
        return this;
    }

    public String getPackaging_type() {
        return packaging_type;
    }

    public ObjItems setPackaging_type(String packaging_type) {
        this.packaging_type = packaging_type;
        return this;
    }

    public Integer getCargo_value() {
        return cargo_value;
    }

    public ObjItems setCargo_value(Integer cargo_value) {
        this.cargo_value = cargo_value;
        return this;
    }

    public String getFreight_class() {
        return freight_class;
    }

    public ObjItems setFreight_class(String freight_class) {
        this.freight_class = freight_class;
        return this;
    }

    public String getNmfcNumber() {
        return nmfcNumber;
    }

    public ObjItems setNmfcNumber(String nmfcNumber) {
        this.nmfcNumber = nmfcNumber;
        return this;
    }

    public String getCommodity_description() {
        return commodity_description;
    }

    public ObjItems setCommodity_description(String commodity_description) {
        this.commodity_description = commodity_description;
        return this;
    }
}
