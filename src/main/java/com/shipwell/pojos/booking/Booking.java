package com.shipwell.pojos.booking;

import java.util.List;

public class Booking {
    private List<ObjReference> references = null;
    private String notes = "";
    private ObjLoad load = null;
    private String shipper_id = "";
    private String shipment_id = "";
    private String quote_id = "";

    public List<ObjReference> getReferences() {
        return references;
    }

    public Booking setReferences(List<ObjReference> references) {
        this.references = references;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Booking setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ObjLoad getLoad() {
        return load;
    }

    public Booking setLoad(ObjLoad load) {
        this.load = load;
        return this;
    }

    public String getShipper_id() {
        return shipper_id;
    }

    public Booking setShipper_id(String shipper_id) {
        this.shipper_id = shipper_id;
        return this;
    }

    public String getShipment_id() {
        return shipment_id;
    }

    public Booking setShipment_id(String shipment_id) {
        this.shipment_id = shipment_id;
        return this;
    }

    public String getQuote_id() {
        return quote_id;
    }

    public Booking setQuote_id(String quote_id) {
        this.quote_id = quote_id;
        return this;
    }
}
