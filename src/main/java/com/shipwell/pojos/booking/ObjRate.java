package com.shipwell.pojos.booking;

public class ObjRate {
   private Integer value = 0;
   private String currency_type = "";

   public Integer getValue() {
      return value;
   }

   public ObjRate setValue(Integer value) {
      this.value = value;
      return this;
   }

   public String getCurrency_type() {
      return currency_type;
   }

   public ObjRate setCurrency_type(String currency_type) {
      this.currency_type = currency_type;
      return this;
   }
}
