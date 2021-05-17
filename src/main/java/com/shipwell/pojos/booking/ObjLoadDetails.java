package com.shipwell.pojos.booking;

public class ObjLoadDetails {
    private String mode = "";
    private ObjRate rate = null;
    private ObjEquipment equipment = null;
    private ObjValue weight = null;
    private ObjValue load_distance = null;
    private Objtemperature_settings temperature_settings = null;

    public String getMode() {
        return mode;
    }

    public ObjLoadDetails setMode(String mode) {
        this.mode = mode;
        return this;
    }

    public ObjRate getRate() {
        return rate;
    }

    public ObjLoadDetails setRate(ObjRate rate) {
        this.rate = rate;
        return this;
    }

    public ObjEquipment getEquipment() {
        return equipment;
    }

    public ObjLoadDetails setEquipment(ObjEquipment equipment) {
        this.equipment = equipment;
        return this;
    }

    public ObjValue getWeight() {
        return weight;
    }

    public ObjLoadDetails setWeight(ObjValue weight) {
        this.weight = weight;
        return this;
    }

    public ObjValue getLoad_distance() {
        return load_distance;
    }

    public ObjLoadDetails setLoad_distance(ObjValue load_distance) {
        this.load_distance = load_distance;
        return this;
    }

    public Objtemperature_settings getTemperature_settings() {
        return temperature_settings;
    }

    public ObjLoadDetails setTemperature_settings(Objtemperature_settings temperature_settings) {
        this.temperature_settings = temperature_settings;
        return this;
    }
}
