package com.shipwell.utils;

import java.sql.*;

public class DB {

  public static String url = "jdbc:postgresql://localhost:5432/carrierconnectionsdev";
  public static String user = "shipwell";
  public static String password = "tOJUrxRuliiFSCeTHcvO";

  public static void deleteCarrier(String scacCode) {
    String query = String.format("DELETE FROM carrier WHERE scac_code='%s'", scacCode);
    try {
      Connection con = DriverManager.getConnection(DB.url, DB.user, DB.password);
      PreparedStatement pst = con.prepareStatement(query);
        pst.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
  }

  public static void deleteCompany(String company) {
    String query = String.format("delete from company c2 where company_id='%s'", company);
    try {
      Connection con = DriverManager.getConnection(DB.url, DB.user, DB.password);
      PreparedStatement pst = con.prepareStatement(query);
      pst.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void deleteQuoteShipment(String shipment) {
    String query = String.format("delete from rating where shipment_id in ( select id from shipment where shipment_id='%s')", shipment);
    try {
      Connection con = DriverManager.getConnection(DB.url, DB.user, DB.password);
      PreparedStatement pst = con.prepareStatement(query);
      pst.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void deleteCompanyContract(String companyId) {
    String query = String.format("delete from contract where company_id in ( select id from company where company_id='%s')", companyId);
    try {
      Connection con = DriverManager.getConnection(DB.url, DB.user, DB.password);
      PreparedStatement pst = con.prepareStatement(query);
      pst.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void deleteCompanyBooking(String companyId) {
    String query = String.format("delete from booking where shipment_id in (select id from shipment where company_id in ( select id from company where company_id='%s'))", companyId);
    try {
      Connection con = DriverManager.getConnection(DB.url, DB.user, DB.password);
      PreparedStatement pst = con.prepareStatement(query);
      pst.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

    public static void updateContract(Integer contractId, boolean active) {
      String query = String.format("update contract set active = %s where id = %s",active, contractId);
      try {
        Connection con = DriverManager.getConnection(DB.url, DB.user, DB.password);
        PreparedStatement pst = con.prepareStatement(query);
        pst.executeUpdate();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
    }
}
