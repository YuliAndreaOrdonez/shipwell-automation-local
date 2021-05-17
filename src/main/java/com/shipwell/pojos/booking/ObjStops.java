package com.shipwell.pojos.booking;

import java.util.List;

public class ObjStops {
  private Integer sequence = 0;
  private String instructions = "";
  private String requirements = "";
  private ObjLocation location = null;
  private ObjAppointment appointment = null;
  private List<ObjItems> items = null;
  private String stop_type = "";
  private Boolean drop_trailer;
  private String stop_customer_ref="";

  public Integer getSequence() {
    return sequence;
  }

  public ObjStops setSequence(Integer sequence) {
    this.sequence = sequence;
    return this;
  }

  public String getInstructions() {
    return instructions;
  }

  public ObjStops setInstructions(String instructions) {
    this.instructions = instructions;
    return this;
  }

  public String getRequirements() {
    return requirements;
  }

  public ObjStops setRequirements(String requirements) {
    this.requirements = requirements;
    return this;
  }

  public ObjLocation getLocation() {
    return location;
  }

  public ObjStops setLocation(ObjLocation location) {
    this.location = location;
    return this;
  }

  public ObjAppointment getAppointment() {
    return appointment;
  }

  public ObjStops setAppointment(ObjAppointment appointment) {
    this.appointment = appointment;
    return this;
  }

  public List<ObjItems> getItems() {
    return items;
  }

  public ObjStops setItems(List<ObjItems> items) {
    this.items = items;
    return this;
  }

  public String getStop_type() {
    return stop_type;
  }

  public ObjStops setStop_type(String stop_type) {
    this.stop_type = stop_type;
    return this;
  }

  public Boolean getDrop_trailer() {
    return drop_trailer;
  }

  public ObjStops setDrop_trailer(Boolean drop_trailer) {
    this.drop_trailer = drop_trailer;
    return this;
  }

  public String getStop_customer_ref() {
    return stop_customer_ref;
  }

  public ObjStops setStop_customer_ref(String stop_customer_ref) {
    this.stop_customer_ref = stop_customer_ref;
    return this;
  }
}
