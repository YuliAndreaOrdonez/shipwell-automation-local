package com.shipwell.setup;

import java.util.ArrayList;
import java.util.Map;

public class SharedRACucumberInfo {
  private static ArrayList<Map<String, Object>> CurrentRestData = null;

  private SharedRACucumberInfo() {}

  public static void AddCurrentRestData(Map<String, Object> step) {
    if (CurrentRestData == null) {
      CurrentRestData = new ArrayList<Map<String, Object>>();
    }
    CurrentRestData.add(step);
  }

  public static Object[] getCurrentRestData() {
    if (CurrentRestData == null) return null;
    return CurrentRestData.toArray();
  }

  public static void reset() {
    CurrentRestData = null;
  }
}
