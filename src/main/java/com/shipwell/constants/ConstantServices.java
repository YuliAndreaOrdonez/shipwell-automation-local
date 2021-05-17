package com.shipwell.constants;

public enum ConstantServices {
    CONTENT_TYPE_JSON("application/json"),
    SHIPWEL_AUTH_HEADER("shipwell-auth"),
    URL("http://localhost:2022");
    private String value;

    ConstantServices(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }

}
