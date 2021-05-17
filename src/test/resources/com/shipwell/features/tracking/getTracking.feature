#language: en

Feature: As shipwell I want to get tracking
  As a Shipwell
  I want to get tracking

  @trackingGet @trackingGetSuccess @test @tracking
  Scenario Outline: I get tracking successfully
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try to find shipment <shipmentId> and carrier <carrier> tracking
    Then validate status and tracking created correctly

    Examples:
      |companyAuth|userIdAuth|shipmentId|carrier|
#      |    123    |  gbhytrd | TESTONLY |CIAN   |
      |    003    |  gbhytrd | TESTONLY1|CLLQ   |
#      |    123    |  gbhytrd | TESTONLY2|UFLB   |

  @trackingGet @trackingGetSuccessShipmentDoesnExist @test @tracking
  Scenario Outline: I get tracking when shipment id doesn't exists
    Given shipwell wants to authenticate <companyAuth>, <userIdAuth>
    When shipwell try to find shipment <shipmentId> and carrier <carrier> tracking
    Then validate status and tracking dont get correctly

    Examples:
      |companyAuth|userIdAuth|shipmentId|carrier|
      |    003    |  gbhytrd | TESTONLY12|CLLQ   |