package com.shipwell.pojos.shipwellAuth;

public class ShipwellAuth {
    private Id company = null;
    private Id user = null;

    public Id getCompany() {
        return company;
    }

    public ShipwellAuth setCompany(Id company) {
        this.company = company;
        return this;
    }

    public Id getUser() {
        return user;
    }

    public ShipwellAuth setUser(Id user) {
        this.user = user;
        return this;
    }



}
