package com.shipwell.pojos.booking;

public class ObjAppointment {
    private String facility_open_date_time_utc = "";
    private String facility_close_date_time_utc = "";
    private String appointment_start_date_time_utc = "";
    private String appointment_end_date_time_utc = "";
    private Boolean confirm_appointment;

    public String getFacility_open_date_time_utc() {
        return facility_open_date_time_utc;
    }

    public ObjAppointment setFacility_open_date_time_utc(String facility_open_date_time_utc) {
        this.facility_open_date_time_utc = facility_open_date_time_utc;
        return this;
    }

    public String getFacility_close_date_time_utc() {
        return facility_close_date_time_utc;
    }

    public ObjAppointment setFacility_close_date_time_utc(String facility_close_date_time_utc) {
        this.facility_close_date_time_utc = facility_close_date_time_utc;
        return this;
    }

    public String getAppointment_start_date_time_utc() {
        return appointment_start_date_time_utc;
    }

    public ObjAppointment setAppointment_start_date_time_utc(String appointment_start_date_time_utc) {
        this.appointment_start_date_time_utc = appointment_start_date_time_utc;
        return this;
    }

    public String getAppointment_end_date_time_utc() {
        return appointment_end_date_time_utc;
    }

    public ObjAppointment setAppointment_end_date_time_utc(String appointment_end_date_time_utc) {
        this.appointment_end_date_time_utc = appointment_end_date_time_utc;
        return this;
    }

    public Boolean getConfirm_appointment() {
        return confirm_appointment;
    }

    public ObjAppointment setConfirm_appointment(Boolean confirm_appointment) {
        this.confirm_appointment = confirm_appointment;
        return this;
    }
}
