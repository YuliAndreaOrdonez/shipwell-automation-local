package com.shipwell.pojos.booking;

public class Objtemperature_settings {
    private Double minimum = 0.0;
    private Double maximum = 0.0;
    private String  unit= "";
    private Integer pre_cool_temperature = 0;
    private String  operating_instructions="";

    public Double getMinimum() {
        return minimum;
    }

    public Objtemperature_settings setMinimum(Double minimum) {
        this.minimum = minimum;
        return this;
    }

    public Double getMaximum() {
        return maximum;
    }

    public Objtemperature_settings setMaximum(Double maximum) {
        this.maximum = maximum;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public Objtemperature_settings setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public Integer getPre_cool_temperature() {
        return pre_cool_temperature;
    }

    public Objtemperature_settings setPre_cool_temperature(Integer pre_cool_temperature) {
        this.pre_cool_temperature = pre_cool_temperature;
        return this;
    }

    public String getOperating_instructions() {
        return operating_instructions;
    }

    public Objtemperature_settings setOperating_instructions(String operating_instructions) {
        this.operating_instructions = operating_instructions;
        return this;
    }
}
