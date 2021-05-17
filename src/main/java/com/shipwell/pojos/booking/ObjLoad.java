package com.shipwell.pojos.booking;

import java.util.List;

public class ObjLoad {
    private List<ObjStops> stops = null;
    private List<ObjAccessorials> accessorials = null;
    private ObjLoadDetails load_details=null;

    public List<ObjStops> getStops() {
        return stops;
    }

    public ObjLoad setStops(List<ObjStops> stops) {
        this.stops = stops;
        return this;
    }

    public List<ObjAccessorials> getAccessorials() {
        return accessorials;
    }

    public ObjLoad setAccessorials(List<ObjAccessorials> accessorials) {
        this.accessorials = accessorials;
        return this;
    }

    public ObjLoadDetails getLoad_details() {
        return load_details;
    }

    public ObjLoad setLoad_details(ObjLoadDetails load_details) {
        this.load_details = load_details;
        return this;
    }
}
