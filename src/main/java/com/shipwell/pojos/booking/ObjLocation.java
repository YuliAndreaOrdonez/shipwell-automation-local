package com.shipwell.pojos.booking;

import java.util.List;

public class ObjLocation {
   private String location_id="";
   private String name = "";
   private ObjAddress address = null;
   private String facility_id = "";
   private List<ObjContacts> contacts = null;
   private Objgeo_coordinates geo_coordinates = null;
   private String time_zone_offset = "";

   public String getLocation_id() {
      return location_id;
   }

   public ObjLocation setLocation_id(String location_id) {
      this.location_id = location_id;
      return this;
   }

   public String getName() {
      return name;
   }

   public ObjLocation setName(String name) {
      this.name = name;
      return this;
   }

   public ObjAddress getAddress() {
      return address;
   }

   public ObjLocation setAddress(ObjAddress address) {
      this.address = address;
      return this;
   }

   public String getFacility_id() {
      return facility_id;
   }

   public ObjLocation setFacility_id(String facility_id) {
      this.facility_id = facility_id;
      return this;
   }

   public List<ObjContacts> getContacts() {
      return contacts;
   }

   public ObjLocation setContacts(List<ObjContacts> contacts) {
      this.contacts = contacts;
      return this;
   }

   public Objgeo_coordinates getGeo_coordinates() {
      return geo_coordinates;
   }

   public ObjLocation setGeo_coordinates(Objgeo_coordinates geo_coordinates) {
      this.geo_coordinates = geo_coordinates;
      return this;
   }

   public String getTime_zone_offset() {
      return time_zone_offset;
   }

   public ObjLocation setTime_zone_offset(String time_zone_offset) {
      this.time_zone_offset = time_zone_offset;
      return this;
   }
}
