package com.shipwell.constants;

public enum EndPoints {
    END_POINT_CREATE_CONTRACT ("/api/v1/contract/create"),
    END_POINT_UPDATE_CONTRACT ("/api/v1/contract/edit"),
    END_POINT_LIST_CONTRACT ("/api/v1/contract/:companyId/list"),
    END_POINT_CREATE_CARRIER("/api/v1/carrier/create"),
    END_POINT_UPDATE_CARRIER("/api/v1/carrier/edit"),
    END_POINT_CREATE_COMPANY("/api/v1/company/create"),
    END_POINT_UPDATE_COMPANY("/api/v1/company/edit"),
    END_POINT_QUOTE_RATING("/api/v1/rating/quote"),
    END_POINT_CREATE_BOOKING("/api/v1/booking/load/"),
    END_POINT_GET_TRACKING("/api/v1/tracking/:loadId/:carrier"),
    END_POINT_IMAGING("/api/v1/imaging/upload/:carrier"),
    END_POINT_GET_IMAGING("/api/v1/imaging/find/:shipmentId/:type/:scacCode");


    private String value;
    EndPoints(String value) {
        this.value = value;
    }
    public String get() {
        return value;
    }
}
