package com.shipwell.pojos.booking;

public class ObjCharge {
    private Integer amount = 0;
    private String currency = "";

    public Integer getAmount() {
        return amount;
    }

    public ObjCharge setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public ObjCharge setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
