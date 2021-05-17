package com.shipwell.pojos.booking;

public class ObjContacts {
    private String first_name="";
    private String last_name="";
    private String preferred_contact_method="";
    private String phone_number="";
    private String email_address="";

    public String getFirst_name() {
        return first_name;
    }

    public ObjContacts setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public ObjContacts setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public String getPreferred_contact_method() {
        return preferred_contact_method;
    }

    public ObjContacts setPreferred_contact_method(String preferred_contact_method) {
        this.preferred_contact_method = preferred_contact_method;
        return this;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public ObjContacts setPhone_number(String phone_number) {
        this.phone_number = phone_number;
        return this;
    }

    public String getEmail_address() {
        return email_address;
    }

    public ObjContacts setEmail_address(String email_address) {
        this.email_address = email_address;
        return this;
    }
}
