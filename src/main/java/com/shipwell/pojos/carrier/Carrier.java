package com.shipwell.pojos.carrier;

import com.shipwell.pojos.contract.ObjAuthentication;

public class Carrier {

    private String name = "";
    private String scac_code = "";
    private EnableServices enabled_services = null;
    private String authorization_method = "";
    private String content_type = "";
    private ObjAuthentication credential_as = null;
    private String authentication_method = "";
    private String authorization_key = "";

    public String getName() {
        return name;
    }

    public Carrier setName(String name) {
        this.name = name;
        return this;
    }

    public String getScac_code() {
        return scac_code;
    }

    public Carrier setScac_code(String scac_code) {
        this.scac_code = scac_code;
        return this;
    }

    public EnableServices getEnabled_services() {
        return enabled_services;
    }

    public Carrier setEnabled_services(EnableServices enabled_services) {
        this.enabled_services = enabled_services;
        return this;
    }

    public String getAuthorization_method() {
        return authorization_method;
    }

    public Carrier setAuthorization_method(String authorization_method) {
        this.authorization_method = authorization_method;
        return this;
    }

    public String getContent_type() {
        return content_type;
    }

    public Carrier setContent_type(String content_type) {
        this.content_type = content_type;
        return this;
    }

    public ObjAuthentication getCredential_as() {
        return credential_as;
    }

    public Carrier setCredential_as(ObjAuthentication credential_as) {
        this.credential_as = credential_as;
        return this;
    }

    public String getAuthentication_method() {
        return authentication_method;
    }

    public Carrier setAuthentication_method(String authentication_method) {
        this.authentication_method = authentication_method;
        return this;
    }

    public String getAuthorization_key() {
        return authorization_key;
    }

    public Carrier setAuthorization_key(String authorization_key) {
        this.authorization_key = authorization_key;
        return this;
    }
}
