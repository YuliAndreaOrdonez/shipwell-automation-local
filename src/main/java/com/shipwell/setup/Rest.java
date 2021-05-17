package com.shipwell.setup;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class Rest {
  public static RequestSpecification with() {
    CustomLogFilter filter = new CustomLogFilter();
    return SerenityRest.with().filter(filter);
  }
}
