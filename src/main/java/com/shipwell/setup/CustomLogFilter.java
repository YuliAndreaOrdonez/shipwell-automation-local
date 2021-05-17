package com.shipwell.setup;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.internal.support.Prettifier;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class CustomLogFilter implements Filter {

  private StringBuilder requestBuilderLogs;
  private StringBuilder responseBuilderLogs;

  @Override
  public Response filter(
      FilterableRequestSpecification filterableRequestSpecification,
      FilterableResponseSpecification filterableResponseSpecification,
      FilterContext filterContext) {
    requestBuilderLogs = new StringBuilder();
    final Prettifier prettifier = new Prettifier();

    Map<String, Object> json = new LinkedHashMap<>();
    Map<String, Object> req = new LinkedHashMap<>();
    Map<String, Object> res = new LinkedHashMap<>();

    Response response = null;

    try {

      req.put("method", objectValidation(filterableRequestSpecification.getMethod()));
      req.put("URI", objectValidation(filterableRequestSpecification.getURI()));
      req.put("form_params", objectValidation(filterableRequestSpecification.getURI()));
      req.put("req_params", objectValidation(filterableRequestSpecification.getRequestParams()));
      req.put("headers", objectValidation(filterableRequestSpecification.getHeaders()));
      req.put("Cookies", objectValidation(filterableRequestSpecification.getCookies()));
      req.put("Proxy", objectValidation(filterableRequestSpecification.getProxySpecification()));

      requestBuilderLogs.append("\n");
      requestBuilderLogs.append(
          "Request method: " + objectValidation(filterableRequestSpecification.getMethod()));
      requestBuilderLogs.append("\n");
      requestBuilderLogs.append(
          "Request URI: " + objectValidation(filterableRequestSpecification.getURI()));
      requestBuilderLogs.append("\n");
      requestBuilderLogs.append(
          "Form Params: " + objectValidation(filterableRequestSpecification.getFormParams()));
      requestBuilderLogs.append("\n");
      requestBuilderLogs.append(
          "Request Param: " + objectValidation(filterableRequestSpecification.getRequestParams()));
      requestBuilderLogs.append("\n");
      requestBuilderLogs.append(
          "Headers: " + objectValidation(filterableRequestSpecification.getHeaders()));
      requestBuilderLogs.append("\n");
      requestBuilderLogs.append(
          "Cookies: " + objectValidation(filterableRequestSpecification.getCookies()));
      requestBuilderLogs.append("\n");
      requestBuilderLogs.append(
          "Proxy: " + objectValidation(filterableRequestSpecification.getProxySpecification()));
      requestBuilderLogs.append("\n");

      if (Objects.nonNull(filterableRequestSpecification.getBody())) {
        req.put("Body", prettifier.getPrettifiedBodyIfPossible(filterableRequestSpecification));
        requestBuilderLogs.append(
            "Body: " + prettifier.getPrettifiedBodyIfPossible(filterableRequestSpecification));
      }

      json.put("req", req);

      response =
          filterContext.next(filterableRequestSpecification, filterableResponseSpecification);

      res.put("status_code", response.getStatusCode());
      res.put("status_line", response.getStatusLine());
      res.put("cookies", response.getDetailedCookies());
      res.put("content_type", response.getContentType());
      res.put("header", response.getHeaders());
      res.put("body", prettifier.getPrettifiedBodyIfPossible(response, response.getBody()));

      json.put("res", res);

      requestBuilderLogs.append("\n");
      requestBuilderLogs.append("******************************");
      responseBuilderLogs = new StringBuilder();
      responseBuilderLogs.append("\n" + "\n" + "\n");
      responseBuilderLogs.append("Status Code: " + response.getStatusCode());
      responseBuilderLogs.append("\n");
      responseBuilderLogs.append("Status Line: " + response.getStatusLine());
      responseBuilderLogs.append("\n");
      responseBuilderLogs.append("Response Cookies: " + response.getDetailedCookies());
      responseBuilderLogs.append("\n");
      responseBuilderLogs.append("Response Content Type: " + response.getContentType());
      responseBuilderLogs.append("\n");
      responseBuilderLogs.append("Response Headers: " + response.getHeaders());
      responseBuilderLogs.append("\n");
      responseBuilderLogs.append(
          "Response Body: "
              + "\n"
              + prettifier.getPrettifiedBodyIfPossible(response, response.getBody()));

    } catch (Exception e) {
      if (json.get("res") == null) {
        res.put("error", e.getMessage());
        json.put("res", res);
        SharedRACucumberInfo.AddCurrentRestData(json);
      }
      throw e;
    }

    SharedRACucumberInfo.AddCurrentRestData(json);
    return response;
  }

  public String getRequestBuilder() {
    return requestBuilderLogs.toString();
  }

  public String getResponseBuilder() {
    return responseBuilderLogs.toString();
  }

  public String objectValidation(Object o) {
    if (o == null) return null;
    else return o.toString();
  }
}
